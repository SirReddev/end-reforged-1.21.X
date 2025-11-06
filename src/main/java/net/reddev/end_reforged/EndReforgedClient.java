package net.reddev.end_reforged;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.reddev.end_reforged.block.ModBlocks;

import static net.reddev.end_reforged.EndReforged.LOGGER;

public class EndReforgedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("CLIENT LOADED");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_LEAVES_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_LEAVES_VARIANT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_LEAVES_OUTER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_SAPLING, RenderLayer.getCutout());

    }
}
