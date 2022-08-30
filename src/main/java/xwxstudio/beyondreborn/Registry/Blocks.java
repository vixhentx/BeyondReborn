package xwxstudio.beyondreborn.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.Blocks.RefinerBlock;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;


public class Blocks
{
    public static FabricBlockSettings baseSettings= FabricBlockSettings.of(Material.METAL).requiresTool().strength(2, 8);
    public static final Block REFINER = new RefinerBlock(baseSettings);
    public static void init()
    {
        Registry.register(Registry.BLOCK, BeyondRebornMain.CreateID("refiner"),REFINER);
    }
}
