package io.menhera.muslim;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public static Plugin main;
	@Override
	public void onEnable() {
		main = this;
		getServer().getPluginManager().registerEvents(new listener(), this);
		Bukkit.getLogger().info("Muslim Plugin Inited");
	}

	@Override
	public void onDisable() {

	}
}
