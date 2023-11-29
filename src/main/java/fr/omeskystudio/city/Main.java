package fr.omeskystudio.city;

import java.io.File;
import java.io.IOException;

import fr.omeskystudio.city.commands.reload;
import fr.omeskystudio.city.menu.listener.menuCityListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private File cityFile,playersFile,messageFile;
	private YamlConfiguration cityConfig,playersConfig,messageConfig;
	public static PluginManager pm = Bukkit.getPluginManager();
	@Override
	public void onEnable() {
		saveDefaultConfig();

		cityFile = new File(this.getDataFolder(),"city.yml");
		playersFile = new File(this.getDataFolder(),"players.yml");
		messageFile = new File(this.getDataFolder(),"message.yml");
		
		cityConfig = YamlConfiguration.loadConfiguration(cityFile);
		playersConfig = YamlConfiguration.loadConfiguration(playersFile);
		
		if(!cityFile.exists()) {
			cityFile.getParentFile().mkdirs();
            saveResource("city.yml", false);
		}
		if(!playersFile.exists()) {
			playersFile.getParentFile().mkdirs();
            saveResource("players.yml", false);
		}
		if(!messageFile.exists()) {
			messageFile.getParentFile().mkdirs();
			saveResource("message.yml", false);
		}
		
		System.out.println("[OméSky]: Plugin City Loaded");
		
		getCommand("city").setExecutor(new Commands(this));
		getCommand("cityreload").setExecutor(new reload(this));
		getServer().getPluginManager().registerEvents(new menuCityListener(this),this);
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("[OméSky]: Plugin City unLoaded");
	}
	
	public YamlConfiguration getCityConfig() {
		return cityConfig;
	}
	
	public File getCityFile() {
		return cityFile;
	}

	public void saveCityFile() {
		try {
			cityConfig.save(cityFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public YamlConfiguration getPlayersConfig() {
		return playersConfig;
	}

	public File getPlayersFile() {
		return playersFile;
	}
	
	public void savePlayersFile() {
		try {
			playersConfig.save(playersFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public YamlConfiguration getMessageConfig() {
		return messageConfig;
	}

	public File getMessageFile() {
		return messageFile;
	}

	public void saveMessageFile() {
		try {
			messageConfig.save(messageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
