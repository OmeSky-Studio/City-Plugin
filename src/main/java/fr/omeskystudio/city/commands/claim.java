package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Locale;

public class claim {
    Main main;
    public claim(Main main) {
        this.main = main;
    }

    public void executeCommands(Player player, String[] args) {

        Chunk cliaming = player.getLocation().getChunk();

        if(main.getPlayersConfig().get(player.getName()) == null){

        }

    }
}
