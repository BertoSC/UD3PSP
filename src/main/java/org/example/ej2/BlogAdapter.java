package org.example.ej2;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BlogAdapter implements JsonDeserializer<Blog> {
    @Override
    public Blog deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        JsonObject joBlog = jo.getAsJsonObject("blog");
        String content_html = joBlog.get("content_html").getAsString();
        String title = joBlog.get("title").getAsString();
        String photo_url= joBlog.get("photo_url").getAsString();
        int user_id= joBlog.get("user_id").getAsInt();
        LocalDate updated_at = LocalDateTime.parse(joBlog.get("updated_at").getAsString()).toLocalDate();
        Blog temp = new Blog(content_html, title, photo_url, user_id, updated_at);
        return temp;
    }
}
