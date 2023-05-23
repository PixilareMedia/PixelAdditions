package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);

    public static final RegistryObject<Item> MINECOIN = ITEMS.register("minecoin", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
}
