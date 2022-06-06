package ru.alphabank.currency_tracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "feign.giphy.api")
@Getter
@Setter
public class FeignGiphyConfigurationProperties {

    private String url;
    private String key;
    private String rating;

}
