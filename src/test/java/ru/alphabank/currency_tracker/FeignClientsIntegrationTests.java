package ru.alphabank.currency_tracker;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.alphabank.currency_tracker.controllers.GifController;
import ru.alphabank.currency_tracker.feign.ExchangeRatesClient;
import ru.alphabank.currency_tracker.feign.GiphyClient;

import java.io.IOException;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
class FeignClientsIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private WireMockServer mockCurrencyService;

    @Autowired
    private WireMockServer mockGiphyService;

    @Autowired
    private ExchangeRatesClient exchangeRatesClient;

    @Autowired
    private GiphyClient giphyClient;

    @InjectMocks
    GifController gifController;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUpEach() throws IOException {
        FeignClientsMocks.setupMockExchangeRateResponse(mockCurrencyService);
        FeignClientsMocks.setupMockGiphyResponse(mockGiphyService);
    }

    @Test
    public void notNullFeignClients() {
        Assertions.assertNotNull(exchangeRatesClient.getCurrencyRate("", "", "", ""));
        Assertions.assertNotNull(giphyClient.getRandomGif("", "", ""));
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/gif/currency-rate/dynamics?curr_code=RUB")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("gif"))
                .andExpect(model().attribute("gif", hasProperty("tag", Matchers.equalTo("rich"))))
                .andExpect(view().name("/resultPage"));
    }


}
