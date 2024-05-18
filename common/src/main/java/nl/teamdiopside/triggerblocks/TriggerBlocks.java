package nl.teamdiopside.triggerblocks;

public class TriggerBlocks
{
	public static final String MOD_ID = "triggerblocks";

	public static void init() {
		BlockRegistry.register();
		ItemRegistry.register();
		BlockEntityRegistry.register();
	}
}
