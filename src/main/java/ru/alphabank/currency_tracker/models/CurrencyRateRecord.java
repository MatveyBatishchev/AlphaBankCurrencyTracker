package ru.alphabank.currency_tracker.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateRecord {

    @JsonAlias({"base"})
    private String baseCurrencyCode;

    private LocalDate parseDate;

    private Map<String, Double> rates;

}
