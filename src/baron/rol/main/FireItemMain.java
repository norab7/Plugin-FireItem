package baron.rol.main;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Checks and updates items thrown into a fire from a base type to next type
 * 
 * @author norab7
 *
 */
public class FireItemMain extends JavaPlugin {
	public FileConfiguration config = this.getConfig();
	public static HashMap<String, String> fireItems = new HashMap<String, String>();
	
	@Override
	public void onEnable() {

		// Load Configuration file
		this.saveDefaultConfig();
		config = this.getConfig();

		// Set HashMap to configuration file values
		for (String itemString : config.getConfigurationSection("items").getKeys(false)) {
			String baseItem = config.getString("items." + itemString + ".base");
			String firedItem = config.getString("items." + itemString + ".fired");
			fireItems.put(baseItem, firedItem);
		}

		// Register Listener
		getServer().getPluginManager().registerEvents(new FireItemListener(), this);

	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("/fireitem")) {
			sender.sendMessage("Plugin: FireItem Active");
			return true;
		}
		return false;
	}

}
