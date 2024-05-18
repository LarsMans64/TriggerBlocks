package nl.teamdiopside.triggerblocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TriggerBlocks.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> TRIGGER_FIELD = blockItem("trigger_field", BlockRegistry.TRIGGER_FIELD);
    public static final RegistrySupplier<Item> SIMPLE_TRIGGER = blockItem("simple_trigger", BlockRegistry.SIMPLE_TRIGGER);

    public static RegistrySupplier<Item> blockItem(String name, RegistrySupplier<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Settings()));
    }

    public static void register() {
        ITEMS.register();
    }
}
