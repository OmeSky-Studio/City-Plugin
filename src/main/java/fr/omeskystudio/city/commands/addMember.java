package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class addMember {

    Main main;
    public addMember(Main main) { this.main = main; }

    public void executeCommands(Player player, String[] args) {

        if (args.length <= 1) player.sendMessage("§8[§6City§8]§r La command est: /city addmember <speudo>");
        else {

            if(Bukkit.getPlayer(args[1].toString()) == null) player.sendMessage("§8[§6City§8]§r Le joueur: "+ args[1].toString() + " n'est pas connecter au serveur");
            else {
                if(player.getName().equalsIgnoreCase(args[1])) player.sendMessage("§8[§6City§8]§r Tu ne peut pas t'inviter dans ta ville");
                else{
                    if(main.getPlayersConfig().getString(args[1]) != null) player.sendMessage("§8[§6City§8]§r Le joueur est déjà dans une ville");
                    else {
                        Player playerAddCity = Bukkit.getPlayer(args[1].toString());
                        playerAddCity.sendMessage("§8[§6City§8]§r "+player.getName() + " vient de vous inviter dans ça ville: " + main.getPlayersConfig().getString(player.getName()));

                        main.getPlayersConfig().set(playerAddCity.getName(),main.getPlayersConfig().getString(player.getName()));
                        main.savePlayersFile();

                        String CityName = main.getPlayersConfig().getString(player.getName());

                        List<String> getPlayer = main.getCityConfig().getStringList(CityName+".players");
                        getPlayer.add(playerAddCity.getName());
                        main.getCityConfig().set(CityName+".players",getPlayer);
                        main.saveCityFile();

                    }
                }
            }

        }
    }
}
