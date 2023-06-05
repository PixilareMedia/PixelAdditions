package com.pixilaremedia.pixeladditions.util;

import com.mojang.logging.LogUtils;
import com.pixilaremedia.pixeladditions.PixelAdditions;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class Ref {
    public static PixelAdditions INSTANCE;
    public static final String MOD_ID = "pixeladditions";
    public static final String CONFIG_FILE = MOD_ID + ".toml";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation location(String id) {
        return new ResourceLocation(MOD_ID, id);
    }
    public static ResourceLocation containerTexture(String id) {
        return location("textures/gui/container/" + id);
    }
    public static ResourceLocation heroOfTheVillageGift(String id) {
        return location("gameplay/hero_of_the_village/" + id);
    }
    public static Component groupTranslation(String id) {
        return Component.translatable("item_group." + MOD_ID + "." + id);
    }
    public static Component containerTranslation(String id) {
        return Component.translatable("container." + MOD_ID + "." + id);
    }
    public static Component jeiTranslation(String id) {
        return Component.translatable("jei.category." + MOD_ID + "." + id);
    }
}
