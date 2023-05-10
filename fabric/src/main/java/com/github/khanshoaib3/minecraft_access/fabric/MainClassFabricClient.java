package com.github.khanshoaib3.minecraft_access.fabric;

import com.github.khanshoaib3.minecraft_access.MainClass;
import com.github.khanshoaib3.minecraft_access.TutorialNetworkingConstants;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class MainClassFabricClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    MainClass.init();
    ClientPlayNetworking.registerGlobalReceiver(TutorialNetworkingConstants.PLAY_PARTICLE_PACKET_ID,
        (client, handler, buf, responseSender) -> {

        });
  }
}
