package net.reddev.end_reforged.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.reddev.end_reforged.EndReforged;
import net.reddev.end_reforged.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CHORUSWOOD = new SaplingGenerator(EndReforged.MOD_ID + ":chorus_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHORUSWOOD_KEY), Optional.empty());
}