package ru.alphabank.currency_tracker;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.io.IOException;
import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class FeignClientsMocks {

        public static void setupMockExchangeRateResponse(WireMockServer mockService) throws IOException {
            mockService.stubFor(WireMock.get(WireMock.urlMatching("/historical/(.*).json\\?app_id(.*)&symbols(.*)&base(.*)"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(HttpStatus.OK.value())
                            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                            .withBody(
                                    copyToString(
                                            FeignClientsMocks.class.getClassLoader().getResourceAsStream("get-exchangeRates-getCurrencyRate-response.json"),
                                            defaultCharset()))));
        }

        public static void setupMockGiphyResponse(WireMockServer mockService) throws IOException {
            mockService.stubFor(WireMock.get(WireMock.urlMatching("/v1/gifs/random\\?api_key(.*)&tag(.*)&rating(.*)"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(HttpStatus.OK.value())
                            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                            .withBody(
                                    copyToString(
                                            FeignClientsMocks.class.getClassLoader().getResourceAsStream("get-giphy-getRandomGif-response.json"),
                                            defaultCharset()))));
        }

}