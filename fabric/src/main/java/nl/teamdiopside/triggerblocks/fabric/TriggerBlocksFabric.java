package nl.teamdiopside.triggerblocks.fabric;

import nl.teamdiopside.triggerblocks.TriggerBlocks;
import net.fabricmc.api.ModInitializer;

public class TriggerBlocksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TriggerBlocks.init();
    }
}