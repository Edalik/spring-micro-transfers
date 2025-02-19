package ru.otus.java.pro.mt.core.transfers.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomMetricsService {
    private final Counter customMetricCounter;
    private final Counter customTransfersTotalCounter;
    private final Counter customTransfersSuccessCounter;
    private final Counter customTransfersFailCounter;
    private final AtomicInteger customMetricGauge;

    public CustomMetricsService(MeterRegistry meterRegistry) {
        customMetricCounter = Counter.builder("custom_metric_name")
                .description("Description of custom metric")
                .tags("environment", "development")
                .register(meterRegistry);

        customTransfersTotalCounter = Counter.builder("custom_transfers_total")
                .description("Count of transfers attempted")
                .tags("environment", "development")
                .register(meterRegistry);

        customTransfersSuccessCounter = Counter.builder("custom_transfers_success")
                .description("Count of transfers succeeded")
                .tags("environment", "development")
                .register(meterRegistry);

        customTransfersFailCounter = Counter.builder("custom_transfers_fail")
                .description("Count of transfers failed")
                .tags("environment", "development")
                .register(meterRegistry);

        customMetricGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
    }

    public void incrementCustomMetric() {
        customMetricCounter.increment();
    }

    public void incrementTransfersTotal() {
        customTransfersTotalCounter.increment();
    }

    public void incrementTransfersSuccess() {
        customTransfersSuccessCounter.increment();
    }

    public void incrementTransfersFail() {
        customTransfersFailCounter.increment();
    }

    public void changeCustomGauge() {
        customMetricGauge.set((int)(Math.random() * 1000));
    }
}
