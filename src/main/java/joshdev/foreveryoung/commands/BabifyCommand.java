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

public class BabifyCommand implements CommandExecutor {
  @Override
  public boolean onCommand(
      @NotNull CommandSender commandSender,
      @NotNull Command command,
      @NotNull String s,
      @NotNull String @NotNull [] strings) {
    if (commandSender instanceof Player player) {
      Entity entityInView = player.getTargetEntity(10);
      if (entityInView instanceof Animals animal) {
        if (animal.getAgeLock()) {
          TextComponent alreadyBabifiedComponent =
              Component.text(
                  "This animal has already been babified!",
                  NamedTextColor.RED,
                  TextDecoration.BOLD);
          player.sendMessage(alreadyBabifiedComponent);
          return true;
        }
        animal.setBaby();
        animal.setAgeLock(true);
        TextComponent successMsg =
            Component.text(
                "The entity you are looking at has been turned into a baby!",
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
