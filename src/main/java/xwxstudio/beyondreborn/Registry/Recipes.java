package xwxstudio.beyondreborn.Registry;

import net.minecraft.util.Identifier;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RebornRecipeType;
import reborncore.common.crafting.RecipeManager;

public class Recipes {
    public static RebornRecipeType<RebornRecipe> REFINING = RecipeManager.newRecipeType(new Identifier("beyondreborn:refining"));
    public static void init()
    {}

}
