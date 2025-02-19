package ru.otus.java.pro.mt.core.transfers.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.otus.java.pro.mt.core.transfers.configs.properties.LimitsIntegrationProperties;

@Configuration
@RequiredArgsConstructor
public class RestClientsConfig {

    private final RestClientFactory restClientFactory;

    private final LimitsIntegrationProperties limitsIntegrationProperties;

    // @Bean
    public RestTemplate commonRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestClient limitsClient() {
        return restClientFactory.createRestClient(limitsIntegrationProperties.getRestClient());
    }

}
