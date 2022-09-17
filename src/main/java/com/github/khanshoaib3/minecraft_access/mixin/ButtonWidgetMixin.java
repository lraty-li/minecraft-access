package com.github.khanshoaib3.minecraft_access.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.MerchantScreen;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ButtonWidget.class)
public class ButtonWidgetMixin {
    @Inject(at = @At("HEAD"), method = "appendNarrations", cancellable = true)
    private void appendNarrations(NarrationMessageBuilder builder, CallbackInfo callbackInfo) {
        if(MinecraftClient.getInstance().currentScreen instanceof MerchantScreen) callbackInfo.cancel();
    }
}
