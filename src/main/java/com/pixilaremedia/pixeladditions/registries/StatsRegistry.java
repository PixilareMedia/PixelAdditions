package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class StatsRegistry {
    public static final ResourceLocation INTERACT_WITH_ETCHING_TABLE = register("interact_with_etching_table");
    public static final ResourceLocation INTERACT_WITH_CURRENCY_CONVERSION_TABLE = register("interact_with_currency_conversion_table");

    private static ResourceLocation register(String name) {
        return Stats.makeCustomStat(Ref.MOD_ID + ":" + name, StatFormatter.DEFAULT);
    }
}
