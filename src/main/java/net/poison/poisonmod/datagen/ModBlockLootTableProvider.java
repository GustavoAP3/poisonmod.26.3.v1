package net.poison.poisonmod.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.floats.UniformGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.poison.poisonmod.block.ModBlocks;
import net.poison.poisonmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    public ModBlockLootTableProvider(Context output) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), output);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.AZURITA_BLOCK.get());
        dropSelf(ModBlocks.RAW_AZURITA_BLOCK.get());

        add(ModBlocks.AZURITA_ORE.get(),
                createOreDrop(ModBlocks.AZURITA_ORE.get(), ModItems.RAW_AZURITA.get()));
        add(ModBlocks.AZURITA_DEEPSLATE_ORE.get(),
                createOreDrop(ModBlocks.AZURITA_DEEPSLATE_ORE.get(), ModItems.RAW_AZURITA.get()));

        add(ModBlocks.AZURITA_NETHER_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITA_NETHER_ORE.get(), ModItems.RAW_AZURITA.get(), 1, 3));
        add(ModBlocks.AZURITA_END_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITA_END_ORE.get(), ModItems.RAW_AZURITA.get(), 1, 3));

    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, int minDrops, int maxDrops) {
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder) this.applyExplosionDecay(
                        block,
                        ((UniformContainerBase.Builder) LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops))))
                                .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
