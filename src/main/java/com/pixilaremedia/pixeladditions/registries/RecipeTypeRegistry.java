package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.recipe.CurrencyConversionRecipe;
import com.pixilaremedia.pixeladditions.recipe.EtchingRecipe;
import com.pixilaremedia.pixeladditions.util.Helper;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class RecipeTypeRegistry {
    public static RecipeType<EtchingRecipe> ETCHING = Helper.unsafeNullcast();
    public static RecipeType<CurrencyConversionRecipe> CURRENCY_CONVERSION = Helper.unsafeNullcast();

    public static void onRegister(final RegisterEvent event) {
        ETCHING = new RecipeType<>() {
            public String toString() {
                return Ref.MOD_ID + ":" + "etching";
            }
        };
        CURRENCY_CONVERSION = new RecipeType<>() {
            public String toString() {
                return Ref.MOD_ID + ":" + "currency_conversion";
            }
        };
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, Ref.location("etching"), () -> ETCHING);
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, Ref.location("currency_conversion"), () -> CURRENCY_CONVERSION);
    }
}
