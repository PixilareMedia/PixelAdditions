package com.pixilaremedia.pixeladditions.registries;

import com.google.common.collect.ImmutableSet;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillagerRegistry {
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Ref.MOD_ID);
    public static final DeferredRegister<PoiType> POINT_OF_INTREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ref.MOD_ID);

    public static final RegistryObject<PoiType> MAD_SCIENTIST_POI = POINT_OF_INTREST_TYPES.register("mad_scientist", () -> new PoiType(ImmutableSet.copyOf(Blocks.ENCHANTING_TABLE.getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> MAD_SCIENTIST = VILLAGER_PROFESSIONS.register("mad_scientist", () -> new VillagerProfession("mad_scientist", holder -> holder.value().equals(MAD_SCIENTIST_POI.get()), holder -> holder.value().equals(MAD_SCIENTIST_POI.get()), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC));

    public static class Trades {
        public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_1 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_5_DOLLARS.get(), 1, Items.EXPERIENCE_BOTTLE, 16, 16, 2),
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_20_DOLLARS.get(), 1, Items.END_CRYSTAL, 4, 16, 2)
        };
        public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_2 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_50_DOLLARS.get(), 1, Items.HEART_OF_THE_SEA, 2, 16, 4),
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_100_DOLLARS.get(), 1, Items.SHULKER_SHELL, 2, 16, 4)
        };
        public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_3 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_500_DOLLARS.get(), 1, Items.NETHER_STAR, 1, 16, 6),
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_1000_DOLLARS.get(), 1, Items.ELYTRA, 1, 16, 6)
        };
        public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_4 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_1000_DOLLARS.get(), 24, Items.TOTEM_OF_UNDYING, 1, 16, 8),
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_1000_DOLLARS.get(), 48, Items.ENCHANTED_GOLDEN_APPLE, 1, 16, 8)
        };
        public static final VillagerTrades.ItemListing[] MAD_SCIENTIST_LEVEL_5 = new VillagerTrades.ItemListing[] {
                new VillagerTrades.ItemsAndEmeraldsToItems(CurrencyRegistry.ITEM_PIXEL_MONEY_1000_DOLLARS.get(), 64, Items.DRAGON_EGG, 1, 16, 10)
        };
    }
}
