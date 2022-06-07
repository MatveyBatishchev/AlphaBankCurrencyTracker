package ru.alphabank.currency_tracker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alphabank.currency_tracker.models.CurrencyRateRecord;

@FeignClient(value = "currencyRateClient", url = "${feign.openExchangeRates.api.url}")
public interface ExchangeRatesClient {

    @GetMapping("/historical/{date}.json")
    CurrencyRateRecord getCurrencyRate(@RequestParam("app_id") String appId,
                                   @PathVariable("date") String date,
                                   @RequestParam("symbols") String currencyCodes,
                                   @RequestParam("base") String baseCurrencyCode);

}
