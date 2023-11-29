package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Objects;

public class spawn {
    Main main;
    public spawn(Main main) {this.main = main;}

    public void executeCommands(Player player) {

        if(main.getPlayersConfig().get(player.getName()) == null)
            player.sendMessage("§8[§6City§8]§r Vous n'avez pas de ville");
        else {
            String cityName = (String) main.getPlayersConfig().get(player.getName());
            String key = cityName + ".spawn";
            final ConfigurationSection configurationSection = main.getCityConfig().getConfigurationSection(key);

            if(configurationSection == null)
                player.sendMessage("§8[§6City§8]§r Veuillez définir un point de spawn pour votre ville");
            else{

                final World world = Bukkit.getWorld(Objects.requireNonNull(configurationSection.getString("world")));
                final double x = configurationSection.getDouble("x");
                final double y = configurationSection.getDouble("y");
                final double z = configurationSection.getDouble("z");
                final float yaw = (float) configurationSection.getDouble("yaw");
                final float pitch = (float) configurationSection.getDouble("pitch");

                final Location location = new Location(world,x,y,z,yaw,pitch);
                player.teleport(location);

            }
        }


    }
}
