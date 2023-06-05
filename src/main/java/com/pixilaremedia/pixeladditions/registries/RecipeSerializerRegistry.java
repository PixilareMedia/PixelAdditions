package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.recipe.CurrencyConversionRecipe;
import com.pixilaremedia.pixeladditions.recipe.EtchingRecipe;
import com.pixilaremedia.pixeladditions.util.Helper;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class RecipeSerializerRegistry {
    public static RecipeSerializer<EtchingRecipe> ETCHING = Helper.unsafeNullcast();
    public static RecipeSerializer<CurrencyConversionRecipe> CURRENCY_CONVERSION = Helper.unsafeNullcast();

    public static void onRegister(final RegisterEvent event) {
        ETCHING = new SingleItemRecipe.Serializer<>(EtchingRecipe::new) {};
        CURRENCY_CONVERSION = new SingleItemRecipe.Serializer<>(CurrencyConversionRecipe::new) {};
        event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Ref.location("etching"), () -> ETCHING);
        event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Ref.location("currency_conversion"), () -> CURRENCY_CONVERSION);
    }
}
