package xwxstudio.beyondreborn.client;

import net.minecraft.block.entity.BlockEntity;
import techreborn.blockentity.GuiType;
import techreborn.client.ClientGuiType;
import techreborn.client.GuiFactory;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;
import xwxstudio.beyondreborn.client.GUI.GuiRefiner;

public class ClientGuiTypes
{
    public static ClientGuiType<RefinerBlockEntity> REFINER = register(GuiTypes.REFINER, GuiRefiner::new);

    public static <T extends BlockEntity> ClientGuiType<T> register(GuiType<T> type, GuiFactory<T> factory) {
        BeyondRebornMain.LOGGER.info("BeyondReborn ClientGuiTypes成功载入!");
        return new ClientGuiType<>(type, factory);
    }
    public static void init()
    {

    }
}
