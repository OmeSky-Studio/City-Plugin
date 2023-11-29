package fr.omeskystudio.city;

import fr.omeskystudio.city.commands.*;
import fr.omeskystudio.city.menu.menuCity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	private Main main;

	public Commands(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String msg, String[] args) {
		if (command.getName().equalsIgnoreCase("city")) {

			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (args.length == 0) {
					menuCity c = new menuCity(main);
					c.executeCommands(player, args);
					return true;
				} else if (args.length >= 1) {
					String cmd = args[0];

					//command create city
					if (cmd.equalsIgnoreCase("create")) {
						createCity c = new createCity(main);
						c.executeCommands(player, args);
						return true;
					}
					//command delete city
					else if (cmd.equalsIgnoreCase("delete")) {
						deleteCity c = new deleteCity(main);
						c.executeCommands(player, args);
						return true;
					}

					//command setspawn city
					else if (cmd.equalsIgnoreCase("setspawn")) {
						setSpawn c = new setSpawn(main);
						c.executeCommands(player, args);
						return true;
					}

					//command spawn city
					else if (cmd.equalsIgnoreCase("spawn")) {
						spawn c = new spawn(main);
						c.executeCommands(player);
						return true;
					}

					//command addmember city
					else if (cmd.equalsIgnoreCase("addmember")) {
						addMember c = new addMember(main);
						c.executeCommands(player, args);
						return true;
					}

					//command leave city
					else if (cmd.equalsIgnoreCase("leave")) {
						leave c = new leave(main);
						c.executeCommands(player, args);
						return true;
					}

					//command claim city
					else if (cmd.equalsIgnoreCase("claim")) {
						claim c = new claim(main);
						c.executeCommands(player, args);
						return true;
					}
				}
			}
		}
		return false;
	}
}