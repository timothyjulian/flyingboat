package me.timothy.flyingboat.enums;

import lombok.Getter;
import me.timothy.flyingboat.constants.CommonConstant;

@Getter
public enum ConfigKeyEnum {

    ENABLED("enabled");

    private final String key;

    ConfigKeyEnum(String key) {
        this.key = key;
    }

    public String getTranslationKey() {
        return "option." + CommonConstant.MOD_ID + "." + key;
    }
}
