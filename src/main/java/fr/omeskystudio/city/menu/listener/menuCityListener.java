package fr.omeskystudio.city.menu.listener;

import fr.omeskystudio.city.commands.spawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.omeskystudio.city.Main;
import org.bukkit.inventory.ItemStack;

public class menuCityListener implements Listener{
	
	Main main;
	
	public menuCityListener(Main main) {
		this.main = main;
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
        
		Player player = (Player) event.getView().getPlayer();
		String cityName = (String) main.getPlayersConfig().get(player.getName());
		ItemStack item = event.getCurrentItem();
        if (event.getView().getTitle().equals(cityName + " Menu")){

            event.setCancelled(true);

			if(item.getItemMeta().getDisplayName().equalsIgnoreCase("City Home")){
				spawn sp = new spawn(main);
				sp.executeCommands(player);
			}

        }
    }
}
