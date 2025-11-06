package net.reddev.end_reforged.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

// NOTE: Ensure you import your ModBlocks class where END_NYLIUM_BLOCK is registered.
// Example: import net.reddev.end_reforged.registry.ModBlocks;
import net.reddev.end_reforged.block.ModBlocks; // Placeholder import

public class ChorusSaplingBlock extends SaplingBlock {

    public ChorusSaplingBlock(SaplingGenerator generator, AbstractBlock.Settings settings) {
        super(generator, settings);
    }

    /**
     * Overrides the method that determines if a block state is valid soil for this plant.
     * This version checks for:
     * 1. All vanilla blocks that saplings can grow on (via super.canPlantOnTop).
     * 2. Your specific custom blocks (END_STONE and END_NYLIUM_BLOCK).
     */
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        // Check 1: Allow placement on all standard vanilla sapling soil blocks (Grass, Dirt, etc.)
        boolean vanillaGrowBlocks = super.canPlantOnTop(floor, world, pos);

        // Check 2: Allow placement on your custom blocks (End Stone, End Nylium)
        boolean customGrowBlocks = floor.isOf(ModBlocks.END_NYLIUM_BLOCK) || floor.isOf(ModBlocks.END_MOSS_BLOCK);

        // If EITHER the vanilla check or the custom check passes, placement is allowed.
        return vanillaGrowBlocks || customGrowBlocks;
    }

    // This method is called randomly on the client side to display visual effects
    @Override
    public void randomDisplayTick(net.minecraft.block.BlockState state, World world, BlockPos pos, Random random) {
        // FIX 1: Increase the chance of execution to 70% for an "almost constant" stream.
        if (world.isClient() && random.nextFloat() < 0.7) {

            // FIX 2: Loop 3 times to spawn 3 particles at once
            for (int i = 0; i < 3; i++) {

                // Spawn location: centered above the block with a slight random offset
                double x = (double)pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
                double y = (double)pos.getY() + 0.5 + random.nextDouble() * 0.5; // Spawn slightly above the sapling
                double z = (double)pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.4;

                // Spawn the SCRAPE particle with minimal velocity to make them drift softly
                world.addParticle(
                        ParticleTypes.SCRAPE,
                        x,
                        y,
                        z,
                        (random.nextDouble() - 0.5) * 0.02, // Small X velocity for soft drift
                        (random.nextDouble()) * 0.05,        // Small positive Y velocity for soft rise
                        (random.nextDouble() - 0.5) * 0.02   // Small Z velocity for soft drift
                );
            }
        }
    }
}