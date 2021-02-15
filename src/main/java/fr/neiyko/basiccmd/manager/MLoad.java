package fr.neiyko.basiccmd.manager;

import fr.neiyko.basiccmd.BasicCMD;

import java.util.logging.Level;

public class MLoad {

    private BasicCMD main = BasicCMD.getInstance();

    public void pluginLoad() {
        long start_timer = System.currentTimeMillis();

        main.logConsole(Level.INFO, "=== Beginning of loading ===");
        main.logConsole(Level.INFO, "Loading the plugin...");
        main.logConsole(Level.INFO, "----");
        main.getCommandsManager().initCommands();
        main.getEventsManager().initEvents();
        main.getFilesManager().initFiles();
        if (main.getError()) errorMSG();

        long end_timer = System.currentTimeMillis();
        main.logConsole(Level.INFO, "Loading completed in " + (end_timer - start_timer) + " ms");
        pluginEnable();

    }

    public void pluginEnable() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin BasicCMD");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Enabled");
        main.logConsole(Level.INFO, "----");
    }

    public void pluginDisable() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin BasicCMD");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Disabled");
        main.logConsole(Level.INFO, "----");
    }

    public void errorMSG() {
        main.logConsole(Level.INFO, "----");
        main.logConsole(Level.INFO, "Plugin BasicCMD");
        main.logConsole(Level.INFO, "By Neiyko");
        main.logConsole(Level.INFO, "Status: Error");
        main.logConsole(Level.INFO, "----");
    }
}
