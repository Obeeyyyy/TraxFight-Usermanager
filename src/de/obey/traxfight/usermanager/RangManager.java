package de.obey.traxfight.usermanager;

/*

        (TraxFight-Systems)
  This Class was created by Obey
        20.01.2021 | 23:37

*/

import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RangManager {

    private Map<String, Rang> rangMap = new HashMap<>();

    public RangManager(){}

    public void setup(File dataFolder){
        File groups = new File(dataFolder.getPath() + "/Groups");

        for(File rangFile : groups.listFiles())
            rangMap.put(rangFile.getName().replaceAll(".yml", ""), new Rang(rangFile));
    }

    public void createFolder(File file){
        File groups = new File(file.getPath() + "/Groups");

        if(!groups.exists())
            groups.mkdir();
    }

    public Rang getPlayerRang(Player player){
        String rangName = PermissionsEx.getUser(player).getGroupNames()[0];

        return rangMap.get(rangName);
    }

    public Map<String, Rang> getRangMap() {
        return rangMap;
    }
}
