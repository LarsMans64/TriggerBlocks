package nl.teamdiopside.triggerblocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;
import nl.teamdiopside.triggerblocks.block.SimpleTriggerBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(TriggerBlocks.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<SimpleTriggerBlockEntity>> SIMPLE_TRIGGER = BLOCK_ENTITIES.register("simple_trigger", () -> BlockEntityType.Builder.create(SimpleTriggerBlockEntity::new, BlockRegistry.SIMPLE_TRIGGER.get()).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}
