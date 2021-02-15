package fr.neiyko.basiccmd.manager;

import fr.neiyko.basiccmd.BasicCMD;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

public class MFiles {

    private BasicCMD main = BasicCMD.getInstance();

    public void initFiles() {

        ressourceSetup("config.yml", false);
        main.fileConfigConfiguration = YamlConfiguration.loadConfiguration(main.configFile);

        ressourceSetup("messages.yml", false);
        main.fileConfigMessages = YamlConfiguration.loadConfiguration(main.messagesFile);

    }

    public void ressourceSetup(String fileName, boolean reset) {
        InputStream in = main.getResource((fileName));

        if (in == null) {
            throw new IllegalArgumentException("The '" + fileName + "' resource was not found !");
        }

        File outDir = new File(main.getDataFolder(), "");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        String fileNameString = fileName.toLowerCase();
        if (fileNameString.equals("config.yml") || fileName.equals("messages.yml")) {
            File outFile = new File(main.getDataFolder(), fileName);
            if (!outFile.exists() || reset) {
                try {
                    OutputStream out = new FileOutputStream(outFile);
                    byte[] buf = new byte['?'];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.close();
                    in.close();
                    return;
                } catch (Exception e) {
                    main.logConsole(Level.WARNING, "The '" + fileName + "' was not found !");
                }
            }
        }
    }
}
