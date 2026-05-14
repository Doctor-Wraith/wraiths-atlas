package com.webthomas.items;

import com.webthomas.networking.ClientBoundOpenAtlas;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;


public class AtlasItem extends Item {

    public AtlasItem(final Item.Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand){
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        ClientBoundOpenAtlas payload = new ClientBoundOpenAtlas();

        ServerPlayNetworking.send((ServerPlayer) player, payload);

        return InteractionResult.SUCCESS;
    }
}
