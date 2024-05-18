package nl.teamdiopside.triggerblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockEntityTickInvoker;
import nl.teamdiopside.triggerblocks.BlockEntityRegistry;
import nl.teamdiopside.triggerblocks.BlockRegistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleTriggerBlockEntity extends BlockEntity {

    public SimpleTriggerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.SIMPLE_TRIGGER.get(), pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SimpleTriggerBlockEntity blockEntity) {

        boolean powered = state.get(SimpleTriggerBlock.POWERED);
        boolean isTriggered = blockEntity.hasTriggeredTriggers();

        if (powered != isTriggered) {
            BlockState newState = state.with(SimpleTriggerBlock.POWERED, isTriggered);
            world.setBlockState(pos, newState);
            Block block = world.getBlockState(pos).getBlock();
            if (block instanceof SimpleTriggerBlock simpleTriggerBlock) {
                simpleTriggerBlock.updateNeighbors(newState, world, pos);
            }
        }
    }

    public boolean hasTriggeredTriggers() {
        Set<BlockPos> checkedPositions = new HashSet<>();
        return this.searchPos(this.pos, checkedPositions);
    }

    public boolean searchPos(BlockPos pos, Set<BlockPos> checkedPositions) {

        for (Direction direction : Direction.values()) {
            BlockPos newPos = pos.offset(direction);
            if (checkedPositions.contains(newPos)) {
                continue;
            }
            checkedPositions.add(newPos);

            BlockState state = this.world.getBlockState(newPos);
            if (state.getBlock() instanceof TriggerFieldBlock) {
                if (state.get(TriggerFieldBlock.TRIGGERED)) {
                    return true;
                }
            } else {
                continue;
            }

            if (this.searchPos(newPos, checkedPositions)) {
                return true;
            }
        }

        return false;
    }
}
