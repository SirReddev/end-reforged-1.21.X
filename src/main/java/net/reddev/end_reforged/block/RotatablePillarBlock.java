package net.reddev.end_reforged.block;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock; // This provides the AXIS property
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;

public class RotatablePillarBlock extends PillarBlock {

    public RotatablePillarBlock(Settings settings) {
        super(settings);
    }

    /**
     * This is the method that determines the block's state upon placement.
     * It makes the block directional like a standard log.
     */
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // 1. Get the direction of the face the player clicked (the side of the block being placed against).
        Direction clickedFace = ctx.getSide();

        // 2. Get the AXIS (X, Y, or Z) of that clicked face.
        Direction.Axis placementAxis = clickedFace.getAxis();

        // 3. Return the default block state with the AXIS property set to the placement axis.
        return this.getDefaultState().with(AXIS, placementAxis);
    }
}