package xwxstudio.beyondreborn;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class BeyondRebornClient implements ClientModInitializer {
    public static MinecraftClient client = MinecraftClient.getInstance();

    public void onInitializeClient() {
        //ClientGuiTypes.init(); → TechRebornClientMixin
        /*
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(BeyondRebornMain.CreateID("particle/energy"));
        }));

        ParticleFactoryRegistry.getInstance().register(Particles.ENERGY, EmotionParticle.HeartFactory::new);
        */
//        ClientGuiTypes.init();//必须在TR加载前加载,试放入TechRebornClientMixin
    }
}
