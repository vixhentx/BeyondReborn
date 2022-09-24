package xwxstudio.beyondreborn.blockentitiy;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import techreborn.blockentity.GuiType;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.*;

public class GuiTypes
{
    public static GuiType<RefinerBlockEntity> REFINER = register("__refiner");
    public static GuiType<SESUBlockEntity> SESU = register("__sesu");

    private static <T extends BlockEntity> GuiType<T> register(String id) {
        return GuiType.register(new Identifier(BeyondRebornMain.MOD_ID + id));
    }
    public static void init()
    {

    }
}
