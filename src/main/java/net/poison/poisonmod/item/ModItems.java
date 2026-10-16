package net.poison.poisonmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.poison.poisonmod.PoisonMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PoisonMod.MOD_ID);

    public static final DeferredItem<Item> AZURITA = ITEMS.registerSimpleItem("azurita");
    public static final DeferredItem<Item> P_POWDER = ITEMS.registerSimpleItem("p_powder");
    public static final DeferredItem<Item> RAW_AZURITA = ITEMS.registerSimpleItem("raw_azurita");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
