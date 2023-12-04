package me.timothy.flyingboat;

import me.timothy.flyingboat.configs.FlyingBoatConfigManager;
import net.fabricmc.api.ClientModInitializer;

public class FlyingBoat implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FlyingBoatConfigManager.load();
	}
}