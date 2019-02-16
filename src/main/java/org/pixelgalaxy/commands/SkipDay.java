package org.pixelgalaxy.commands;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pixelgalaxy.WerewolfMain;
import org.pixelgalaxy.game.GamePlayer;
import org.pixelgalaxy.timers.GameDayNightTimer;

public class SkipDay implements CommandExecutor {

    @Getter @Setter
    private static GamePlayer GAME_MASTER;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("skipday") && GAME_MASTER.getPlayer().equals(p)){

                GameDayNightTimer.currentGameTimer.cancel();
                GameDayNightTimer timer = new GameDayNightTimer();
                timer.runTaskTimer(WerewolfMain.plugin, 0, 20);

            }

        }

        return false;
    }
}
