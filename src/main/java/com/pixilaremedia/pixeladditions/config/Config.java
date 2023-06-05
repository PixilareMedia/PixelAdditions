package com.pixilaremedia.pixeladditions.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config {
    public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec common;

    static {
        ConfigOptions.init(builder);
        common = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        Ref.LOGGER.info("Loading config " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        Ref.LOGGER.info("Build config " + path);
        file.load();
        Ref.LOGGER.info("Loaded config " + path);
        config.setConfig(file);
    }
}
