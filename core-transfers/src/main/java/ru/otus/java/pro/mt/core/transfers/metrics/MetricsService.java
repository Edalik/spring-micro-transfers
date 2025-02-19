package ru.otus.java.pro.mt.core.transfers.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MetricsService {
    private final Counter transfersTotalCounter;
    private final Counter transfersSuccessCounter;
    private final Counter transfersFailCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        transfersTotalCounter = Counter.builder("transfers_total")
                .description("Count of transfers attempted")
                .tags("environment", "development")
                .register(meterRegistry);

        transfersSuccessCounter = Counter.builder("transfers_success")
                .description("Count of transfers succeeded")
                .tags("environment", "development")
                .register(meterRegistry);

        transfersFailCounter = Counter.builder("transfers_fail")
                .description("Count of transfers failed")
                .tags("environment", "development")
                .register(meterRegistry);

    }

    public void incrementTransfersTotal() {
        transfersTotalCounter.increment();
    }

    public void incrementTransfersSuccess() {
        transfersSuccessCounter.increment();
    }

    public void incrementTransfersFail() {
        transfersFailCounter.increment();
    }

}
