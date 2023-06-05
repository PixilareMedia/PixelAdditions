package com.pixilaremedia.pixeladditions.compat.jei;

import com.pixilaremedia.pixeladditions.recipe.EtchingRecipe;
import com.pixilaremedia.pixeladditions.registries.MusicDiscsRegistry;
import com.pixilaremedia.pixeladditions.util.Ref;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import org.jetbrains.annotations.NotNull;

public class EtchingCategory<T extends SingleItemRecipe> implements IRecipeCategory<EtchingRecipe> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");
    public static final ResourceLocation UID = Ref.location("etching");
    private static final int WIDTH = 116;
    private static final int HEIGHT = 18;
    private final IDrawable background;
    private final IDrawable icon;

    EtchingCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.drawableBuilder(TEXTURE, 49, 168, WIDTH, HEIGHT).addPadding(0, 0, 40, 0).build();
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MusicDiscsRegistry.BLOCK_ETCHING_TABLE.get()));
    }

    @Override
    public @NotNull RecipeType<EtchingRecipe> getRecipeType() {
        return JEIRecipeTypes.ETCHING;
    }

    @Override
    public @NotNull Component getTitle() {
        return Ref.jeiTranslation("etching");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EtchingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addItemStack(recipe.getResultItem());
    }
}
