package xwxstudio.beyondreborn.client;

import net.minecraft.block.entity.BlockEntity;
import techreborn.blockentity.GuiType;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;

public class GuiTypes
{
    public static GuiType<RefinerBlockEntity> REFINER = register(BeyondRebornMain.MOD_ID+"__refiner");

    public static <T extends BlockEntity> GuiType<T> register(String id) {
        return GuiType.register(BeyondRebornMain.CreateID(id));
    }
}
