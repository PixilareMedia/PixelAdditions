package com.pixilaremedia.pixeladditions.registries;

import com.pixilaremedia.pixeladditions.blocks.EtchingBlock;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MusicDiscsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ref.MOD_ID);

    //Saving some space on creating each new sound event.
    private static RegistryObject<SoundEvent> createSound(String id) {
        return SOUNDS.register(id, () -> SoundEvent.createFixedRangeEvent(Ref.location(id), 75.0f));
    }
    //Saving some space on creating each new music disc item.
    private static final Item.Properties MUSIC_DISC = new Item.Properties().stacksTo(1).rarity(Rarity.RARE);

    //Sounds.
    //Songs of the SMP.
    public static final RegistryObject<SoundEvent> SOUND_AINT_NO_CRYING = createSound("music_disc.songs_of_the_smp.aint_no_crying");
    public static final RegistryObject<SoundEvent> SOUND_SYNDICATE = createSound("music_disc.songs_of_the_smp.syndicate");
    public static final RegistryObject<SoundEvent> SOUND_WELCOME_HOME = createSound("music_disc.songs_of_the_smp.welcome_home");
    public static final RegistryObject<SoundEvent> SOUND_BLUE = createSound("music_disc.songs_of_the_smp.blue");
    public static final RegistryObject<SoundEvent> SOUND_IN_MY_HEAD = createSound("music_disc.songs_of_the_smp.in_my_head");
    public static final RegistryObject<SoundEvent> SOUND_KISS_YOUR_DREAMS_GOODBYE = createSound("music_disc.songs_of_the_smp.kiss_your_dreams_goodbye");
    public static final RegistryObject<SoundEvent> SOUND_TURN_BACK_TIME = createSound("music_disc.songs_of_the_smp.turn_back_time");
    public static final RegistryObject<SoundEvent> SOUND_FOUR_AM = createSound("music_disc.songs_of_the_smp.four_am");
    //Records of the SMP.
    public static final RegistryObject<SoundEvent> SOUND_TELL_YOUR_STORY = createSound("music_disc.records_of_the_smp.tell_your_story");
    public static final RegistryObject<SoundEvent> SOUND_WRITE_IT_DOWN = createSound("music_disc.records_of_the_smp.write_it_down");
    public static final RegistryObject<SoundEvent> SOUND_NIGHT_BEFORE_DAWN = createSound("music_disc.records_of_the_smp.night_before_dawn");
    public static final RegistryObject<SoundEvent> SOUND_DOOMSDAY = createSound("music_disc.records_of_the_smp.doomsday");
    public static final RegistryObject<SoundEvent> SOUND_WHY = createSound("music_disc.records_of_the_smp.why");
    public static final RegistryObject<SoundEvent> SOUND_REVIVED = createSound("music_disc.records_of_the_smp.revived");
    public static final RegistryObject<SoundEvent> SOUND_CASINO_ROYALE = createSound("music_disc.records_of_the_smp.casino_royale");
    //Pop Culture Remix's.
    public static final RegistryObject<SoundEvent> SOUND_EVERYBODYS_ROOFTOP_RUN = createSound("music_disc.pop_culture_remixs.everybodys_rooftop_run");
    public static final RegistryObject<SoundEvent> SOUND_I_FOUND_THIS_IN_MY_TRASH_CAN = createSound("music_disc.pop_culture_remixs.i_found_this_in_my_trash_can");
    public static final RegistryObject<SoundEvent> SOUND_EVERYONES_PLATINUM_SEQUEL = createSound("music_disc.pop_culture_remixs.everyones_platinum_sequel");
    public static final RegistryObject<SoundEvent> SOUND_CARAMELLDANSEN_HYPERPOP = createSound("music_disc.pop_culture_remixs.caramelldansen_hyperpop");
    public static final RegistryObject<SoundEvent> SOUND_FOR_THE_SWEDES = createSound("music_disc.pop_culture_remixs.for_the_swedes");
    public static final RegistryObject<SoundEvent> SOUND_YUKAI_YOUNG = createSound("music_disc.pop_culture_remixs.yukai_young");
    //Vanilla Remix's.
    public static final RegistryObject<SoundEvent> SOUND_OTHERSIDE_REMIX = createSound("music_disc.vanilla_remixs.otherside_remix");

    //Blocks & Block Items.
    public static final RegistryObject<Block> BLOCK_ETCHING_TABLE = BLOCKS.register("etching_table", EtchingBlock::new);
    public static final RegistryObject<BlockItem> ITEM_ETCHING_TABLE = ITEMS.register("etching_table", () -> new BlockItem(BLOCK_ETCHING_TABLE.get(), new Item.Properties()));

    //Items.
    public static final RegistryObject<Item> ITEM_OBSIDIAN_PLATES = ITEMS.register("obsidian_plates", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC = ITEMS.register("blank_disc", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC_VANILLA = ITEMS.register("blank_disc_vanilla", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC_SONGS_OF_THE_SMP = ITEMS.register("blank_disc_songs_of_the_smp", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC_RECORDS_OF_THE_SMP = ITEMS.register("blank_disc_records_of_the_smp", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC_POP_CULTURE_REMIXS = ITEMS.register("blank_disc_pop_culture_remixs", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLANK_DISC_VANILLA_REMIXS = ITEMS.register("blank_disc_vanilla_remixs", () -> new Item(new Item.Properties()));
    //Songs of the SMP.
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_AINT_NO_CRYING = ITEMS.register("music_disc_aint_no_crying", () -> new RecordItem(1, SOUND_AINT_NO_CRYING, MUSIC_DISC, 156*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_SYNDICATE = ITEMS.register("music_disc_syndicate", () -> new RecordItem(2, SOUND_SYNDICATE, MUSIC_DISC, 148*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_WELCOME_HOME = ITEMS.register("music_disc_welcome_home", () -> new RecordItem(3, SOUND_WELCOME_HOME, MUSIC_DISC, 228*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_BLUE = ITEMS.register("music_disc_blue", () -> new RecordItem(4, SOUND_BLUE, MUSIC_DISC, 147*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_IN_MY_HEAD = ITEMS.register("music_disc_in_my_head", () -> new RecordItem(5, SOUND_IN_MY_HEAD, MUSIC_DISC, 157*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_KISS_YOUR_DREAMS_GOODBYE = ITEMS.register("music_disc_kiss_your_dreams_goodbye", () -> new RecordItem(6, SOUND_KISS_YOUR_DREAMS_GOODBYE, MUSIC_DISC, 190*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_TURN_BACK_TIME = ITEMS.register("music_disc_turn_back_time", () -> new RecordItem(7, SOUND_TURN_BACK_TIME, MUSIC_DISC, 125*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_FOUR_AM = ITEMS.register("music_disc_four_am", () -> new RecordItem(8, SOUND_FOUR_AM, MUSIC_DISC, 210*20));
    //Records of the SMP.
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_TELL_YOUR_STORY = ITEMS.register("music_disc_tell_your_story", () -> new RecordItem(1, SOUND_TELL_YOUR_STORY, MUSIC_DISC, 113*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_WRITE_IT_DOWN = ITEMS.register("music_disc_write_it_down", () -> new RecordItem(2, SOUND_WRITE_IT_DOWN, MUSIC_DISC, 183*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_NIGHT_BEFORE_DAWN = ITEMS.register("music_disc_night_before_dawn", () -> new RecordItem(3, SOUND_NIGHT_BEFORE_DAWN, MUSIC_DISC, 254*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_DOOMSDAY = ITEMS.register("music_disc_doomsday", () -> new RecordItem(4, SOUND_DOOMSDAY, MUSIC_DISC, 226*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_WHY = ITEMS.register("music_disc_why", () -> new RecordItem(5, SOUND_WHY, MUSIC_DISC, 225*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_REVIVED = ITEMS.register("music_disc_revived", () -> new RecordItem(6, SOUND_REVIVED, MUSIC_DISC, 163*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_CASINO_ROYALE = ITEMS.register("music_disc_casino_royale", () -> new RecordItem(7, SOUND_CASINO_ROYALE, MUSIC_DISC, 190*20));
    //Pop Culture Remix's.
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_EVERYBODYS_ROOFTOP_RUN = ITEMS.register("music_disc_everybodys_rooftop_run", () -> new RecordItem(1, SOUND_EVERYBODYS_ROOFTOP_RUN, MUSIC_DISC, 255*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_I_FOUND_THIS_IN_MY_TRASH_CAN = ITEMS.register("music_disc_i_found_this_in_my_trash_can", () -> new RecordItem(2, SOUND_I_FOUND_THIS_IN_MY_TRASH_CAN, MUSIC_DISC, 216*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_EVERYONES_PLATINUM_SEQUEL = ITEMS.register("music_disc_everyones_platinum_sequel", () -> new RecordItem(3, SOUND_EVERYONES_PLATINUM_SEQUEL, MUSIC_DISC, 254*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_CARAMELLDANSEN_HYPERPOP = ITEMS.register("music_disc_caramelldansen_hyperpop", () -> new RecordItem(4, SOUND_CARAMELLDANSEN_HYPERPOP, MUSIC_DISC, 164*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_FOR_THE_SWEDES = ITEMS.register("music_disc_for_the_swedes", () -> new RecordItem(5, SOUND_FOR_THE_SWEDES, MUSIC_DISC, 60*20));
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_YUKAI_YOUNG = ITEMS.register("music_disc_yukai_young", () -> new RecordItem(6, SOUND_YUKAI_YOUNG, MUSIC_DISC, 64*20));
    //Vanilla Remix's.
    public static final RegistryObject<Item> ITEM_MUSIC_DISC_OTHERSIDE_REMIX = ITEMS.register("music_disc_otherside_remix", () -> new RecordItem(1, SOUND_OTHERSIDE_REMIX, MUSIC_DISC, 223*20));
}
