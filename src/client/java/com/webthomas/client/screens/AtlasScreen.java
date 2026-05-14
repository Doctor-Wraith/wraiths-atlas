package com.webthomas.client.screens;


import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;

import net.minecraft.network.chat.Component;

public class AtlasScreen extends Screen {
    public AtlasScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        this.addRenderableWidget(
                Button.builder(Component.literal("Close"), btn -> this.onClose())
                        .bounds(this.width / 2 - 60, this.height / 2, 120, 20)
                        .build()
        );
    }
}
