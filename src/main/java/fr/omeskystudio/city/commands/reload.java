package fr.omeskystudio.city.commands;

import fr.omeskystudio.city.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload implements CommandExecutor {

    Main main;
    public reload(Main main) { this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("city"));
            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin("city"));
            player.sendMessage("Le plugin a bien été reload");
        }
        return false;
    }
}
