package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IngredientsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);

    public static final RegistryObject<Item> ITEM_MINECOIN = ITEMS.register("minecoin", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ITEM_BASE_SPAWN_EGG = ITEMS.register("base_spawn_egg", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_SPAWNER_HEART = ITEMS.register("spawner_heart", () -> new Item(new Item.Properties()));
}
