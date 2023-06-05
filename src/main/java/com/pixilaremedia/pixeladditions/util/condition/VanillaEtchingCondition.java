package com.pixilaremedia.pixeladditions.util.condition;

import com.google.gson.JsonObject;
import com.pixilaremedia.pixeladditions.config.ConfigOptions;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaEtchingCondition implements ICondition {
    public static final VanillaEtchingCondition INSTANCE = new VanillaEtchingCondition();
    private static final ResourceLocation NAME = Ref.location("vanilla_etching");

    private VanillaEtchingCondition() {}

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test(IContext context) {
        return ConfigOptions.enableVanillaEtching.get();
    }

    @Override
    public String toString() {
        return String.valueOf(ConfigOptions.enableVanillaEtching);
    }

    public static class Serializer implements IConditionSerializer<VanillaEtchingCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, VanillaEtchingCondition value) {}

        @Override
        public VanillaEtchingCondition read(JsonObject json) {
            return VanillaEtchingCondition.INSTANCE;
        }

        @Override
        public ResourceLocation getID() {
            return VanillaEtchingCondition.NAME;
        }
    }
}
