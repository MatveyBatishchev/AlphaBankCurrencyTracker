package ru.alphabank.currency_tracker.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alphabank.currency_tracker.feign.ExchangeRatesClient;
import ru.alphabank.currency_tracker.feign.GiphyClient;
import ru.alphabank.currency_tracker.models.CurrencyRateRecord;
import ru.alphabank.currency_tracker.models.Gif;

import java.time.LocalDate;

@Service
public class GifService {

    @Value("${feign.giphy.api.key}")
    String giphyApiKey;

    @Value("${feign.giphy.api.rating}")
    String giphyRating;

    @Value("${feign.openExchangeRates.api.key}")
    String currencyRateApiKey;

    @Value("${feign.openExchangeRates.api.base_currency}")
    String baseCurrencyCode;

    private final GiphyClient giphyClient;

    private final ExchangeRatesClient exchangeRatesClient;

    public GifService(GiphyClient giphyClient, ExchangeRatesClient exchangeRatesClient) {
        this.giphyClient = giphyClient;
        this.exchangeRatesClient = exchangeRatesClient;
    }

    public Gif getCurrencyTrack(String currencyCode) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        CurrencyRateRecord ydCurrencyRate = exchangeRatesClient.getCurrency(currencyRateApiKey,
                today.toString(), currencyCode, baseCurrencyCode);
        CurrencyRateRecord tdCurrencyRate = exchangeRatesClient.getCurrency(currencyRateApiKey,
                yesterday.toString(), currencyCode, baseCurrencyCode);

        ydCurrencyRate.setParseDate(yesterday);
        tdCurrencyRate.setParseDate(today);

        String tag;
        if (tdCurrencyRate.getRates().get(currencyCode) >= ydCurrencyRate.getRates().get(currencyCode))
            tag = "rich";
        else
            tag = "broke";

        Gif gif = giphyClient.getRandomGif(giphyApiKey, tag, giphyRating);
        gif.setTag(tag);
        return gif;
    }

}
