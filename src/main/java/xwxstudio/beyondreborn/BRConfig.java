package xwxstudio.beyondreborn;

import reborncore.common.config.Config;

public class BRConfig
{
    //refiner
    @Config(config = "machines", category = "refiner", key = "RefinerInput", comment = "Refiner Max Input (Energy per tick)")
    public static int refinerMaxInput = 32;
    @Config(config = "machines", category = "refiner", key = "RefinerMaxEnergy", comment = "Refiner Max Energy")
    public static int refinerMaxEnergy = 10_000;
    @Config(config = "machines", category = "sesu", key = "SESUMaxEnergy", comment = "SESU Max Energy")
    public static int SESUMaxEnergy=8192;
}
