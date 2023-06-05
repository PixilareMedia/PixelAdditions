package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.container.CurrencyConversionContainer;
import com.pixilaremedia.pixeladditions.container.EtchingContainer;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Ref.MOD_ID);

    public static final RegistryObject<MenuType<EtchingContainer>> ETCHING = MENUS.register("etching", () -> new MenuType<>(EtchingContainer::new, FeatureFlags.DEFAULT_FLAGS));
    public static final RegistryObject<MenuType<CurrencyConversionContainer>> CURRENCY_CONVERSION = MENUS.register("currency_conversion", () -> new MenuType<>(CurrencyConversionContainer::new, FeatureFlags.DEFAULT_FLAGS));
}
