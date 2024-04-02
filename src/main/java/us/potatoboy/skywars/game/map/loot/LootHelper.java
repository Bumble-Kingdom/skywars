package us.potatoboy.skywars.game.map.loot;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import us.potatoboy.skywars.game.SkyWarsConfig;
import us.potatoboy.skywars.game.map.SkyWarsMap;

import java.util.List;
import java.util.Random;

public class LootHelper {
    public static void fillChests(ServerWorld world, SkyWarsMap map, SkyWarsConfig config, int count) {
        Random random = new Random();

        fillChestType(world, count, random, map.spawnChests, config.spawnLootTable());
        fillChestType(world, count, random, map.centerChests, config.centerLootTable());
    }

    private static void fillChestType(ServerWorld world, int count, Random random, List<BlockPos> chests, Identifier id) {
        for (BlockPos pos : chests) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity != null && blockEntity instanceof LootableContainerBlockEntity) {
                LootableContainerBlockEntity lootable = (LootableContainerBlockEntity) blockEntity;
                lootable.clear();
                lootable.setLootTable(new Identifier(id.getNamespace(), id.getPath() + count), random.nextLong());
            }
        }
    }
}
