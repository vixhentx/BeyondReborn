package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xwxstudio.beyondreborn.Items.Materials.MaterialItem;

public class Items {
    private static FabricItemSettings baseSettings=new FabricItemSettings().group(ItemGroup.MISC);
    //#auto_generate_items_member
    public static final MaterialItem IRON_DUST = new MaterialItem(baseSettings);
    //#auto_generate_items_member
    public  static  void Init()
    {
        //#auto_generate_items_registry
        Registry.register(Registry.ITEM, new Identifier("beyondreborn", "iron_dust"), IRON_DUST);
        //#auto_generate_items_registry
    }
}
