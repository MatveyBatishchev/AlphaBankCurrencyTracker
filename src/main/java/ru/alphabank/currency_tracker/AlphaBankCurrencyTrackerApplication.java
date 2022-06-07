package ru.alphabank.currency_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"ru.alphabank.currency_tracker.*"})
public class AlphaBankCurrencyTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaBankCurrencyTrackerApplication.class, args);
    }

}

// java -jar build/libs/AlphaBankCurrencyTracker-0.0.1-SNAPSHOT.jar

// curl -X GET http://localhost:8080/gif/currency-rate/dynamics?curr_code=RUB
