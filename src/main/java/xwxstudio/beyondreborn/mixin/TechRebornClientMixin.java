package xwxstudio.beyondreborn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import techreborn.TechRebornClient;
import xwxstudio.beyondreborn.client.ClientGuiTypes;

@Mixin(TechRebornClient.class)
public class TechRebornClientMixin {
    @Inject(method = "onInitializeClient", at = @At("HEAD"), remap = false)
    public void onInitializeClient(CallbackInfo ci) {
        ClientGuiTypes.init();
    }
}