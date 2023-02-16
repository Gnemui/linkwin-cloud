package com.linkwin.bean;

import com.alibaba.nacos.client.naming.utils.Chooser;
import com.alibaba.nacos.client.naming.utils.Pair;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义负载策略
 * 基于Nacos权重的客户端负载均衡
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 10:55
 */
public class NacosWeightedLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private final String serviceId;
    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    public NacosWeightedLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        this.serviceId = serviceId;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider
                .getIfAvailable(NoopServiceInstanceListSupplier::new);
        return supplier.get().next().map(this::getInstanceResponse);
    }

    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances) {
        if (instances.isEmpty()) {
            System.out.println("No servers available for service: " + this.serviceId);
            return new EmptyResponse();
        }
        ServiceInstance instance = getHostByRandomWeight(instances);
        return new DefaultResponse(instance);
    }

    private ServiceInstance getHostByRandomWeight(List<ServiceInstance> serviceInstances) {
        if (serviceInstances == null || serviceInstances.size() == 0) {
            System.out.println("serviceInstances == null || serviceInstances.size() == 0");
            return null;
        }
        Chooser<String, ServiceInstance> instanceChooser = new Chooser<>("LINKWIN");
        List<Pair<ServiceInstance>> hostsWithWeight = serviceInstances.stream().map(serviceInstance -> new Pair<>(serviceInstance, getWeight(serviceInstance))).collect(Collectors.toList());
        instanceChooser.refresh(hostsWithWeight);
        return instanceChooser.randomWithWeight();
    }

    private double getWeight(ServiceInstance serviceInstance) {
        return Double.parseDouble(serviceInstance.getMetadata().get("nacos.weight"));
    }

}
