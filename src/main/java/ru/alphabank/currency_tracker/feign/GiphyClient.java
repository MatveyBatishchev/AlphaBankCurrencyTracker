package ru.alphabank.currency_tracker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alphabank.currency_tracker.models.Gif;

@FeignClient(value = "giphyClient", url = "${feign.giphy.api.url}")
public interface GiphyClient {

    @GetMapping("v1/gifs/random")
    Gif getRandomGif(@RequestParam("api_key") String apiKey,
                     @RequestParam("tag") String tag,
                     @RequestParam("rating") String rating);

}
