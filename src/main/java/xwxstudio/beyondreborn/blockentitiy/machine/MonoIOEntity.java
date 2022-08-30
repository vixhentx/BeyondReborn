package xwxstudio.beyondreborn.blockentitiy.machine;

//code from TR

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
import reborncore.api.recipe.IRecipeCrafterProvider;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import reborncore.common.powerSystem.PowerAcceptorBlockEntity;
import reborncore.common.recipes.RecipeCrafter;
import reborncore.common.util.RebornInventory;

public abstract class MonoIOEntity extends PowerAcceptorBlockEntity implements IToolDrop, InventoryProvider, IRecipeCrafterProvider {
    public String name;
    public int maxInput;
    public int maxEnergy;
    public Block toolDrop;
    public int energySlot;
    public RebornInventory<?> inventory;
    public RecipeCrafter crafter;

    public MonoIOEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, String name, int maxInput, int maxEnergy, Block toolDrop, int energySlot) {
        super(blockEntityType, pos, state);
        this.name = "BlockEntity" + name;
//        this.name = name;
        this.maxInput = maxInput;
        this.maxEnergy = maxEnergy;
        this.toolDrop = toolDrop;
        this.energySlot = energySlot;
        this.checkTier();
    }

    public int getProgressScaled(int scale) {
        return this.crafter != null && this.crafter.currentTickTime != 0 && this.crafter.currentNeededTicks != 0 ? this.crafter.currentTickTime * scale / this.crafter.currentNeededTicks : 0;
    }

    public void tick(World world, BlockPos pos, BlockState state, MachineBaseBlockEntity blockEntity) {
        super.tick(world, pos, state, blockEntity);
        if (world != null && !world.isClient) {
            if (this.energySlot != -1) {
                this.charge(this.energySlot);
            }

        }
    }

    public long getBaseMaxPower() {
        return (long)this.maxEnergy;
    }

    public boolean canProvideEnergy(@Nullable Direction side) {
        return false;
    }

    public long getBaseMaxOutput() {
        return 0L;
    }

    public long getBaseMaxInput() {
        return (long)this.maxInput;
    }

    public ItemStack getToolDrop(PlayerEntity p0) {
        return new ItemStack(this.toolDrop, 1);
    }

    public RebornInventory<?> getInventory() {
        return this.inventory;
    }

    public RecipeCrafter getRecipeCrafter() {
        return this.crafter;
    }
}
