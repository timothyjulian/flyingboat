package me.timothy.flyingboat.gui;

import me.timothy.flyingboat.configs.FlyingBoatConfig;
import me.timothy.flyingboat.configs.FlyingBoatConfigManager;
import me.timothy.flyingboat.constants.TextKeyConstant;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionListWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class FlyingBoatSettingScreen extends GameOptionsScreen {

    private OptionListWidget list;

    public FlyingBoatSettingScreen(Screen parent) {
        super(parent, MinecraftClient.getInstance().options, Text.translatable(TextKeyConstant.TITLE_MENU));
    }

    @Override
    protected void addOptions() {
        if(this.body != null) {
            this.body.addAll(FlyingBoatConfig.asOptions());
        }

    }

    @Override
    public void removed() {
        FlyingBoatConfigManager.save();
    }

}
