package xwxstudio.beyondreborn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.EmotionParticle;
import net.minecraft.screen.PlayerScreenHandler;

public class BeyondRebornClient implements ClientModInitializer {
    public static MinecraftClient client = MinecraftClient.getInstance();

    public void onInitializeClient() {
        //ClientGuiTypes.init(); → TechRebornClientMixin
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(BeyondRebornMain.CreateID("particle/energy"));
        }));

        ParticleFactoryRegistry.getInstance().register(Particles.ENERGY, EmotionParticle.HeartFactory::new);

    }
}
