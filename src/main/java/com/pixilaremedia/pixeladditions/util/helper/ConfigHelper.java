package com.pixilaremedia.pixeladditions.util.helper;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHelper {
    public static boolean booleanTest(ForgeConfigSpec.BooleanValue option) {
        return option.get();
    }
    public static int intTest(ForgeConfigSpec.IntValue option) {
        return option.get();
    }
    public static double doubleTest(ForgeConfigSpec.DoubleValue option) {
        return option.get();
    }
    public static long longTest(ForgeConfigSpec.LongValue option) {
        return option.get();
    }
}
