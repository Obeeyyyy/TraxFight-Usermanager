package de.obey.traxfight.backend;

/* 
        <- Code by Obey ->
         TraxFight-Usermanager
         24.12.2020 | 19:59
*/

import de.obey.traxfight.backend.events.UserChangeDataEvent;
import de.obey.traxfight.backend.events.UserLoadDataEvent;
import de.obey.traxfight.backend.events.UserReloadDataEvent;
import de.obey.traxfight.backend.events.UserSaveDataEvent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class User {

    private final Map<String, Long> longs = new HashMap<>();
    private final Map<String, Integer> integers = new HashMap<>();
    private final Map<String, Double> doubles = new HashMap<>();
    private final Map<String, String> strings = new HashMap<>();
    private final Map<String, Boolean> bools = new HashMap<>();
    private final Map<String, Inventory> inventories = new HashMap<>();

    private Rang rang;
    private Clan clan;
    private UserFile userFile;

    private Player player;
    private OfflinePlayer offlinePlayer;

    public User(OfflinePlayer player){
        offlinePlayer = player;

        loadData();
    }

    public User(Player player) {
        this.player = player;
        offlinePlayer = player;
    }

    public void reloadData(Player player){
        this.player = player;
        offlinePlayer = player;

        UserReloadDataEvent userReloadDataEvent = new UserReloadDataEvent(this);
        Bukkit.getPluginManager().callEvent(userReloadDataEvent);
    }

    public void loadData(){
        UserLoadDataEvent userLoadDataEvent = new UserLoadDataEvent(this);
        Bukkit.getPluginManager().callEvent(userLoadDataEvent);
    }

    public void saveData(){
        UserSaveDataEvent userSaveDataEvent = new UserSaveDataEvent(this);
        Bukkit.getPluginManager().callEvent(userSaveDataEvent);
    }

    private void callChange(){
        UserChangeDataEvent userChangeDataEvent = new UserChangeDataEvent(this);
        Bukkit.getPluginManager().callEvent(userChangeDataEvent);
    }

    // SETTER \\
    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public void setUserFile(UserFile userFile){
        this.userFile = userFile;
    }

    public void setLong(String what, long amount){
        longs.put(what, amount);
    }

    public void setInteger(String what, int amount){
        integers.put(what, amount);
    }

    public void setDouble(String what, double amount){
        doubles.put(what, amount);
    }

    public void setString(String what, String value){
        strings.put(what, value);
    }

    public void setInventory(String what, Inventory value){
        inventories.put(what, value);
    }

    // ADDER \\
    public void addLong(String what, long amount){
        longs.put(what, longs.get(what) + amount);
        callChange();
    }

    public void addInteger(String what, int amount){
        integers.put(what, integers.get(what) + amount);
        callChange();
    }

    public void addDouble(String what, double amount){
        doubles.put(what, doubles.get(what) + amount);
        callChange();
    }


    // REMOVER \\
    public void removeLong(String what, long amount){
        long data = longs.get(what) - amount;

        if(data < 0)
            data = 0;

        longs.put(what, data);
        callChange();
    }

    public void removeInteger(String what, int amount){
        int data = integers.get(what) - amount;

        if(data < 0)
            data = 0;

        integers.put(what, data);
        callChange();
    }

    public void removeDouble(String what, double amount){
        double data = integers.get(what) - amount;

        if(data < 0)
            data = 0;

        doubles.put(what, data);
        callChange();
    }


    // GETTER \\
    public Rang getRang() {
        return rang;
    }

    public Clan getClan() {
        return clan;
    }

    public UserFile getUserFile(){
        return userFile;
    }

    public long getLong(String what){
        return longs.get(what);
    }

    public int getInteger(String what){
        return integers.get(what);
    }

    public double getDouble(String what){
        return doubles.get(what);
    }

    public boolean getBoolean(String what){
        return bools.get(what);
    }

    public String getString(String what){
        return strings.get(what);
    }

    public Inventory getInventory(String what){
        return inventories.get(what);
    }

    public Player getPlayer() {
        return player;
    }

    public OfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }
}
