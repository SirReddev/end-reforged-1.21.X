package net.reddev.end_reforged;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.render.RenderLayer;
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

//      REGISTER FLAMMABLE BLOCKS
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LOG_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_WOOD_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LOG_VARIANT1_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LOG_VARIANT2_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_WOOD_VARIANT1_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_WOOD_VARIANT2_BLOCK,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LEAVES_BLOCK,30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LEAVES_VARIANT_BLOCK,30,60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LEAVES_OUTER_BLOCK,30,6);
        LOGGER.info("End Reforged initialized!");
    }
}