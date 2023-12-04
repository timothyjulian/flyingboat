package me.timothy.flyingboat.storage;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

public class FlyingBoatConfigStorage {

    @Getter
    @Setter
    private static JSONObject configs = new JSONObject();

    public static boolean defaultBooleanIfNull(String key, boolean defaultValue) {
        Boolean bool = configs.getBoolean(key);
        if (bool == null) return defaultValue;
        return bool;
    }



}
