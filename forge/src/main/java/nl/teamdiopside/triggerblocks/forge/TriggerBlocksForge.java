package nl.teamdiopside.triggerblocks.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import nl.teamdiopside.triggerblocks.TriggerBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.teamdiopside.triggerblocks.TriggerBlocksClient;

@Mod(TriggerBlocks.MOD_ID)
public class TriggerBlocksForge {
    public TriggerBlocksForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(TriggerBlocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TriggerBlocks.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TriggerBlocksClient::init);
    }
}