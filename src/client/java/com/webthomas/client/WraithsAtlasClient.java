package com.webthomas.client;

import com.webthomas.client.screens.AtlasScreen;
import com.webthomas.networking.ClientBoundOpenAtlas;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;

public class WraithsAtlasClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientPlayNetworking.registerGlobalReceiver(ClientBoundOpenAtlas.TYPE, ((_, context) -> {
			ClientLevel level = context.client().level;
			if (level == null) {
				return;
			}

			Minecraft.getInstance().setScreen(new AtlasScreen(Component.literal("Atlas")));
		}));
	}
}