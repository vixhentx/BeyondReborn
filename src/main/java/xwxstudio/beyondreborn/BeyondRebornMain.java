package xwxstudio.beyondreborn;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xwxstudio.beyondreborn.Registry.*;
import xwxstudio.beyondreborn.blockentitiy.GuiTypes;

public class BeyondRebornMain implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID="beyondreborn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier CreateID(String id)
	{
		return new Identifier(MOD_ID,id);
	}

    public static String BuildScreenName(String name) {
		return BeyondRebornMain.MOD_ID+name;
    }

    @Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Items.init();
		Blocks.init();
		BlockEntities.init();
		GuiTypes.init();
		Recipes.init();

		LOGGER.info("Beyond Reborn搞定!");
	}
}
