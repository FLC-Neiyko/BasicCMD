package fr.neiyko.basiccmd.commands;

import fr.neiyko.basiccmd.BasicCMD;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class CBasic implements CommandExecutor {

    private BasicCMD main = BasicCMD.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {
            for (String message : main.getStringList("help.classic")) {
                p.sendMessage(message.replace("&", "§"));
            }
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            for (String message : main.getStringList("help.classic")) {
                p.sendMessage(message.replace("&", "§"));
            }
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("admin")) {
            if (p.hasPermission(main.getPermission("admin-help-permission"))) {
                for (String message : main.getStringList("help.admin")) {
                    p.sendMessage(message.replace("&", "§"));
                }
            }
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (p.hasPermission(main.getPermission("reload-permission"))) {
                PluginManager pm = main.getServer().getPluginManager();

                long start_timer = System.currentTimeMillis();
                try {
                    pm.disablePlugin(pm.getPlugin("BasicCMD"));
                    pm.enablePlugin(pm.getPlugin("BasicCMD"));
                } catch (Exception e) {
                    p.sendMessage(main.getMessage("reload-error").replace("&", "§"));
                    return false;
                }
                long end_timer = System.currentTimeMillis();
                p.sendMessage(main.getMessage("reload").replace("%timerMS%", end_timer - start_timer + "").replace("&", "§"));
            } else {
                p.sendMessage(main.getMessage("no-permission").replace("&", "§"));
            }
        }

        return false;
    }
}
