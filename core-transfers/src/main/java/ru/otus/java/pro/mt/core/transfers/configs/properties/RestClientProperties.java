package ru.otus.java.pro.mt.core.transfers.configs.properties;

import lombok.Data;

import java.time.Duration;

@Data
public class RestClientProperties {
    private String url;
    private Duration readTimeout;
    private Duration connectTimeout;
}