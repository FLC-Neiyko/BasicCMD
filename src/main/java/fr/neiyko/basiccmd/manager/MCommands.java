package fr.neiyko.basiccmd.manager;

import fr.neiyko.basiccmd.BasicCMD;
import fr.neiyko.basiccmd.commands.*;

public class MCommands {

    private BasicCMD main = BasicCMD.getInstance();

    public void initCommands() {
        main.getCommand("discord").setExecutor(new CDiscord());
        main.getCommand("teamspeak").setExecutor(new CTeamspeak());
        main.getCommand("contentcreator").setExecutor(new CContentCreator());
        main.getCommand("rules").setExecutor(new CRules());
        main.getCommand("staff").setExecutor(new CStaff());
    }
}
