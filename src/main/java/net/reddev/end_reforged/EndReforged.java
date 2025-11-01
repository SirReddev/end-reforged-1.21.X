package net.reddev.end_reforged;

import net.fabricmc.api.ModInitializer;

import net.reddev.end_reforged.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndReforged implements ModInitializer {
    public static final String Mod_ID = "end_reforged";
    public static final Logger LOGGER = LoggerFactory.getLogger(Mod_ID);


	@Override
	public void onInitialize() {
        ModBlocks.registerModBlocks();
	}
}