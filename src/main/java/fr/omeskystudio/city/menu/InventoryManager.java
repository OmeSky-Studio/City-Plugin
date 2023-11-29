package fr.omeskystudio.city.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryManager {

	public static ItemStack createItem(Material material, String DisplayName) {
		
		ItemStack item = new ItemStack(material);
	    ItemMeta item_meta = item.getItemMeta();
	    item_meta.setDisplayName(DisplayName);
	    item.setItemMeta(item_meta);
		
		return item;
	}
	
	public static ItemStack createItem(Material material, String DisplayName, List<String> lore) {
		
		ItemStack item = new ItemStack(material);
	    ItemMeta item_meta = item.getItemMeta();
	    item_meta.setDisplayName(DisplayName);
	    item_meta.setLore(lore);
	    item.setItemMeta(item_meta);
		
		return item;
	}
	
	public static ItemStack createItem(Material material, String DisplayName, String lore) {
		
		List<String> lr = new ArrayList<String>();
		lr.add(0,lore);
	
		ItemStack item = new ItemStack(material);
	    ItemMeta item_meta = item.getItemMeta();
	    item_meta.setDisplayName(DisplayName);
	    item_meta.setLore(lr);
	    item.setItemMeta(item_meta);
		
		return item;
	}
	
}
