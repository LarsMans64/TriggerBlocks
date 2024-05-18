package nl.teamdiopside.triggerblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TriggerBlock extends Block {
    public TriggerBlock(Settings settings) {
        super(settings);
    }

//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        if (world instanceof ClientWorld) {
//            boolean holdingTrigger = false;
//            Iterable<ItemStack> handItems = MinecraftClient.getInstance().player.getHandItems();
//            for (ItemStack item : handItems) {
//                if (item.getItem() == Items.DIAMOND_PICKAXE) {
//                    holdingTrigger = true;
//                }
//            }
//            return holdingTrigger ? VoxelShapes.fullCube() : VoxelShapes.empty();
//        }
//        return super.getOutlineShape(state, world, pos, context);
//    }
}
