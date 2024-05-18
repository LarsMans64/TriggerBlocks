package nl.teamdiopside.triggerblocks.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import nl.teamdiopside.triggerblocks.BlockRegistry;
import nl.teamdiopside.triggerblocks.TriggerBlocks;
import nl.teamdiopside.triggerblocks.TriggerBlocksClient;

public class TriggerBlocksFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TriggerBlocksClient.init();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                BlockRegistry.TRIGGER_FIELD.get(),
                BlockRegistry.SIMPLE_TRIGGER.get());
    }
}