package nl.teamdiopside.triggerblocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import nl.teamdiopside.triggerblocks.block.SimpleTriggerBlock;
import nl.teamdiopside.triggerblocks.block.TriggerFieldBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(TriggerBlocks.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Block> TRIGGER_FIELD = BLOCKS.register("trigger_field", () -> new TriggerFieldBlock(AbstractBlock.Settings.create().noCollision().nonOpaque()));
    public static final RegistrySupplier<Block> SIMPLE_TRIGGER = BLOCKS.register("simple_trigger", () -> new SimpleTriggerBlock(AbstractBlock.Settings.create().noCollision().nonOpaque()));

    public static void register() {
        BLOCKS.register();
    }
}
