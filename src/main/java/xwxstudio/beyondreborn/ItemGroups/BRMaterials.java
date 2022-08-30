package xwxstudio.beyondreborn.ItemGroups;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xwxstudio.beyondreborn.Registry.Items;

public class BRMaterials {
    public static final ItemGroup BR_MATERIALS_GROUP = FabricItemGroupBuilder.build(
            new Identifier("beyondreborn", "materials"),
            () -> new ItemStack(Items.IRON_DUST));
}
