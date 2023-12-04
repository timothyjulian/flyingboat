package me.timothy.flyingboat.configs;

import me.timothy.flyingboat.enums.ConfigKeyEnum;
import me.timothy.flyingboat.storage.FlyingBoatConfigStorage;
import me.timothy.flyingboat.util.LogUtil;
import net.minecraft.client.option.SimpleOption;

import java.util.ArrayList;

public class FlyingBoatConfig {

    public static SimpleOption<?>[] asOptions() {
        ArrayList<SimpleOption<?>> options = new ArrayList<>();
        options.add(
                SimpleOption.ofBoolean(
                        ConfigKeyEnum.ENABLED.getTranslationKey(),
                        FlyingBoatConfigStorage.defaultBooleanIfNull(ConfigKeyEnum.ENABLED.getKey(), true),
                        newValue -> FlyingBoatConfigStorage.getConfigs().put(ConfigKeyEnum.ENABLED.getKey(), newValue)
                )
        );


        return options.toArray(SimpleOption[]::new);
    }

}
