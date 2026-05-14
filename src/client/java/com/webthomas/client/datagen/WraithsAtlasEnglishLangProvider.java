package com.webthomas.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;


import java.util.concurrent.CompletableFuture;

public class WraithsAtlasEnglishLangProvider extends FabricLanguageProvider {
    protected WraithsAtlasEnglishLangProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.wraiths-atlas.atlas", "Atlas");
    }


}
