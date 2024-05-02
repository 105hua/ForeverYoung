/* Licensed under GNU General Public License v3.0 */
package joshdev.foreveryoung.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.incendo.cloud.annotations.Command;

public class BabifyCommand {
  @Command("babify")
  public void babify(CommandSender sender) {
    if (sender instanceof Player player) {
      Entity entityInView = player.getTargetEntity(10);
      if (entityInView instanceof Animals animal) {
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
      sender.sendMessage("You must be a player to use this command!");
    }
  }
}
