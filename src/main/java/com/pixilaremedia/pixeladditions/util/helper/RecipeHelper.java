package com.pixilaremedia.pixeladditions.util.helper;

import com.pixilaremedia.pixeladditions.recipe.CurrencyConversionRecipe;
import com.pixilaremedia.pixeladditions.recipe.EtchingRecipe;
import com.pixilaremedia.pixeladditions.registries.RecipeTypeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RecipeHelper {
    public static List<EtchingRecipe> getSortedMatchingRecipesEtching(Level level, Container inventory) {
        return level.getRecipeManager().byType(RecipeTypeRegistry.ETCHING)
                .values().stream()
                .filter(recipe -> recipe.matches(inventory, level))
                .sorted(RECIPE_COMPARATOR.apply(level))
                .toList();
    }
    public static List<CurrencyConversionRecipe> getSortedMatchingRecipesCurrency(Level level, Container inventory) {
        return level.getRecipeManager().byType(RecipeTypeRegistry.CURRENCY_CONVERSION)
                .values().stream()
                .filter(recipe -> recipe.matches(inventory, level))
                .sorted(RECIPE_COMPARATOR.apply(level))
                .toList();
    }

    public static final Function<Level, Comparator<Recipe<Container>>> RECIPE_COMPARATOR = level -> Comparator.<Recipe<Container>, String>comparing(recipe -> {
        String[] name = getRegistryPath(recipe.getResultItem(level.registryAccess()).getItem()).split("_");
        return name[name.length - 1];
    }).thenComparing(recipe -> getRegistryName(recipe.getResultItem(level.registryAccess()).getItem()));

    public static String getRegistryPath(Item item) {
        return Optional.ofNullable(ForgeRegistries.ITEMS.getKey(item)).map(ResourceLocation::getPath).map(String::toString).orElse("");
    }

    public static String getRegistryName(Item item) {
        return Optional.ofNullable(ForgeRegistries.ITEMS.getKey(item)).map(ResourceLocation::toString).orElse("");
    }
}
