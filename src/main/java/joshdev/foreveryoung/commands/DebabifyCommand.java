/* Licensed under GNU General Public License v3.0 */
package joshdev.foreveryoung.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DebabifyCommand implements CommandExecutor {
  @Override
  public boolean onCommand(
      @NotNull CommandSender commandSender,
      @NotNull Command command,
      @NotNull String s,
      @NotNull String[] strings) {
    if (commandSender instanceof Player player) {
      Entity entityInView = player.getTargetEntity(10);
      if (entityInView instanceof Animals animal) {
        if (!animal.getAgeLock() || animal.getAge() == 0) {
          TextComponent alreadyAdultComponent =
              Component.text(
                  "Animal is already an adult!", NamedTextColor.RED, TextDecoration.BOLD);
          player.sendMessage(alreadyAdultComponent);
          return true;
        }
        animal.setAgeLock(false);
        animal.setAge(0);
        TextComponent successMsg =
            Component.text(
                "The entity you are looking at has been turned into an adult!",
                NamedTextColor.GREEN,
                TextDecoration.BOLD);
        player.sendMessage(successMsg);
      } else {
        TextComponent noAnimalMsg =
            Component.text(
                "You must be looking at an animal to use this command!",
                NamedTextColor.RED,
                TextDecoration.BOLD);
        player.sendMessage(noAnimalMsg);
      }
    } else {
      commandSender.sendMessage("You must be a player to use this command!");
    }
    return true;
  }
}
