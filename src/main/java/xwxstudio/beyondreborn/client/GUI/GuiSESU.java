package xwxstudio.beyondreborn.client.GUI;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import reborncore.client.gui.builder.GuiBase;
import reborncore.common.powerSystem.PowerSystem;
import reborncore.common.screen.BuiltScreenHandler;
import xwxstudio.beyondreborn.blockentitiy.machine.SESUBlockEntity;

public class GuiSESU extends GuiBase<BuiltScreenHandler> {

    SESUBlockEntity sesu;

    public GuiSESU(int syncID, final PlayerEntity player, final SESUBlockEntity sesu) {
        super(player, sesu, sesu.createScreenHandler(syncID, player));
        this.sesu = sesu;
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, final float f, final int mouseX, final int mouseY) {
        super.drawBackground(matrixStack, f, mouseX, mouseY);
        final Layer layer = Layer.BACKGROUND;

        drawSlot(matrixStack, 80, 45, layer);
        drawArmourSlots(matrixStack, 8, 18, layer);
    }

    @Override
    protected void drawForeground(MatrixStack matrixStack, final int mouseX, final int mouseY) {
        super.drawForeground(matrixStack, mouseX, mouseY);
        final Layer layer = Layer.FOREGROUND;

        matrixStack.push();
        matrixStack.scale(0.6f, 0.6f, 1.0f);
        drawCentredText(matrixStack, new LiteralText(PowerSystem.getLocalizedPowerNoSuffix(sesu.getEnergy()) + "/" + PowerSystem.getLocalizedPower(sesu.getMaxStoredPower())), 35, 0, 58, layer);
        matrixStack.pop();

        builder.drawMultiEnergyBar(matrixStack, this, 150, 28, (int) sesu.getEnergy(), (int) sesu.getMaxStoredPower(), mouseX, mouseY, 0, layer);
    }
}
