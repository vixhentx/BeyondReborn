package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.Validate;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;


public class BlockEntities {

    public static final BlockEntityType<RefinerBlockEntity> REFINER = Registry.register(Registry.BLOCK_ENTITY_TYPE, BeyondRebornMain.CreateID("refiner"), create(RefinerBlockEntity::new, Blocks.REFINER));

    public static <T extends BlockEntity> BlockEntityType<T> create(FabricBlockEntityTypeBuilder.Factory<T> supplier, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(supplier, blocks).build(null);
    }

    public static void init()
    {

    }

}
