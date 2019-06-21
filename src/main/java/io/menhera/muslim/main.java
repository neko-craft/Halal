package io.menhera.muslim;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public static Plugin main;
	@Override
	public void onEnable() {
		main = this;
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Team fm = scoreboard.registerNewTeam("Music FM");
		fm.setDisplayName("Music FM");
		Objective objective = scoreboard.registerNewObjective("lives", "dummy");
		objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		objective.setDisplayName("lives");

		for(Player online : Bukkit.getOnlinePlayers()){
			Score score = objective.getScore(online);
			score.setScore(5);
		}

		for(Player online : Bukkit.getOnlinePlayers()){
			online.setScoreboard(scoreboard);
		}
		getServer().getPluginManager().registerEvents(new listener(), this);
		Bukkit.getLogger().info("Muslim Plugin Inited");
	}

	@Override
	public void onDisable() {

	}
}
