package xwxstudio.beyondreborn.blockentitiy;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import techreborn.blockentity.GuiType;
import xwxstudio.beyondreborn.BeyondRebornMain;
import xwxstudio.beyondreborn.blockentitiy.machine.RefinerBlockEntity;

// AR Code
public class GuiTypes
{
    public static GuiType<RefinerBlockEntity> REFINER = register("__refiner");

    private static <T extends BlockEntity> GuiType<T> register(String id) {
        return GuiType.register(new Identifier(BeyondRebornMain.MOD_ID + id));
    }
    public static void init()
    {

    }
}
/*QM code
public class GuiType<T extends BlockEntity> implements IMachineGuiHandler {
    private static final Map<Identifier, GuiType<?>> TYPES = new HashMap<>();

    public static final GuiType<RefinerBlockEntity> REFINER = register("refiner", () -> () -> GuiRefiner::new);

    private static <T extends BlockEntity> GuiType<T> register(String id, Supplier<Supplier<GuiFactory<T>>> factorySupplierMeme) {
        return register(BeyondRebornMain.CreateID(id), factorySupplierMeme);
    }

    public static <T extends BlockEntity> GuiType<T> register(Identifier identifier, Supplier<Supplier<GuiFactory<T>>> factorySupplierMeme) {
        if (TYPES.containsKey(identifier)) {
            throw new RuntimeException("Duplicate gui type found");
        }
        GuiType<T> type = new GuiType<>(identifier, factorySupplierMeme);
        TYPES.put(identifier, type);
        return type;
    }

    private final Identifier identifier;
    private final Supplier<Supplier<GuiFactory<T>>> guiFactory;
    private final ScreenHandlerType<BuiltScreenHandler> screenHandlerType;

    private GuiType(Identifier identifier, Supplier<Supplier<GuiFactory<T>>> factorySupplierMeme) {
        this.identifier = identifier;
        this.guiFactory = factorySupplierMeme;
        this.screenHandlerType = ScreenHandlerRegistry.registerExtended(identifier, getScreenHandlerFactory());
        ScreenRegistry.register(screenHandlerType, getGuiFactory());
    }

    private ScreenHandlerRegistry.ExtendedClientHandlerFactory<BuiltScreenHandler> getScreenHandlerFactory() {
        return (syncId, playerInventory, packetByteBuf) -> {
            final BlockEntity blockEntity = playerInventory.player.world.getBlockEntity(packetByteBuf.readBlockPos());
            BuiltScreenHandler screenHandler = ((BuiltScreenHandlerProvider) blockEntity).createScreenHandler(syncId, playerInventory.player);

            //Set the screen handler type, not ideal but works lol
            screenHandler.setType(screenHandlerType);

            return screenHandler;
        };
    }

    @Environment(EnvType.CLIENT)
    private GuiFactory<T> getGuiFactory() {
        return guiFactory.get().get();
    }

    @Override
    public void open(PlayerEntity player, BlockPos pos, World world) {
        if (!world.isClient) {
            //This is awful
            player.openHandledScreen(new ExtendedScreenHandlerFactory() {
                @Override
                public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
                    packetByteBuf.writeBlockPos(pos);
                }

                @Override
                public Text getDisplayName() {
                    return new LiteralText("What is this for?");
                }

                @Nullable
                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                    final BlockEntity blockEntity = player.world.getBlockEntity(pos);
                    BuiltScreenHandler screenHandler = ((BuiltScreenHandlerProvider) blockEntity).createScreenHandler(syncId, player);
                    screenHandler.setType(screenHandlerType);
                    return screenHandler;
                }
            });
        }
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Environment(EnvType.CLIENT)
    public interface GuiFactory<T extends BlockEntity> extends ScreenRegistry.Factory<BuiltScreenHandler, HandledScreen<BuiltScreenHandler>> {
        HandledScreen<?> create(int syncId, PlayerEntity playerEntity, T blockEntity);

        @Override
        default HandledScreen create(BuiltScreenHandler builtScreenHandler, PlayerInventory playerInventory, Text text) {
            PlayerEntity playerEntity = playerInventory.player;
            //noinspection unchecked
            T blockEntity = (T) builtScreenHandler.getBlockEntity();
            return create(builtScreenHandler.syncId, playerEntity, blockEntity);
        }
    }
}*/
