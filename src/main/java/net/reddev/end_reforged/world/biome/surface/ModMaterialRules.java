package net.reddev.end_reforged.world.biome.surface;

import net.minecraft.util.math.VerticalSurfaceType; // 🥳 This import is key!
import net.reddev.end_reforged.block.ModBlocks;
import net.reddev.end_reforged.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {

    private static final MaterialRules.MaterialRule END_NYLIUM = makeStateRule(ModBlocks.END_NYLIUM_BLOCK);
    private static final MaterialRules.MaterialRule END_SLATE = makeStateRule(ModBlocks.END_SLATE_BLOCK);
    private static final MaterialRules.MaterialRule DEEP_END_SLATE = makeStateRule(ModBlocks.DEEP_END_SLATE_BLOCK);
    private static final MaterialRules.MaterialRule LAYERED_END_ROCK = makeStateRule(ModBlocks.LAYERED_END_ROCK_BLOCK);
    private static final MaterialRules.MaterialRule DEEP_LAYERED_END_ROCK = makeStateRule(ModBlocks.DEEP_LAYERED_END_ROCK_BLOCK);
    private static final MaterialRules.MaterialRule DEEP_GREEN_END_ROCK = makeStateRule(ModBlocks.DEEP_GREEN_END_ROCK_BLOCK);
    private static final MaterialRules.MaterialRule END_STONE = makeStateRule(Blocks.END_STONE);


    public static MaterialRules.MaterialRule makeRules() {

        // Define distinct, non-overlapping layers using the correct VerticalSurfaceType.FLOOR

        // Layer 2: END_SLATE (Depth 1-2, 2 blocks thick)
        MaterialRules.MaterialRule endSlateLayer = MaterialRules.condition(
                MaterialRules.stoneDepth(1, true, 2, VerticalSurfaceType.FLOOR), END_SLATE);

        // Layer 3: DEEP_END_SLATE (Depth 3-4, 2 blocks thick)
        MaterialRules.MaterialRule deepEndSlateLayer = MaterialRules.condition(
                MaterialRules.stoneDepth(3, true, 2, VerticalSurfaceType.FLOOR), DEEP_END_SLATE);

        // Layer 4: LAYERED_END_ROCK (Depth 5-7, 3 blocks thick)
        MaterialRules.MaterialRule layeredEndRockLayer = MaterialRules.condition(
                MaterialRules.stoneDepth(5, true, 3, VerticalSurfaceType.FLOOR), LAYERED_END_ROCK);

        // Layer 5: DEEP_LAYERED_END_ROCK (Depth 8-10, 3 blocks thick)
        // Starts exactly where the layer above it ends (offset 5 + range 3 = 8)
        MaterialRules.MaterialRule deepLayeredEndRockLayer = MaterialRules.condition(
                MaterialRules.stoneDepth(8, true, 3, VerticalSurfaceType.FLOOR), DEEP_LAYERED_END_ROCK);

        // 1. Define the custom surface sequence for the End Wilds biome
        MaterialRules.MaterialRule endWildsSurface = MaterialRules.sequence(
                // 1. Top layer (Depth 0)
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, END_NYLIUM),

                // 2. Subsurface layers (Depths 1-10). These are all non-overlapping.
                endSlateLayer,
                deepEndSlateLayer,
                layeredEndRockLayer,
                deepLayeredEndRockLayer, // <-- Placed correctly under LAYERED_END_ROCK

                // 3. Fallback: All stone below the deepest custom layer (Depth 11+)
                DEEP_GREEN_END_ROCK
        );

        // 2. Combine the rules: Apply the custom surface ONLY IF the biome is END_WILD
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(ModBiomes.END_WILDS), endWildsSurface),

                // Fallback: If it's not our biome, the default End Stone rules apply.
                END_STONE
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}