package net.poison.poisonmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.poison.poisonmod.PoisonMod;
import net.poison.poisonmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, PoisonMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.AZURITA_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_AZURITA_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_DEEPSLATE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_END_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_NETHER_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_ORE.get()));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.AZURITA_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_AZURITA_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_DEEPSLATE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_END_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_NETHER_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITA_ORE.get()));

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.AZURITA_END_ORE.get()));
    }
}
