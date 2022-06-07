package ru.alphabank.currency_tracker;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import ru.alphabank.currency_tracker.controllers.GifController;

@TestConfiguration
@ActiveProfiles("test")
public class WireMockConfig {

    @Bean(name="mockCurrencyService", initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockCurrencyService() {
        return new WireMockServer(9564);
    }

    @Bean(name="mockGiphyService", initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockGiphyService() {
        return new WireMockServer(9566);
    }

}
