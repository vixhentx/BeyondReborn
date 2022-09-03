package xwxstudio.beyondreborn.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import techreborn.blockentity.GuiType;
import techreborn.client.ClientGuiType;
import techreborn.client.GuiFactory;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.GuiTypes;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;
import xwxstudio.beyondreborn.client.GUI.GuiRefiner;

@Environment(EnvType.CLIENT)
public class ClientGuiTypes
{
    public static final ClientGuiType<RefinerBlockEntity> REFINER = register(GuiTypes.REFINER, GuiRefiner::new);;

    private static <T extends BlockEntity> ClientGuiType<T> register(GuiType<T> type, GuiFactory<T> factory) {
        BeyondRebornMain.LOGGER.info("现在正在注册ClientGuiType: "+type.getIdentifier().toString());
        return new ClientGuiType(type, factory);
    }
    /*
    static
    {
        REFINER = register(GuiTypes.REFINER, GuiRefiner::new);
    }
    */

    public static void init()
    {

    }
}
