package com.webthomas.networking;

import com.webthomas.WraithsAtlas;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public record ClientBoundOpenAtlas() implements CustomPacketPayload {
    public static final Identifier OPEN_ATLAS_PAYLOAD_ID = Identifier.fromNamespaceAndPath(WraithsAtlas.MOD_ID, "open_atlas");
    public static final CustomPacketPayload.Type<ClientBoundOpenAtlas> TYPE = new CustomPacketPayload.Type<>(OPEN_ATLAS_PAYLOAD_ID);
    public static final ClientBoundOpenAtlas INSTANCE = new ClientBoundOpenAtlas();
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientBoundOpenAtlas> CODEC = StreamCodec.unit(INSTANCE);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
