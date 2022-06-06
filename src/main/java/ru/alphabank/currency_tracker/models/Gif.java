package ru.alphabank.currency_tracker.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alphabank.currency_tracker.jackson.GifDeserializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = GifDeserializer.class)
public class Gif {

    private String title;
    private String tag;
    private String rating;
    private String giphyUrl;
    private String gifUrl;

    public Gif(String title, String rating, String giphyUrl, String gifUrl) {
        this.title = title;
        this.rating = rating;
        this.giphyUrl = giphyUrl;
        this.gifUrl = gifUrl;
    }

}
