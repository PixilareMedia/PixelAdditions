package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.blocks.CurrencyConversionBlock;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CurrencyRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MOD_ID);

    //Blocks & Block Items.
    public static final RegistryObject<Block> BLOCK_CURRENCY_CONVERSION_TABLE = BLOCKS.register("currency_conversion_table", CurrencyConversionBlock::new);
    public static final RegistryObject<BlockItem> ITEM_CURRENCY_CONVERSION_TABLE = ITEMS.register("currency_conversion_table", () -> new BlockItem(BLOCK_CURRENCY_CONVERSION_TABLE.get(), new Item.Properties()));

    //Items.
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_1_CENT = ITEMS.register("pixel_1_cent", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_5_CENTS = ITEMS.register("pixel_5_cents", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_10_CENTS = ITEMS.register("pixel_10_cents", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_25_CENTS = ITEMS.register("pixel_25_cents", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_50_CENTS = ITEMS.register("pixel_50_cents", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_1_DOLLAR = ITEMS.register("pixel_1_dollar", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_2_DOLLARS = ITEMS.register("pixel_2_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_5_DOLLARS = ITEMS.register("pixel_5_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_10_DOLLARS = ITEMS.register("pixel_10_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_20_DOLLARS = ITEMS.register("pixel_20_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_25_DOLLARS = ITEMS.register("pixel_25_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_50_DOLLARS = ITEMS.register("pixel_50_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_100_DOLLARS = ITEMS.register("pixel_100_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_500_DOLLARS = ITEMS.register("pixel_500_dollars", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIXEL_MONEY_1000_DOLLARS = ITEMS.register("pixel_1000_dollars", () -> new Item(new Item.Properties()));
}
