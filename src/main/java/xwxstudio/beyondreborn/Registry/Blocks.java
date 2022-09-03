package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import reborncore.RebornRegistry;
import xwxstudio.beyondreborn.BeyondRebornMain;

import java.util.Arrays;

import static xwxstudio.beyondreborn.ItemGroups.BRMaterials.BR_MATERIALS_GROUP;


public class Blocks
{
    public static FabricBlockSettings baseSettings= FabricBlockSettings.of(Material.METAL).requiresTool().strength(2, 8);
//    public static final Block REFINER = new RefinerBlock(baseSettings);
    public static FabricItemSettings materialSettings=new FabricItemSettings().group(BR_MATERIALS_GROUP);
    public static void init()
    {
        //批量添加Block
        Arrays.stream(BRContent.Machine.values()).forEach(value -> RebornRegistry.registerBlock(
                value.block,
                materialSettings,
                new Identifier(BeyondRebornMain.MOD_ID, value.name)));
    }
}
