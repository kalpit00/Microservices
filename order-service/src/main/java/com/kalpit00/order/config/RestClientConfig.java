package com.kalpit00.order.config;

import com.kalpit00.order.client.InventoryClient;
import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class RestClientConfig {

    @Bean
    public InventoryClient inventoryClient() {
        String inventoryServiceUrl = "http://localhost:8082";
        RestClient restClient = RestClient.builder().baseUrl(inventoryServiceUrl).build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}
