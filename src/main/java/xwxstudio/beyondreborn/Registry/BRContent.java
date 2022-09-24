package xwxstudio.beyondreborn.Registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import techreborn.blocks.GenericMachineBlock;
import techreborn.utils.InitUtils;
import xwxstudio.beyondreborn.Blocks.*;
import xwxstudio.beyondreborn.blockentitiy.GuiTypes;
import xwxstudio.beyondreborn.blockentitiy.machine.*;

import java.util.Locale;

public class BRContent
{
    public enum Machine implements ItemConvertible {

        REFINER(new GenericMachineBlock(GuiTypes.REFINER, RefinerBlockEntity::new)),

        //Energy
        SESU(new SESUBlock());

        public final String name;
        public final Block block;

        <B extends Block> Machine(B block) {
            this.name = this.toString().toLowerCase(Locale.ROOT);
            this.block = block;
            InitUtils.setup(block, name);
        }

        public ItemStack getStack() {
            return new ItemStack(block);
        }

        @Override
        public Item asItem() {
            return block.asItem();
        }
    }
}
