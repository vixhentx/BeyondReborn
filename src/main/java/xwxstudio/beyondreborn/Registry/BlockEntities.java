package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.Validate;
import techreborn.init.TRBlockEntities;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.*;

import java.util.Arrays;
import java.util.function.BiFunction;


public class BlockEntities {

    public static final BlockEntityType<RefinerBlockEntity> REFINER = register(RefinerBlockEntity::new, "refiner", BRContent.Machine.REFINER);
    public static final BlockEntityType<SESUBlockEntity> SESU = register(SESUBlockEntity::new, "sesu", BRContent.Machine.SESU);

    public static <T extends BlockEntity> BlockEntityType<T> register(BiFunction<BlockPos, BlockState, T> supplier, String name, ItemConvertible... items) {
        return register(supplier, name, Arrays.stream(items).map(itemConvertible -> Block.getBlockFromItem(itemConvertible.asItem())).toArray(Block[]::new));
    }

    public static <T extends BlockEntity> BlockEntityType<T> register(BiFunction<BlockPos, BlockState, T> supplier, String name, Block... blocks) {
        Validate.isTrue(blocks.length > 0, "no blocks for blockEntity entity type!");
        return TRBlockEntities.register(new Identifier(BeyondRebornMain.MOD_ID, name).toString(), FabricBlockEntityTypeBuilder.create(supplier::apply, blocks));
    }

    public static void init()
    {

    }

}
