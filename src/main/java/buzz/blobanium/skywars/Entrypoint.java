package buzz.blobanium.skywars;

import buzz.blobanium.bumblekingdomcore.player.GameMode;
import net.minecraft.server.network.ServerPlayerEntity;

public class Entrypoint {
    public static void onInitialize(){

    }

    public static void onPlayerJoin(ServerPlayerEntity player){
        GameMode.setGameMode(player, true);
    }

    public static void onPlayerQuit(ServerPlayerEntity player){
        GameMode.setGameMode(player, true);
    }
}
