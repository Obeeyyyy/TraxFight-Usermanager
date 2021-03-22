package de.obey.traxfight.backend;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        14.03.2021 | 22:49

*/

import de.obey.utils.SimpleFile;
import org.bukkit.configuration.file.YamlConfiguration;

public class ClanFile {

    private SimpleFile file;

    public ClanFile(String filePath, Clan clan){
        file = new SimpleFile(filePath + "/" + clan.getString("name") + ".yml");

        if(!file.exists())
            file.createFile();
    }

    public SimpleFile getFile(){
        return file;
    }

    public YamlConfiguration getConfiguration(){
        return file.getConfiguration();
    }
}
