package de.obey.traxfight.usermanager;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        25.02.2021 | 09:39

*/

import de.obey.traxfight.usermanager.events.ClanLoadDataEvent;
import de.obey.traxfight.usermanager.events.ClanSaveDataEvent;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class Clan {

    private final HashMap<String, Long> longs = new HashMap<>();
    private final HashMap<String, Integer> integers = new HashMap<>();
    private final HashMap<String, Double> doubles = new HashMap<>();
    private final HashMap<String, String> strings = new HashMap<>();
    private final HashMap<String, Boolean> bools = new HashMap<>();

    public Clan(){

    }

    public void loadData(){
        ClanLoadDataEvent clanLoadDataEvent = new ClanLoadDataEvent(this);
        Bukkit.getPluginManager().callEvent(clanLoadDataEvent);
    }

    public void saveData(){
        ClanSaveDataEvent clanSaveDataEvent = new ClanSaveDataEvent(this);
        Bukkit.getPluginManager().callEvent(clanSaveDataEvent);
    }

    // SETTER \\
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

    // ADDER \\
    public void addLong(String what, long amount){
        longs.put(what, longs.get(what) + amount);
    }

    public void addInteger(String what, int amount){
        integers.put(what, integers.get(what) + amount);
    }

    public void addDouble(String what, double amount){
        doubles.put(what, doubles.get(what) + amount);
    }


    // REMOVER \\
    public void removeLong(String what, long amount){
        long data = longs.get(what) - amount;

        if(data < 0)
            data = 0;

        longs.put(what, data);
    }

    public void removeInteger(String what, int amount){
        int data = integers.get(what) - amount;

        if(data < 0)
            data = 0;

        integers.put(what, data);
    }

    public void removeDouble(String what, double amount){
        double data = integers.get(what) - amount;

        if(data < 0)
            data = 0;

        doubles.put(what, data);
    }


    // GETTER \\

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

}
