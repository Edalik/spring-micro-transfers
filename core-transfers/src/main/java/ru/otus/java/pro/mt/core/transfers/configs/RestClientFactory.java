package ru.otus.java.pro.mt.core.transfers.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.configs.properties.LimitsIntegrationProperties;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

@Component
@RequiredArgsConstructor
public class RestClientFactory {

    private final RestClientProperties restClientProperties;

    private final LimitsIntegrationProperties limitsIntegrationProperties;

    public RestClient createRestClient() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(restClientProperties.getReadTimeout());
        httpRequestFactory.setConnectTimeout(restClientProperties.getConnectTimeout());

        return RestClient.builder()
                .requestFactory(httpRequestFactory)
                .baseUrl(restClientProperties.getUrl())
                .build();
    }

    public RestClient createLimitsClient() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(limitsIntegrationProperties.getReadTimeout());
        httpRequestFactory.setConnectTimeout(limitsIntegrationProperties.getWriteTimeout());

        return RestClient.builder()
                .requestFactory(httpRequestFactory)
                .baseUrl(limitsIntegrationProperties.getUrl())
                .build();
    }

}