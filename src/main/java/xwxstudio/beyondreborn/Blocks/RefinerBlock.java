package xwxstudio.beyondreborn.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import reborncore.api.blockentity.IMachineGuiHandler;
import xwxstudio.beyondreborn.Events.TileCreateEvent;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;
import xwxstudio.beyondreborn.client.GuiTypes;

public class RefinerBlock extends AdvancedMachineBlock
{
    public RefinerBlock(FabricBlockSettings settings) {
        super(settings);
    }


    @Override
    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new RefinerBlockEntity(event);
    }

    public IMachineGuiHandler getGui() {
        return GuiTypes.REFINER;
    }
}
