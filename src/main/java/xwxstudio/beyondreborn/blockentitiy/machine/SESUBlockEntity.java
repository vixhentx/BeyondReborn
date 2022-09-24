package xwxstudio.beyondreborn.blockentitiy.machine;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import reborncore.client.screen.builder.ScreenHandlerBuilder;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import reborncore.common.powerSystem.RcEnergyTier;
import reborncore.common.screen.BuiltScreenHandler;
import reborncore.common.screen.BuiltScreenHandlerProvider;
import xwxstudio.beyondreborn.BRConfig;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.Registry.BRContent;
import xwxstudio.beyondreborn.Registry.BlockEntities;

public class SESUBlockEntity extends NoTickEnergyStorageBlockEntity implements BuiltScreenHandlerProvider {

    /**
     * SESU以放入其内部的物品作为存储，同步充放电
     */
    public SESUBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.SESU, pos, state, "SESU", 2, BRContent.Machine.SESU.block, RcEnergyTier.INSANE, BRConfig.SESUMaxEnergy);
    }

    @Override
    public BuiltScreenHandler createScreenHandler(int syncID, final PlayerEntity player) {
        return new ScreenHandlerBuilder(BeyondRebornMain.BuildScreenName("SESU")).player(player.getInventory()).inventory().hotbar().armor()
                .complete(8, 18).addArmor().addInventory().blockEntity(this).energySlot(0, 80, 45)
                .syncEnergyValue().addInventory().create(this, syncID);
    }
    @Override
    public void tick(World world, BlockPos pos, BlockState state, MachineBaseBlockEntity blockEntity) {
        super.tick(world, pos, state, blockEntity);
        if (world == null || world.isClient) {
            return;
        }

        long now_energy = this.getEnergy();
        if(now_energy>=getMaxStoredPower())//多则放
        {
            discharge(0);
        }
        else if(now_energy<=0)//少则充
        {
            charge(0);
        }


    }
}
