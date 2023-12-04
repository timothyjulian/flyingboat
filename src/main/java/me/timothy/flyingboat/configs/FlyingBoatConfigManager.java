package me.timothy.flyingboat.configs;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import me.timothy.flyingboat.constants.CommonConstant;
import me.timothy.flyingboat.storage.FlyingBoatConfigStorage;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FlyingBoatConfigManager {

    private static File file;

    private static void prepareConfigFile() {
        if (file != null) {
            return;
        }
        file = new File(FabricLoader.getInstance().getConfigDir().toFile(), CommonConstant.MOD_ID + ".json");
    }

    public static void load() {
        prepareConfigFile();
        if (!file.exists()) save();

        try {
            String configJsonString = Files.readString(file.toPath());
            FlyingBoatConfigStorage.setConfigs(JSONObject.parseObject(configJsonString));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't load Flying Boat configuration file: File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't load Flying Boat configuration file: IOexception");
            e.printStackTrace();
        }
    }

    public static void save() {
        prepareConfigFile();


        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(JSONObject.toJSONString(FlyingBoatConfigStorage.getConfigs(), SerializerFeature.PrettyFormat));
        } catch (IOException e) {
            System.err.println("Couldn't save Flying Boat configuration file");
            e.printStackTrace();
        }
    }


}
