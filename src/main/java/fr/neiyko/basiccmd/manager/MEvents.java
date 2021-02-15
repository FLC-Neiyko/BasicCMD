package fr.neiyko.basiccmd.manager;

import fr.neiyko.basiccmd.BasicCMD;
import org.bukkit.plugin.PluginManager;

public class MEvents {

    private BasicCMD main = BasicCMD.getInstance();

    public void initEvents() {
        PluginManager pm = main.getServer().getPluginManager();
    }
}
