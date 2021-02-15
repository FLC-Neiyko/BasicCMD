package fr.neiyko.basiccmd.commands;

import fr.neiyko.basiccmd.BasicCMD;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CDiscord implements CommandExecutor {

    private BasicCMD main = BasicCMD.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (main.getConfig().getBoolean("discord.enable") && cmd.getName().equalsIgnoreCase("discord")) {
                if (args.length == 0) {
                    if (main.getConfig().getBoolean("discord.permission-enable")) {
                        if (p.hasPermission(main.getPermission("discord.permission")) || p.isOp()) {
                            for (String message : main.getStringList("discord.discord")) {
                                p.sendMessage(message.replace("&", "§"));
                            }
                        } else {
                            p.sendMessage(main.getMessage("no-permission").replace("&", "§"));
                        }
                    } else {
                        for (String message : main.getStringList("discord.discord")) {
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
