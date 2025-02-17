package ru.otus.java.pro.mt.core.transfers.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Data
@ConfigurationProperties("rest.client")
public class RestClientProperties {
    private String url;
    private Duration readTimeout;
    private Duration connectTimeout;
}