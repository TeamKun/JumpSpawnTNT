package sakastudio.jumpspawntnt;

import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public final class JumpSpawnTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin startup logic
        getLogger().info("JumpSpawnTNT ON 2");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("JumpSpawnTNT OFF");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(cmd.getName().equalsIgnoreCase("enableJumpSpawnTNT")){
            if(args[0].equalsIgnoreCase("true")){
                enable = true;
                return true;
            }else if(args[0].equalsIgnoreCase("false")){
                enable = false;
                return true;
            }
        }
        return false;
    }

    boolean enable = false;

    @EventHandler
    public void PlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent event) {
        // Some code here
        if(enable && event.getStatistic() == Statistic.JUMP){
            event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(),EntityType.PRIMED_TNT);
        }
    }
}
