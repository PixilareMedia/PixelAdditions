package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;

public class CreativeTabsRegistry {
    public static void buildOperatorTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.OP_BLOCKS && event.hasPermissions()) {
            event.accept(Items.KNOWLEDGE_BOOK);
            event.accept(Items.ENDER_DRAGON_SPAWN_EGG);
            event.accept(Items.WITHER_SPAWN_EGG);
            event.accept(OperatorRegistry.ITEM_GIANT_SPAWN_EGG);
            event.accept(OperatorRegistry.ITEM_ILLUSIONER_SPAWN_EGG);
            event.accept(OperatorRegistry.ITEM_SPAWNER_MINECART);
            event.accept(OperatorRegistry.ITEM_NETHER_PORTAL);
            event.accept(OperatorRegistry.ITEM_END_PORTAL);
            event.accept(OperatorRegistry.ITEM_END_GATEWAY);
        }
    }

    public static void buildIngredientsTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(Ref.location("ingredients"), builder ->
                builder.title(Ref.groupTranslation("ingredients"))
                        .icon(() -> new ItemStack(IngredientsRegistry.ITEM_MINECOIN.get()))
                        .displayItems((params, output) -> {
                            output.accept(IngredientsRegistry.ITEM_MINECOIN.get());
                            output.accept(IngredientsRegistry.ITEM_BASE_SPAWN_EGG.get());
                            output.accept(IngredientsRegistry.ITEM_SPAWNER_HEART.get());
                        })
        );
    }

    public static void buildMusicDiscsTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(Ref.location("music_discs"), builder ->
                builder.title(Ref.groupTranslation("music_discs"))
                        .icon(() -> new ItemStack(MusicDiscsRegistry.ITEM_ETCHING_TABLE.get()))
                        .displayItems((params, output) -> {
                            output.accept(MusicDiscsRegistry.ITEM_ETCHING_TABLE.get());
                            output.accept(MusicDiscsRegistry.ITEM_OBSIDIAN_PLATES.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC_VANILLA.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC_SONGS_OF_THE_SMP.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC_RECORDS_OF_THE_SMP.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC_POP_CULTURE_REMIXS.get());
                            output.accept(MusicDiscsRegistry.ITEM_BLANK_DISC_VANILLA_REMIXS.get());
                            //Songs of the SMP.
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_AINT_NO_CRYING.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_SYNDICATE.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_WELCOME_HOME.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_BLUE.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_IN_MY_HEAD.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_KISS_YOUR_DREAMS_GOODBYE.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_TURN_BACK_TIME.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_FOUR_AM.get());
                            //Records of the SMP.
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_TELL_YOUR_STORY.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_WRITE_IT_DOWN.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_NIGHT_BEFORE_DAWN.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_DOOMSDAY.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_WHY.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_REVIVED.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_CASINO_ROYALE.get());
                            //Pop Culture.
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_EVERYBODYS_ROOFTOP_RUN.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_I_FOUND_THIS_IN_MY_TRASH_CAN.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_EVERYONES_PLATINUM_SEQUEL.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_CARAMELLDANSEN_HYPERPOP.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_FOR_THE_SWEDES.get());
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_YUKAI_YOUNG.get());
                            //Minecraft Remix.
                            output.accept(MusicDiscsRegistry.ITEM_MUSIC_DISC_OTHERSIDE_REMIX.get());
                        })
        );
    }

    public static void buildCurrencyTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(Ref.location("currency"), builder ->
                builder.title(Ref.groupTranslation("currency"))
                        .icon(() -> new ItemStack(CurrencyRegistry.ITEM_CURRENCY_CONVERSION_TABLE.get()))
                        .displayItems((params, output) -> {
                            output.accept(CurrencyRegistry.ITEM_CURRENCY_CONVERSION_TABLE.get());

                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_1_CENT.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_5_CENTS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_10_CENTS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_25_CENTS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_50_CENTS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_1_DOLLAR.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_2_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_5_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_10_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_20_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_25_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_50_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_100_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_500_DOLLARS.get());
                            output.accept(CurrencyRegistry.ITEM_PIXEL_MONEY_1000_DOLLARS.get());
                        })
        );
    }
}
