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

    private Screen previous;
    private OptionListWidget list;

    public FlyingBoatSettingScreen(Screen parent) {
        super(parent, MinecraftClient.getInstance().options, Text.translatable(TextKeyConstant.TITLE_MENU));
        this.previous = parent;
    }

    protected void init() {
        this.list = new OptionListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.list.addAll(FlyingBoatConfig.asOptions());
        this.addSelectableChild(this.list);
        this.addDrawableChild(
                ButtonWidget.builder(ScreenTexts.DONE, (button) -> {
                            FlyingBoatConfigManager.save();
                            if (this.client != null) {
                                this.client.setScreen(this.previous);
                            }
                        }).position(this.width / 2 - 100, this.height - 27)
                        .size(200, 20)
                        .build());
    }


    @Override
    public void render(DrawContext DrawContext, int mouseX, int mouseY, float delta) {
        super.render(DrawContext, mouseX, mouseY, delta);
        this.list.render(DrawContext, mouseX, mouseY, delta);
        DrawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 5, 0xffffff);
    }

    @Override
    public void removed() {
        FlyingBoatConfigManager.save();
    }

}
