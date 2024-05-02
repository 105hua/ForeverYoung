/* Licensed under GNU General Public License v3.0 */
package joshdev.foreveryoung;

import joshdev.foreveryoung.commands.BabifyCommand;
import joshdev.foreveryoung.commands.DebabifyCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.annotations.AnnotationParser;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.PaperCommandManager;

public final class ForeverYoung extends JavaPlugin {

  @Override
  public void onEnable() {
    getLogger().info("Registering commands...");
    PaperCommandManager<CommandSender> commandManager =
        PaperCommandManager.createNative(this, ExecutionCoordinator.simpleCoordinator());
    AnnotationParser<CommandSender> annotationParser =
        new AnnotationParser<>(commandManager, CommandSender.class);
    annotationParser.parse(new BabifyCommand());
    annotationParser.parse(new DebabifyCommand());
    getLogger().info("Commands registered, plugin is now ready.");
  }

  @Override
  public void onDisable() {
    getLogger().info("Plugin is now disabled.");
  }
}
