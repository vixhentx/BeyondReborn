package xwxstudio.beyondreborn.blockentitiy.machine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import reborncore.api.IToolDrop;
import reborncore.api.blockentity.InventoryProvider;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import reborncore.common.powerSystem.PowerAcceptorBlockEntity;
import reborncore.common.powerSystem.RcEnergyTier;
import reborncore.common.util.RebornInventory;
import techreborn.blocks.storage.energy.EnergyStorageBlock;

/**
 * Created by Rushmead
 */
public class NoTickEnergyStorageBlockEntity extends PowerAcceptorBlockEntity implements IToolDrop, InventoryProvider {

    public RebornInventory<NoTickEnergyStorageBlockEntity> inventory;
    public String name;
    public Block wrenchDrop;
    public int maxInput;
    public int maxOutput;
    public int maxStorage;

    public NoTickEnergyStorageBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, String name, int invSize, Block wrenchDrop, RcEnergyTier tier, int maxStorage) {
        super(blockEntityType, pos, state);
        inventory = new RebornInventory<>(invSize, name + "BlockEntity", 64, this);
        this.wrenchDrop = wrenchDrop;
        this.name = name;
        this.maxInput = tier.getMaxInput();
        this.maxOutput = tier.getMaxOutput();
        this.maxStorage = maxStorage;
        // Call it again after we have proper values for energy I\O
        checkTier();
    }

    // PowerAcceptorBlockEntity
    @Override
    public void tick(World world, BlockPos pos, BlockState state, MachineBaseBlockEntity blockEntity) {
        super.tick(world, pos, state, blockEntity);

        /*
        if (!inventory.getStack(0).isEmpty()) {
            discharge(0);
        }
        if (!inventory.getStack(1).isEmpty()) {
            charge(1);
        }

         */
    }

    @Override
    public boolean canAcceptEnergy(@Nullable Direction side) {
        return getFacing() != side;
    }

    @Override
    public boolean canProvideEnergy(@Nullable Direction side) {
        // side == null allows to move energy from BE to chargeable item.
        return side == null || getFacing() == side;
    }

    @Override
    public long getBaseMaxPower() {
        return maxStorage;
    }

    @Override
    public long getBaseMaxOutput() {
        return maxOutput;
    }

    @Override
    public long getBaseMaxInput() {
        return maxInput;
    }

    // MachineBaseBlockEntity
    @Override
    public void setFacing(Direction enumFacing) {
        if (world == null) {
            return;
        }
        world.setBlockState(pos, world.getBlockState(pos).with(EnergyStorageBlock.FACING, enumFacing));
    }

    @Override
    public Direction getFacingEnum() {
        if (world == null) {
            return null;
        }
        Block block = world.getBlockState(pos).getBlock();
        if (block instanceof EnergyStorageBlock) {
            return ((EnergyStorageBlock) block).getFacing(world.getBlockState(pos));
        }
        return null;
    }

    @Override
    public boolean canBeUpgraded() {
        return false;
    }

    // IToolDrop
    @Override
    public ItemStack getToolDrop(PlayerEntity entityPlayer) {
        return new ItemStack(wrenchDrop);
    }

    // InventoryProvider
    @Override
    public RebornInventory<NoTickEnergyStorageBlockEntity> getInventory() {
        return inventory;
    }
}
