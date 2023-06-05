package com.pixilaremedia.pixeladditions.compat.jei;

import com.pixilaremedia.pixeladditions.recipe.CurrencyConversionRecipe;
import com.pixilaremedia.pixeladditions.recipe.EtchingRecipe;
import com.pixilaremedia.pixeladditions.util.Ref;
import mezz.jei.api.recipe.RecipeType;

public class JEIRecipeTypes {
    public static final RecipeType<EtchingRecipe> ETCHING = RecipeType.create(Ref.MOD_ID, "etching", EtchingRecipe.class);
    public static final RecipeType<CurrencyConversionRecipe> CURRENCY_CONVERSION = RecipeType.create(Ref.MOD_ID, "currency_conversion", CurrencyConversionRecipe.class);
}
