package de.obey.traxfight.backend;

/* 
        <- Code by Obey ->
         TraxFight-Usermanager
         24.12.2020 | 19:58
*/

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    private Map<UUID, User> users = new HashMap<>();

    public UserManager(String dataFile){
        final File file = new File(dataFile + "/UserFiles");

        if(!file.exists())
            file.mkdir();
    }

    public void loadAllUsers() {
        if(Bukkit.getOnlinePlayers().size() == 0)
            return;

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (!hasUser(all))
                loadUser(all);
        }
    }

    public void saveAllUsers(){
        if(Bukkit.getOnlinePlayers().size() == 0)
            return;

        for(User user : users.values())
            user.saveData();
    }

    public void loadUser(Player player) {
        User user = getUserFromPlayer(player);

        if(user != null ){
            user.reloadData(player);
            return;
        }

        user = new User(player);

        users.put(player.getUniqueId(), user);

        user.loadData();
    }

    public void saveUser(Player player){
        User user = getUserFromPlayer(player);

        if(user == null)
            return;

        user.saveData();
    }

    public void unloadUser(Player player) {
        users.remove(player.getUniqueId());
    }

    public boolean hasUser(Player player) {
        return users.containsKey(player.getUniqueId());
    }

    public User getUserFromOfflinePlayer(OfflinePlayer player){
        User user = getUserFromUUID(player.getUniqueId());

        if(user != null)
            return user;

        user = new User(player);
        users.put(player.getUniqueId(), user);

        return user;
    }

    public User getUserFromPlayer(Player player) {
        return users.get(player.getUniqueId());
    }

    public User getUserFromUUID(UUID uuid) {
        return users.get(uuid);
    }

}
