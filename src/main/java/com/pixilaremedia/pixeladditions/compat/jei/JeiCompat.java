package com.pixilaremedia.pixeladditions.compat.jei;

import com.pixilaremedia.pixeladditions.registries.MusicDiscsRegistry;
import com.pixilaremedia.pixeladditions.registries.RecipeTypeRegistry;
import com.pixilaremedia.pixeladditions.registries.CurrencyRegistry;
import com.pixilaremedia.pixeladditions.util.Ref;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    private static final ResourceLocation UID = Ref.location("jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(
                new EtchingCategory<>(guiHelper),
                new CurrencyConversionCategory<>(guiHelper)
        );
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        ClientLevel world = Minecraft.getInstance().level;

        if (world != null) {
            RecipeManager manager = world.getRecipeManager();

            registration.addRecipes(JEIRecipeTypes.ETCHING, manager.getAllRecipesFor(RecipeTypeRegistry.ETCHING));
            registration.addRecipes(JEIRecipeTypes.CURRENCY_CONVERSION, manager.getAllRecipesFor(RecipeTypeRegistry.CURRENCY_CONVERSION));
        }
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(MusicDiscsRegistry.BLOCK_ETCHING_TABLE.get()), JEIRecipeTypes.ETCHING);
        registration.addRecipeCatalyst(new ItemStack(CurrencyRegistry.BLOCK_CURRENCY_CONVERSION_TABLE.get()), JEIRecipeTypes.CURRENCY_CONVERSION);
    }
}
