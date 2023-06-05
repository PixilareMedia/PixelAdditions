package com.pixilaremedia.pixeladditions.recipe;

import com.pixilaremedia.pixeladditions.registries.MusicDiscsRegistry;
import com.pixilaremedia.pixeladditions.registries.RecipeSerializerRegistry;
import com.pixilaremedia.pixeladditions.registries.RecipeTypeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EtchingRecipe extends SingleItemRecipe {
    public EtchingRecipe(ResourceLocation location, String group, Ingredient ingredient, ItemStack result) {
        super(RecipeTypeRegistry.ETCHING, RecipeSerializerRegistry.ETCHING, location, group, ingredient, result);
    }

    @Override
    public boolean matches(Container inv, @NotNull Level worldIn) {
        return this.ingredient.test(inv.getItem(0));
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(MusicDiscsRegistry.BLOCK_ETCHING_TABLE.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getResultItem() {
        return this.result;
    }
}
