package nl.teamdiopside.triggerblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.List;

public class TriggerFieldBlock extends TriggerBlock {

    public static final BooleanProperty TRIGGERED = Properties.TRIGGERED;

    public TriggerFieldBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TRIGGERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
    }

    // Activate trigger
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient) {
            return;
        }
        world.setBlockState(pos, state.with(TRIGGERED, true));
        world.scheduleBlockTick(pos, this, 1);
    }

    // Deactivate trigger
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(TRIGGERED)) {
            List<Entity> entitiesInside = world.getOtherEntities(null, new Box(pos));
            if (entitiesInside.isEmpty()) {
                world.setBlockState(pos, state.with(TRIGGERED, false));
            }
        }
    }
}
