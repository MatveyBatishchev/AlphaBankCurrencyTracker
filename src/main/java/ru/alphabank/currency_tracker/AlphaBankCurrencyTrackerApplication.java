package ru.alphabank.currency_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan("ru.alphabank.currency_tracker.config")
public class AlphaBankCurrencyTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaBankCurrencyTrackerApplication.class, args);
    }

}

// curl -X GET http://localhost:8080/gif/currency-rate/dynamics?curr_code=RUB
