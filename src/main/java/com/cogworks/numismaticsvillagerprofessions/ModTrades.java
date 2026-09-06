package com.cogworks.numismaticsvillagerprofessions;

import java.util.Optional;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber(modid = CreateCubicNumismaticsVillagerProfessions.MODID)
public class ModTrades {

    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        if (event.getType() == ModProfessions.PAWNER.value()) {
            registerPawnerTrades(event);
        }

        if (event.getType() == ModProfessions.BANKER.value()) {
            registerBankerTrades(event);
        }
    }

    private static void registerPawnerTrades(VillagerTradesEvent event) {
        event.getTrades().get(1).add(
                trade("create:cardboard", 8, null, 0, "numismatics:spur", 32)
        );

        event.getTrades().get(1).add(
                trade("numismatics:spur", 48, null, 0, "create:cardboard", 8)
        );

        event.getTrades().get(2).add(
                trade("create:piston_extension_pole", 1, null, 0, "numismatics:bevel", 8)
        );

        event.getTrades().get(2).add(
                trade("create:whisk", 1, null, 0, "numismatics:bevel", 8)
        );

        event.getTrades().get(2).add(
                trade("create:propeller", 1, null, 0, "numismatics:bevel", 8)
        );

        event.getTrades().get(3).add(
                trade("minecraft:iron_helmet", 1, "create:iron_sheet", 16, "numismatics:sprocket", 1)
        );

        event.getTrades().get(4).add(
                trade("numismatics:cog", 2, null, 0, "numismatics:bank_terminal", 1)
        );

        event.getTrades().get(4).add(
                trade("numismatics:cog", 4, null, 0, "numismatics:vendor", 1)
        );
    }

    private static void registerBankerTrades(VillagerTradesEvent event) {
        event.getTrades().get(1).add(
                trade("minecraft:copper_block", 32, "minecraft:diamond", 1, "numismatics:spur", 4)
        );

        event.getTrades().get(1).add(
                trade("create:zinc_ingot", 32, "minecraft:diamond", 1, "numismatics:bevel", 8)
        );

        event.getTrades().get(2).add(
                trade("minecraft:iron_block", 32, "minecraft:diamond", 1, "numismatics:sprocket", 1)
        );

        event.getTrades().get(2).add(
                trade("create:brass_ingot", 16, "minecraft:diamond", 1, "numismatics:cog", 1)
        );

        event.getTrades().get(3).add(
                trade("minecraft:gold_block", 16, "minecraft:diamond", 1, "numismatics:crown", 1)
        );

        event.getTrades().get(4).add(
                trade("minecraft:netherite_ingot", 4, "minecraft:diamond", 1, "numismatics:sun", 1)
        );
    }

    private static VillagerTrades.ItemListing trade(
            String input1Id,
            int input1Count,
            String input2Id,
            int input2Count,
            String outputId,
            int outputCount
    ) {
        Item input1 = BuiltInRegistries.ITEM.get(
                ResourceLocation.parse(input1Id)
        );

        Item output = BuiltInRegistries.ITEM.get(
                ResourceLocation.parse(outputId)
        );

        ItemCost cost1 = new ItemCost(input1, input1Count);

        if (input2Id == null) {
            return (entity, random) -> new MerchantOffer(
                    cost1,
                    new ItemStack(output, outputCount),
                    12,
                    2,
                    0.05F
            );
        }

        Item input2 = BuiltInRegistries.ITEM.get(
                ResourceLocation.parse(input2Id)
        );

        ItemCost cost2 = new ItemCost(input2, input2Count);

        return (entity, random) -> new MerchantOffer(
                cost1,
                Optional.of(cost2),
                new ItemStack(output, outputCount),
                12,
                2,
                0.05F
        );
    }
}