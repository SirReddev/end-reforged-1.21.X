package net.reddev.end_reforged;

import net.fabricmc.api.ModInitializer;
import net.reddev.end_reforged.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndReforged implements ModInitializer {
    public static final String MOD_ID = "end_reforged";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register blocks
        ModBlocks.registerModBlocks();
        LOGGER.info("Blocks registered for {}", MOD_ID);

        // ALL BIOME REGISTRATION IS HANDLED BY ModTerrablenderAPI AND DATAGEN
        LOGGER.info("End Reforged initialized!");

    }
}