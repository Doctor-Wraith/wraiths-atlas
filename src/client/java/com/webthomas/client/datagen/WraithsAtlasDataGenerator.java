package com.webthomas.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataProvider;

public class WraithsAtlasDataGenerator implements DataGeneratorEntrypoint {

    /**
     * Register {@link DataProvider} with the {@link FabricDataGenerator} during this entrypoint.
     *
     * @param fabricDataGenerator The {@link FabricDataGenerator} instance
     */
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WraithsAtlasRecipeProvider::new);
        pack.addProvider(WraithsAtlasEnglishLangProvider::new);
        pack.addProvider(WraithsAtlasModelProvider::new);
    }

}
