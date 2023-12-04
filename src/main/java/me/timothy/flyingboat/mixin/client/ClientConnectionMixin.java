package me.timothy.flyingboat.mixin.client;

import me.timothy.flyingboat.enums.ConfigKeyEnum;
import me.timothy.flyingboat.storage.FlyingBoatConfigStorage;
import me.timothy.flyingboat.util.LogUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.ClientConnection;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    // maximum tick for flying
    private static int tick = 75;

    // override gravity
    private static final double DOWN_VELOCITY_WORKAROUND = -0.032;

    @Inject(at = @At("HEAD"), method = "tick()V", cancellable = true)
    public void tick(CallbackInfo callbackInfo) {

        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ClientPlayerEntity clientPlayerEntity = minecraftClient == null ? null : minecraftClient.player;
        if (clientPlayerEntity != null && clientPlayerEntity.hasVehicle() && FlyingBoatConfigStorage.defaultBooleanIfNull(ConfigKeyEnum.ENABLED.getKey(), true)) {
            Entity vehicle = clientPlayerEntity.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = DOWN_VELOCITY_WORKAROUND;
            if (minecraftClient.options.jumpKey.isPressed()) motionY = 0.3;
            else if (minecraftClient.options.sprintKey.isPressed()) motionY = -0.3;

            if (tick == 0) {
                tick = 40;
                motionY = DOWN_VELOCITY_WORKAROUND;
                LogUtil.info("Down velocity working");
            }
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
            tick--;

        }

    }

}
