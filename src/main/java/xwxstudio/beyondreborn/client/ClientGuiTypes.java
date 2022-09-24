package xwxstudio.beyondreborn.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import techreborn.blockentity.GuiType;
import techreborn.client.ClientGuiType;
import techreborn.client.GuiFactory;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.GuiTypes;
import xwxstudio.beyondreborn.blockentitiy.machine.*;
import xwxstudio.beyondreborn.client.GUI.*;

@Environment(EnvType.CLIENT)
public class ClientGuiTypes
{
    public static final ClientGuiType<RefinerBlockEntity> REFINER = register(GuiTypes.REFINER, GuiRefiner::new);
    public static final ClientGuiType<SESUBlockEntity> SESU=register(GuiTypes.SESU,GuiSESU::new);

    private static <T extends BlockEntity> ClientGuiType<T> register(GuiType<T> type, GuiFactory<T> factory) {
        BeyondRebornMain.LOGGER.debug("现在正在注册ClientGuiType: "+type.getIdentifier().toString());
        return new ClientGuiType(type, factory);
    }

    public static void init()
    {

    }
}
