package com.github.khanshoaib3.minecraft_access.fabric;

import com.github.khanshoaib3.minecraft_access.MainClass;
import com.github.khanshoaib3.minecraft_access.TutorialNetworkingConstants;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class MainClassFabric implements ModInitializer {

    @Override
    public void onInitialize() {
      ServerTest.init();
    }

}

class ServerTest {
  public static void init() {
    // ServerPlayNetworking.send((ServerPlayerEntity) user, TutorialNetworkingConstants.PLAY_PARTICLE_PACKET_ID, PacketByteBufs.empty());
    
  }
}

