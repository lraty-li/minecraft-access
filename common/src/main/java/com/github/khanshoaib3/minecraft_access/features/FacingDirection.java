package com.github.khanshoaib3.minecraft_access.features;

import com.github.khanshoaib3.minecraft_access.MainClass;
import com.github.khanshoaib3.minecraft_access.utils.PlayerPositionUtils;
import com.github.khanshoaib3.minecraft_access.utils.PositionUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.InputUtil;

/**
 * Adds key binding to speak the player's facing direction.<br>
 * - Speak Facing Direction Key (default: H) = Speaks the player facing direction.
 */
public class FacingDirection {
    public void update() {
        try {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            if (minecraftClient == null) return;
            if (minecraftClient.player == null) return;
            if (minecraftClient.currentScreen != null) return;

            boolean isDirectionNarrationKeyPressed = MainClass.keyBindingsHandler.isPressed(MainClass.keyBindingsHandler.directionNarrationKey);
            if (!isDirectionNarrationKeyPressed) return;

            boolean isLeftAltPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(),
                    InputUtil.fromTranslationKey("key.keyboard.left.alt").getCode());

            String toSpeak;
            if (isLeftAltPressed) {
                int angle = new PlayerPositionUtils(minecraftClient).getVerticalFacingDirection();
                toSpeak = PositionUtils.getNarratableNumber(angle);
            } else {

                /* TODO add to config and add left alt combination to readme
                int angle = new PlayerPositionUtils(minecraftClient).getHorizontalFacingDirectionInDegrees();
                if (Config.get(Config.getCardinal_to_Degrees_Key())) {
                    toSpeak += angle;
                } else {
                */
                String string = new PlayerPositionUtils(minecraftClient).getHorizontalFacingDirectionInCardinal();
                toSpeak = I18n.translate("minecraft_access.other.facing_direction", string);
                // }
            }

            MainClass.speakWithNarrator(toSpeak, true);
        } catch (Exception e) {
            MainClass.errorLog("An error occurred in DirectionNarrator.");
            e.printStackTrace();
        }
    }
}
