package fr.neiyko.basiccmd.commands;

import fr.neiyko.basiccmd.BasicCMD;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CTeamspeak implements CommandExecutor {

    private BasicCMD main = BasicCMD.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (main.getConfig().getBoolean("teamspeak.enable") && cmd.getName().equalsIgnoreCase("teamspeak")) {
                if (args.length == 0) {
                    if (main.getConfig().getBoolean("teamspeak.permission-enable")) {
                        if (p.hasPermission(main.getPermission("teamspeak.permission")) || p.isOp()) {
                            for (String message : main.getStringList("teamspeak.teamspeak")) {
                                p.sendMessage(message.replace("&", "§"));
                            }
                        } else {
                            p.sendMessage(main.getMessage("no-permission").replace("&", "§"));
                        }
                    } else {
                        for (String message : main.getStringList("teamspeak.teamspeak")) {
                            p.sendMessage(message.replace("&", "§"));
                        }
                    }
                }
            }
        } else {
            sender.sendMessage(main.getMessage("not-player-instance").replace("&", "§"));
        }
        return false;
    }
}
