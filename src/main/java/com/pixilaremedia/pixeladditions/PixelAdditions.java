package com.pixilaremedia.pixeladditions;

import com.google.common.reflect.Reflection;
import com.pixilaremedia.pixeladditions.client.gui.CurrencyConversionScreen;
import com.pixilaremedia.pixeladditions.client.gui.EtchingScreen;
import com.pixilaremedia.pixeladditions.client.render.ScreenRendering;
import com.pixilaremedia.pixeladditions.client.render.block.CutoutRendering;
import com.pixilaremedia.pixeladditions.config.Config;
import com.pixilaremedia.pixeladditions.registries.*;
import com.pixilaremedia.pixeladditions.util.Ref;
import com.pixilaremedia.pixeladditions.util.condition.VanillaEtchingCondition;
import com.pixilaremedia.pixeladditions.util.helper.VillagerHelper;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Ref.MOD_ID)
public class PixelAdditions {
    public PixelAdditions() {
        Ref.INSTANCE = this;
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //Initialize & Load the Config.
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.common, Ref.CONFIG_FILE);
        Config.loadConfig(Config.common, FMLPaths.CONFIGDIR.get().resolve(Ref.CONFIG_FILE).toString());

        //Register Items, Blocks, & all the other stuff that we add.
        IngredientsRegistry.ITEMS.register(bus);
        OperatorRegistry.ITEMS.register(bus);
        MusicDiscsRegistry.ITEMS.register(bus);
        MusicDiscsRegistry.BLOCKS.register(bus);
        MusicDiscsRegistry.SOUNDS.register(bus);
        CurrencyRegistry.ITEMS.register(bus);
        CurrencyRegistry.BLOCKS.register(bus);
        MenuTypeRegistry.MENUS.register(bus);

        //Call a bunch of other things.
        bus.addListener(this::commonSetup);
        bus.addListener(this::registration);
        bus.addListener(this::clientSetup);
        bus.addListener(this::modifyCreative);
        bus.addListener(this::addCreative);

        //Finish all the registering calls.
        MinecraftForge.EVENT_BUS.addListener(this::onServerAboutToStart);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStarting);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        CraftingHelper.register(VanillaEtchingCondition.Serializer.INSTANCE);
        event.enqueueWork(() -> {
            VillagerHelper.registerVillagerTrades(VillagerRegistry.MAD_SCIENTIST, VillagerRegistry.Trades.MAD_SCIENTIST_LEVEL_1, VillagerRegistry.Trades.MAD_SCIENTIST_LEVEL_2, VillagerRegistry.Trades.MAD_SCIENTIST_LEVEL_3, VillagerRegistry.Trades.MAD_SCIENTIST_LEVEL_4, VillagerRegistry.Trades.MAD_SCIENTIST_LEVEL_5);
            VillagerHelper.registerVillagerPOI(VillagerRegistry.MAD_SCIENTIST_POI);
            VillagerHelper.registerHOTVLoot(VillagerRegistry.MAD_SCIENTIST, Ref.heroOfTheVillageGift("mad_scientist"));
        });
        Ref.LOGGER.info("Finished Common Setup.");
    }

    private void registration(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            Reflection.initialize(StatsRegistry.class);
        } else if (event.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)) {
            RecipeSerializerRegistry.onRegister(event);
        } else if (event.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_TYPES)) {
            RecipeTypeRegistry.onRegister(event);
        }
        Ref.LOGGER.info("Finished Random Setup.");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        CutoutRendering.render();
        event.enqueueWork(ScreenRendering::render);
        Ref.LOGGER.info("Finished Client Setup.");
    }

    private void onServerAboutToStart(ServerAboutToStartEvent event) {
        Ref.LOGGER.info("Finished Server About to Start.");
    }

    private void onServerStarting(ServerStartingEvent event) {
        int countEtching = event.getServer().getRecipeManager().getAllRecipesFor(RecipeTypeRegistry.ETCHING).size();
        int countCurrencyConversion = event.getServer().getRecipeManager().getAllRecipesFor(RecipeTypeRegistry.CURRENCY_CONVERSION).size();
        Ref.LOGGER.info(countEtching + " etching recipes loaded.");
        Ref.LOGGER.info(countCurrencyConversion + " currency conversion recipes loaded.");
        Ref.LOGGER.info("Finished Server Starting.");
    }

    private void modifyCreative(CreativeModeTabEvent.BuildContents event) {
        CreativeTabsRegistry.buildOperatorTab(event);
    }
    private void addCreative(CreativeModeTabEvent.Register event) {
        CreativeTabsRegistry.buildIngredientsTab(event);
        CreativeTabsRegistry.buildMusicDiscsTab(event);
        CreativeTabsRegistry.buildCurrencyTab(event);
    }
}
