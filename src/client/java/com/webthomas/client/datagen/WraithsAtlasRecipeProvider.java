package com.webthomas.client.datagen;

import com.webthomas.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class WraithsAtlasRecipeProvider extends FabricRecipeProvider {
    public WraithsAtlasRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shapeless(RecipeCategory.TOOLS, ModItems.ATLAS)
                        .requires(Items.WRITABLE_BOOK)
                        .requires(Items.COMPASS)
                        .requires(Items.MAP)
                        .unlockedBy(getHasName(Items.MAP), has(Items.MAP))
                        .save(output);
                ;
            }
        };
    }

    @Override
    public String getName() {
        return "ExampleModRecipeProvider";
    }
}
