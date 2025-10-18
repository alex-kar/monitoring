package io.github.alex_kar.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class Controller {
    private final MeterRegistry meterRegistry;

    public Controller(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/test")
    public String test() {
        Counter counter = Counter.builder("test.counter.total")
                .description("Test counter")
                .tag("id", "123")
                .register(meterRegistry);

        counter.increment();

        return "OK\n";
    }

    @GetMapping("/timer/{delayMs}")
    public String timer(@PathVariable Integer delayMs) throws InterruptedException {
        Timer.Sample start = Timer.start();

        // External API call
        TimeUnit.MILLISECONDS.sleep(delayMs);

        start.stop(Timer.builder("external.api.duration")
                .description("Duration of external API calls")
                .register(meterRegistry));

        return "OK\n";
    }

}
