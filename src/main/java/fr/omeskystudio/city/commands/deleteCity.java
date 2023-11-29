package fr.omeskystudio.city.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.omeskystudio.city.Main;

public class deleteCity {

	private Main main;
	
	public deleteCity(Main main) {
		this.main = main;
	}

	public void executeCommands(Player player, String[] args) {
		
		if(main.getPlayersConfig().get(player.getName()) == null)
			player.sendMessage("§8[§6City§8]§r Vous n'avez pas de ville");
		else {
			if(args.length <= 1) {
				player.sendMessage("La command est /c delete yes");
			}
			else {
				String cityName = main.getPlayersConfig().getString(player.getName());

				main.getCityConfig().set((String) main.getPlayersConfig().get(player.getName()),null);
				main.getPlayersConfig().set(player.getName(), null);
					
				main.saveCityFile();
				main.savePlayersFile();
				player.sendMessage("§8[§6City§8]§r Suppresion de la ville");

				Bukkit.broadcastMessage("§8[§6City§8]§r La ville "+ cityName + " vient d'être supprimer");
			}
		}
	}

}
