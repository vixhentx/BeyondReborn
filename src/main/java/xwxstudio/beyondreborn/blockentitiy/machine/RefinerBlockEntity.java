package xwxstudio.beyondreborn.blockentitiy.machine;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import reborncore.client.screen.builder.ScreenHandlerBuilder;
import reborncore.common.recipes.RecipeCrafter;
import reborncore.common.screen.BuiltScreenHandler;
import reborncore.common.screen.BuiltScreenHandlerProvider;
import reborncore.common.util.RebornInventory;
import xwxstudio.beyondreborn.BRConfig;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.Events.TileCreateEvent;
import xwxstudio.beyondreborn.Registry.BRContent;
import xwxstudio.beyondreborn.Registry.BlockEntities;
import xwxstudio.beyondreborn.Registry.Recipes;
public class RefinerBlockEntity extends MonoIOEntity implements BuiltScreenHandlerProvider {

    public RefinerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.REFINER, pos, state, "Refiner", BRConfig.refinerMaxInput, BRConfig.refinerMaxEnergy, BRContent.Machine.REFINER.block, 2);
        final int[] inputs = new int[]{0};
        final int[] outputs = new int[]{1};
        this.inventory = new RebornInventory<>(4, "RefinerBlockEntity", 64, this);
        this.crafter = new RecipeCrafter(Recipes.REFINING, this, 2, 1, this.inventory, inputs, outputs);
    }

    public RefinerBlockEntity(TileCreateEvent event) {
        this(event.getBlockPos(), event.getBlockState());
    }



    // IContainerProvider
    @Override
    public BuiltScreenHandler createScreenHandler(int syncID, final PlayerEntity player) {
        return new ScreenHandlerBuilder(BeyondRebornMain.BuildScreenName("__refiner")).player(player.getInventory()).inventory().hotbar().addInventory().blockEntity(this)
                .slot(0, 55, 45).outputSlot(1, 101, 45).energySlot(2, 8, 72).syncEnergyValue().syncCrafterValue()
                .addInventory().create(this, syncID);
    }
}