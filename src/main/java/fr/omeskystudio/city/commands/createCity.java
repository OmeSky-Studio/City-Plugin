package fr.omeskystudio.city.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.omeskystudio.city.Main;

public class createCity{
	
	private Main main;
	
	public createCity(Main main) {
		this.main = main;
	}

	public void executeCommands(Player player, String[] args) {
		if(args.length <= 1) {
			player.sendMessage("§8[§6City§8]§r La commande est /city create <city name>");
			return;
		}
		String cityName = args[1];
		if(main.getCityConfig().get(cityName) != null) {
			player.sendMessage("§8[§6City§8]§r La ville: "+cityName + " existe deja, merci de choisir un autre nom");
		}
		else if(main.getPlayersConfig().get(player.getName()) != null) {
			player.sendMessage("§8[§6City§8]§r Vous avez deja une ville");
		}
		else {
			newCity(cityName, player);
			player.sendMessage("§8[§6City§8]§r La ville: "+cityName + " vien d'etre créé");
			
		}
		
	}
	
	private void newCity(String cityName, Player player) {
		/*if((boolean) main.getCityConfig().get(player.getDisplayName())){
			player.sendMessage("Tu as d�ja une ville tu peut pas en cr�� une nouvelle");
			return;
		}*/
		main.getPlayersConfig().set(player.getName(),cityName);
		main.getCityConfig().createSection(cityName); //Creation de la ville
		main.getCityConfig().set(cityName+".owner", player.getName()); //Createur de la ville
		main.getCityConfig().set(cityName+".state", "Infrastructure"); // niveau de la ville
		main.getCityConfig().set(cityName+".money", 0); //argents dans la ville
		main.getCityConfig().set(cityName+".slotmax", 5); // nombre de joueurs maximal dans la ville
		main.getCityConfig().createSection(cityName+".players"); //liste des joueurs dans la ville
		main.getCityConfig().set(cityName+".classement", -1); //classement (default-1)


		main.saveCityFile();
		main.savePlayersFile();

		Bukkit.broadcastMessage("§8[§6City§8]§r Le joueur " + player.getName() + " a créé la ville " + cityName);
	}

}
