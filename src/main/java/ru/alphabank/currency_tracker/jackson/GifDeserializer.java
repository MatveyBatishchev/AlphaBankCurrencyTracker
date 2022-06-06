package ru.alphabank.currency_tracker.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.alphabank.currency_tracker.models.Gif;

import java.io.IOException;

public class GifDeserializer extends StdDeserializer<Gif> {

    public GifDeserializer() {
        this(null);
    }

    public GifDeserializer(Class<Gif> vc) {
        super(vc);
    }

    @Override
    public Gif deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        node = node.get("data");
        String title = node.get("title").asText();
        String rating = node.get("rating").asText();
        String giphyUrl = node.get("url").asText();
        String gifUrl = node.get("images").get("original").get("url").asText();
        return new Gif(title, rating, giphyUrl, gifUrl);
    }

}