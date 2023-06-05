package com.pixilaremedia.pixeladditions.util.helper;

import com.google.common.collect.ImmutableMap;
import com.pixilaremedia.pixeladditions.registries.CurrencyRegistry;
import com.pixilaremedia.pixeladditions.registries.VillagerRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.coremod.api.ASMAPI;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class VillagerHelper {
    public static void registerVillagerPOI(RegistryObject<PoiType> poi) {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockstates", PoiType.class).invoke(null, poi.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void addVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerRegistry.MAD_SCIENTIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(CurrencyRegistry.ITEM_PIXEL_MONEY_1_CENT.get(), 12);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack, 10, 8, 0.02f
            ));
        }
    }

    public static void registerVillagerTrades(RegistryObject<VillagerProfession> profession, VillagerTrades.ItemListing[] tradeLevel1, VillagerTrades.ItemListing[] tradeLevel2, VillagerTrades.ItemListing[] tradeLevel3, VillagerTrades.ItemListing[] tradeLevel4, VillagerTrades.ItemListing[] tradeLevel5) {
        VillagerTrades.TRADES.put(profession.get(), toIntMap(ImmutableMap.of(1, tradeLevel1, 2, tradeLevel2, 3, tradeLevel3, 4, tradeLevel4, 5, tradeLevel5)));
    }

    public static void registerHOTVLoot(RegistryObject<VillagerProfession> profession, ResourceLocation location) {
        try {
            String name = ASMAPI.mapField("f_147550_");
            Field field = GiveGiftToHero.class.getDeclaredField(name);
            field.setAccessible(true);
            Map<VillagerProfession, ResourceLocation> value = (Map<VillagerProfession, ResourceLocation>) field.get((Object)null);
            value.put(profession.get(), location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> immutableMap) {
        return new Int2ObjectOpenHashMap<>(immutableMap);
    }
}
