package com.pixilaremedia.pixeladditions.client.render;

import com.pixilaremedia.pixeladditions.client.gui.CurrencyConversionScreen;
import com.pixilaremedia.pixeladditions.client.gui.EtchingScreen;
import com.pixilaremedia.pixeladditions.registries.MenuTypeRegistry;
import net.minecraft.client.gui.screens.MenuScreens;

public class ScreenRendering {
    public static void render() {
        MenuScreens.register(MenuTypeRegistry.ETCHING.get(), EtchingScreen::new);
        MenuScreens.register(MenuTypeRegistry.CURRENCY_CONVERSION.get(), CurrencyConversionScreen::new);
    }
}
