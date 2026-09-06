package com.cogworks.numismaticsvillagerprofessions;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(CreateCubicNumismaticsVillagerProfessions.MODID)
public class CreateCubicNumismaticsVillagerProfessions {
    public static final String MODID = "numismaticsvillagerprofessions";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateCubicNumismaticsVillagerProfessions(IEventBus modEventBus, ModContainer modContainer) {
        ModProfessions.POI_TYPES.register(modEventBus);
        ModProfessions.PROFESSIONS.register(modEventBus);
    }
}