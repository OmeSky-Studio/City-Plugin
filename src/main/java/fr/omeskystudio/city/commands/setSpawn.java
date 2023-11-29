package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Objects;

public class setSpawn {

    Main main;
    public setSpawn(Main main) { this.main = main; }

    public void executeCommands(Player player, String[] args) {
        if(main.getPlayersConfig().get(player.getName()) == null)
            player.sendMessage("§8[§6City§8]§r Vous n'avez pas de ville");
        else {
            String cityName = (String) main.getPlayersConfig().get(player.getName());
            Location location = player.getLocation();
            if(main.getCityConfig().getString(cityName+".owner") == player.getName()){
                String key = cityName + ".spawn";
                main.getCityConfig().createSection(key);
                main.getCityConfig().set(key + ".world", Objects.requireNonNull(location.getWorld()).getName());
                main.getCityConfig().set(key + ".x", location.getX());
                main.getCityConfig().set(key + ".y", location.getY());
                main.getCityConfig().set(key + ".z", location.getZ());
                main.getCityConfig().set(key + ".yaw", location.getYaw());
                main.getCityConfig().set(key + ".pitch", location.getPitch());

                main.saveCityFile();
                player.sendMessage("§8[§6City§8]§r Spawn ville définie");
            }else {
                player.sendMessage("§8[§6City§8]§r Seul le propriétaire peut définir le spawn de la ville");
            }
        }
    }

}
