package com.project.currencyconversionservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.reactive.OnNoRibbonDefaultCondition;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RestTemplate.class)
@Conditional(OnNoRibbonDefaultCondition.class)
public class BlockingLoadbalancerClientConfig {

    @Bean
    @ConditionalOnBean(LoadBalancerClientFactory.class)
    @Primary
    public BlockingLoadBalancerClient blockingLoadBalancerClient(
            LoadBalancerClientFactory loadBalancerClientFactory) {
        return new BlockingLoadBalancerClient(loadBalancerClientFactory);
    }

}
