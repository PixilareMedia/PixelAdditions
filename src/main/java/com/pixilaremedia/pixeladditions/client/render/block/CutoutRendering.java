package com.pixilaremedia.pixeladditions.client.render.block;

import com.pixilaremedia.pixeladditions.registries.CurrencyRegistry;
import com.pixilaremedia.pixeladditions.registries.MusicDiscsRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class CutoutRendering {
    public static void render() {
        ItemBlockRenderTypes.setRenderLayer(MusicDiscsRegistry.BLOCK_ETCHING_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CurrencyRegistry.BLOCK_CURRENCY_CONVERSION_TABLE.get(), RenderType.cutout());
    }
}
