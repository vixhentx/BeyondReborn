package xwxstudio.beyondreborn.Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import techreborn.blocks.storage.energy.EnergyStorageBlock;
import xwxstudio.beyondreborn.blockentitiy.GuiTypes;
import xwxstudio.beyondreborn.blockentitiy.machine.SESUBlockEntity;

public class SESUBlock extends EnergyStorageBlock {

    public SESUBlock() {
        super("sesu", GuiTypes.SESU);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SESUBlockEntity(pos, state);
    }

}
