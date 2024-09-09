/* Licensed under GNU General Public License v3.0 */
package joshdev.foreveryoung;

import joshdev.foreveryoung.commands.BabifyCommand;
import joshdev.foreveryoung.commands.DebabifyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForeverYoung extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("Registering commands...");
    this.getCommand("babify").setExecutor(new BabifyCommand());
    this.getCommand("debabify").setExecutor(new DebabifyCommand());
    getLogger().info("Commands registered, plugin is now ready.");
  }

  @Override
  public void onDisable() {
    getLogger().info("Plugin is now disabled.");
  }
}
