package com.webthomas.items;

import com.webthomas.WraithsAtlas;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class ModItems {
    /**
     *
     * @param name The name of the item
     * @param itemFactory How the item properties are created: Item::new
     * @param properties The properties of the item
     * @return The newly created Item
     */
    public static <T extends Item> T registerItem(
            String name,
            Function<Item.Properties, T> itemFactory,
            Item.Properties properties)
    {

        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(WraithsAtlas.MOD_ID, name)
        );

        T item = itemFactory.apply(properties.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    //region New Items

    //public static final Item New_Item = registerItem("new_item", Item::new, new Item.Properties());
    public static final AtlasItem ATLAS =  registerItem("atlas", AtlasItem::new, new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    );

    //endregion

    public static void initialize() {}
}
