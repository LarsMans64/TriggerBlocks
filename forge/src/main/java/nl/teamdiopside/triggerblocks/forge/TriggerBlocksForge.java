package nl.teamdiopside.triggerblocks.forge;

import dev.architectury.platform.forge.EventBuses;
import nl.teamdiopside.triggerblocks.TriggerBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TriggerBlocks.MOD_ID)
public class TriggerBlocksForge {
    public TriggerBlocksForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(TriggerBlocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TriggerBlocks.init();
    }
}