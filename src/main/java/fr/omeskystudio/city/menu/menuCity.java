package fr.omeskystudio.city.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.omeskystudio.city.Main;

public class menuCity implements Listener{

	public Main main;
	public Inventory cityMenu;
	
	public menuCity(Main main) {
		this.main = main;
	}

	public void executeCommands(Player player, String[] args) {
		
		if(main.getPlayersConfig().get(player.getName()) == null)
			player.sendMessage("§8[§6City§8]§r Vous devais avoir ou rejoindre une ville pour faire cela");
		else {
			createMenu(player);
		}
	}
	
	private void createMenu(Player player) {
		String cityName = (String) main.getPlayersConfig().get(player.getName());
		
		cityMenu = Bukkit.createInventory(null, 54,cityName + " Menu");
		
		//Info de base
		/*List<String> list = new ArrayList<String>();
		list.add(0, "Owner: "+ main.getCityConfig().get(cityName+".owner"));
		list.add(1, "Niveau: "+ main.getCityConfig().get(cityName+".state"));
		list.add(2, "Joueurs: "+ main.getCityConfig().get(cityName+".players") + "/"+ main.getCityConfig().get(cityName+".slotmax"));
		cityMenu.setItem(4,InventoryManager.createItem(Material.PLAYER_HEAD, cityName, list));*/
		
		cityMenu.setItem(13, InventoryManager.createItem(Material.RED_BED, "City Home"));
		
		cityMenu.setItem(20, afficherNiveau(cityName));
		cityMenu.setItem(21, InventoryManager.createItem(Material.GOLD_INGOT, "Bank de la ville", main.getCityConfig().get(cityName+".money").toString() +" €"));
		cityMenu.setItem(29, InventoryManager.createItem(Material.BARRIER, "Vote"));
		cityMenu.setItem(30, InventoryManager.createItem(Material.CHEST, "Coffre de la ville"));
		cityMenu.setItem(33, InventoryManager.createItem(Material.GOLDEN_AXE, "Parametre"));
		
		creatDeco(cityMenu);
		
		player.openInventory(cityMenu);
	}
	
	private void creatDeco(Inventory cityMenu) {
		for(int id = 0; id <= 53; id++) {
	  		if(id != 13 && id != 20 && id != 21 && id != 29 && id != 30 && id != 33) {
	  			if(id == 0 || id == 1 || id == 9 || id == 7 || id == 8 || id == 17 || id == 36 || id == 45 || id == 46 || id == 44 || id == 52 || id == 53)
	  				cityMenu.setItem(id, InventoryManager.createItem(Material.BLUE_STAINED_GLASS_PANE, " "));
		  		else 
		  			cityMenu.setItem(id, InventoryManager.createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
	  		}
	  		
	  	}
		
	}

	private ItemStack afficherNiveau(String cityName) {
		
		String state = (String) main.getCityConfig().get(cityName+".state");
		List<String> list = new ArrayList<String>();
		
		switch (state) {
			case "Infrastructure":
				list.add(0, ChatColor.WHITE + "-> "+ChatColor.RED+"Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Communaut� nomade":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "-> "+ChatColor.RED+"Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Habitations isol�es":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "-> "+ChatColor.RED+"Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Hameau":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "-> "+ChatColor.RED+"Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Village":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "-> "+ChatColor.RED+"Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Bourg":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "-> "+ChatColor.RED+"Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Ville":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "-> "+ChatColor.RED+"Ville");
				list.add(7, ChatColor.WHITE + "Métropole");
				break;
			case "Métropole":
				list.add(0, ChatColor.WHITE + "Infrastructure");
				list.add(1, ChatColor.WHITE + "Communauté nomade");
				list.add(2, ChatColor.WHITE + "Habitations isolées");
				list.add(3, ChatColor.WHITE + "Hameau");
				list.add(4, ChatColor.WHITE + "Village");
				list.add(5, ChatColor.WHITE + "Bourg");
				list.add(6, ChatColor.WHITE + "Ville");
				list.add(7, ChatColor.WHITE + "-> "+ChatColor.RED+"Métropole");
				break;
		
			default:
				break;
			}
		list.add(8,"");
		list.add(9,ChatColor.RED + "10000€" + ChatColor.WHITE + "pour passer au niveau suivant");
		
		return InventoryManager.createItem(Material.EXPERIENCE_BOTTLE, "Niveau de la ville", list);
	}

}
