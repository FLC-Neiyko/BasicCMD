package fr.neiyko.basiccmd;

import fr.neiyko.basiccmd.manager.MCommands;
import fr.neiyko.basiccmd.manager.MEvents;
import fr.neiyko.basiccmd.manager.MFiles;
import fr.neiyko.basiccmd.manager.MLoad;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

public final class BasicCMD extends JavaPlugin {

    private static BasicCMD instance;

    private MLoad managerLoad;
    private MEvents eventsManager;
    private MCommands commandsManager;
    private MFiles filesManager;
    public boolean error;

    public static BasicCMD getInstance() {
        return instance;
    }

    public File configFile = new File(getDataFolder().getPath() + "/config.yml");
    public FileConfiguration fileConfigConfiguration;

    public File messagesFile = new File(getDataFolder().getPath() + "/messages.yml");
    public FileConfiguration fileConfigMessages;

    @Override
    public void onEnable() {
        instance = this;
        this.managerLoad = new MLoad();
        this.eventsManager = new MEvents();
        this.filesManager = new MFiles();
        this.commandsManager = new MCommands();
        managerLoad.pluginLoad();
    }

    @Override
    public void onDisable() {
        managerLoad.pluginDisable();
    }

    public MLoad getManagerLoad() {
        return managerLoad;
    }

    public MEvents getEventsManager() {
        return eventsManager;
    }

    public void logConsole(Level level, String msg) {
        getLogger().log(level, msg);
    }

    public MCommands getCommandsManager() {
        return commandsManager;
    }

    public MFiles getFilesManager() {
        return filesManager;
    }

    public String getPermission(String perm) {
        return getConfig().getString(perm);
    }

    public String getMessage(String msg) {
        return this.fileConfigMessages.getString(msg);
    }

    public void setError(boolean status) {
        this.error = status;
    }

    public boolean getError() {
        return this.error;
    }

    public List<String> getStringList(String msg) {
        return this.fileConfigMessages.getStringList(msg);
    }
}
