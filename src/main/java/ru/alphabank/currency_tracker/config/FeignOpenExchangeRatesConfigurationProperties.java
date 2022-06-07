package ru.alphabank.currency_tracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "feign.openexchangerates.api")
@Getter
@Setter
public class FeignOpenExchangeRatesConfigurationProperties {

    private String url;
    private String key;
    private String base_currency;

}
