package ru.otus.java.pro.mt.core.transfers.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("integrations.limits")
public class LimitsIntegrationProperties {
    private RestClientProperties restClient;
}
