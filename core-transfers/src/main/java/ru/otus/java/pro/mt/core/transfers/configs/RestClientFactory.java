package ru.otus.java.pro.mt.core.transfers.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.otus.java.pro.mt.core.transfers.configs.properties.RestClientProperties;

@Component
@RequiredArgsConstructor
public class RestClientFactory {

    public RestClient createRestClient(RestClientProperties restClientProperties) {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(restClientProperties.getReadTimeout());
        httpRequestFactory.setConnectTimeout(restClientProperties.getConnectTimeout());

        return RestClient.builder()
                .requestFactory(httpRequestFactory)
                .baseUrl(restClientProperties.getUrl())
                .build();
    }

}