package com.cogworks.numismaticsvillagerprofessions;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModProfessions {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE,
                    CreateCubicNumismaticsVillagerProfessions.MODID);

    public static final DeferredRegister<VillagerProfession> PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION,
                    CreateCubicNumismaticsVillagerProfessions.MODID);


    // Pawner POI
    public static final Holder<PoiType> PAWNER_POI =
            POI_TYPES.register("pawner", () ->
                    new PoiType(
                            ImmutableSet.copyOf(
                                    BuiltInRegistries.BLOCK
                                            .get(ResourceLocation.parse("numismatics:vendor"))
                                            .getStateDefinition()
                                            .getPossibleStates()
                            ),
                            1,
                            1
                    )
            );


    // Banker POI
    public static final Holder<PoiType> BANKER_POI =
            POI_TYPES.register("banker", () ->
                    new PoiType(
                            ImmutableSet.copyOf(
                                    BuiltInRegistries.BLOCK
                                            .get(ResourceLocation.parse("numismatics:bank_terminal"))
                                            .getStateDefinition()
                                            .getPossibleStates()
                            ),
                            1,
                            1
                    )
            );


    // Pawner profession
    public static final Holder<VillagerProfession> PAWNER =
            PROFESSIONS.register("pawner", () ->
                    new VillagerProfession(
                            "pawner",
                            holder -> holder.is(PAWNER_POI.unwrapKey().orElseThrow()),
                            holder -> holder.is(PAWNER_POI.unwrapKey().orElseThrow()),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_MASON
                    )
            );


    // Banker profession
    public static final Holder<VillagerProfession> BANKER =
            PROFESSIONS.register("banker", () ->
                    new VillagerProfession(
                            "banker",
                            holder -> holder.is(BANKER_POI.unwrapKey().orElseThrow()),
                            holder -> holder.is(BANKER_POI.unwrapKey().orElseThrow()),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_CARTOGRAPHER
                    )
            );
}