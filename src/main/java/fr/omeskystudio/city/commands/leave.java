package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.entity.Player;

import java.util.List;

public class leave {

    Main main;
    public leave(Main main) { this.main = main;
    }

    public void executeCommands(Player player, String[] args) {

        if(main.getPlayersConfig().get(player.getName()) == null) player.sendMessage("§8[§6City§8]§r Tu n'as pas de ville");
        else{
            String cityName = main.getPlayersConfig().getString(player.getName());

            if(main.getCityConfig().getString(cityName+".owner").equalsIgnoreCase(player.getName()))
                player.sendMessage("§8[§6City§8]§r Vous ne pouvez pas quitter votre propre ville /c delete pour quitter votre ville");
            else {
                List<String> getPlayer = main.getCityConfig().getStringList(cityName+".players");
                getPlayer.remove(player.getName());
                main.getCityConfig().set(cityName+".players",getPlayer);
                main.saveCityFile();

                main.getPlayersConfig().set(player.getName(),null);
                main.savePlayersFile();
            }
        }

    }
}
