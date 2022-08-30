package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.Items.MaterialItem;

import static xwxstudio.beyondreborn.ItemGroups.BRMaterials.BR_MATERIALS_GROUP;


public class Items {
    private static FabricItemSettings materialSettings=new FabricItemSettings().group(BR_MATERIALS_GROUP);
    //#自动生成的物品成员
    public static final MaterialItem IRON_DUST = new MaterialItem(materialSettings);
    public static final MaterialItem WASHED_IRON_DUST= new MaterialItem(materialSettings);
    //#自动生成的物品成员

    //#自动生成的方块成员
    
    //#自动生成的方块成员
    public  static  void init()
    {
        //#自动生成的物品注册
        Registry.register(Registry.ITEM, BeyondRebornMain.CreateID( "iron_dust"), IRON_DUST);
        Registry.register(Registry.ITEM,BeyondRebornMain.CreateID("washed_iron_dust"),WASHED_IRON_DUST);
        //#自动生成的物品注册

        //#自动生成的方块注册

        //#自动生成的方块注册

    }
}
