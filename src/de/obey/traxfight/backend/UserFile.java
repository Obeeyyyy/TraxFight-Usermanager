package de.obey.traxfight.backend;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        07.03.2021 | 09:45

*/

import de.obey.utils.SimpleFile;
import org.bukkit.configuration.file.YamlConfiguration;

public class UserFile {

    private SimpleFile file;

    public UserFile(String filePath){
        file = new SimpleFile(filePath);

        if(!file.exists())
            file.createFile();

        createFile();
    }

    public void createFile(){
        final YamlConfiguration cfg = file.getConfiguration();

        if(!cfg.contains("created")){
            cfg.set("created", true);
            cfg.set("ec.seiten", 1);
            cfg.set("tab.suffix", "&r");
            cfg.set("join.message", "&r");
            file.saveFileAsync();
        }
    }

    public SimpleFile getFile(){
        return file;
    }

    public YamlConfiguration getConfiguration(){
        return file.getConfiguration();
    }

}
