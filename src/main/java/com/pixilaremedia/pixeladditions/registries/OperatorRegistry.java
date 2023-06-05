package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OperatorRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);

    //Missing Vanilla Items.
    public static final RegistryObject<Item> ITEM_GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg", () -> new SpawnEggItem(EntityType.GIANT, 51141, 9943682, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_ILLUSIONER_SPAWN_EGG = ITEMS.register("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 1868218, 12171962, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_SPAWNER_MINECART = ITEMS.register("spawner_minecart", () -> new MinecartItem(AbstractMinecart.Type.SPAWNER, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BlockItem> ITEM_NETHER_PORTAL = ITEMS.register("nether_portal", () -> new BlockItem(Blocks.NETHER_PORTAL, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<BlockItem> ITEM_END_PORTAL = ITEMS.register("end_portal", () -> new BlockItem(Blocks.END_PORTAL, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<BlockItem> ITEM_END_GATEWAY = ITEMS.register("end_gateway", () -> new BlockItem(Blocks.END_GATEWAY, new Item.Properties().rarity(Rarity.EPIC)));
}
