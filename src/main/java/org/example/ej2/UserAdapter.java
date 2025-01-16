package org.example.ej2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class UserAdapter implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jo = jsonElement.getAsJsonObject();
        JsonObject joUser = jo.getAsJsonObject("user");
        String name = joUser.get("first_name").getAsString()+" "+joUser.get("last_name").getAsString();
        User temp = new User(name);
        return temp;
    }
}
