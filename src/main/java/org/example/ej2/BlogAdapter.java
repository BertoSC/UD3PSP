package org.example.ej2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class BlogAdapter implements JsonDeserializer<Blog> {
    @Override
    public Blog deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        JsonObject joBlog = jo.getAsJsonObject("blog");
        String content_html = joBlog.get("content_html").getAsString();
        String title = joBlog.get("title").getAsString();
        String photo_url= joBlog.get("photo_url").getAsString();

        Blog temp = new Blog(content_html, title, photo_url);
        return temp;
    }
}
