package de.obey.traxfight.backend;

/*

        (TraxFight-Systems)
  This Class was created by Obey
        20.01.2021 | 23:33

*/

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Rang {

    private File rangFile;

    private int rangId = 20;

    private String rangName;
    private String rangNameColor;
    private String tabPrefix;
    private String tabSuffix;
    private String chatPrefix;
    private String chatSuffix;
    private String overNamePrefix;
    private String overNameSuffix;

    public Rang(File file){
        rangFile = file;
        loadData();
    }

    private void loadData(){
        //CompletableFuture.runAsync(() -> {
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(rangFile);

            rangName = cfg.getString("name");
            rangId = cfg.getInt("id");
            rangNameColor = ChatColor.translateAlternateColorCodes('&', cfg.getString("rangNameColor"));
            tabPrefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("tab.prefix"));
            tabSuffix = ChatColor.translateAlternateColorCodes('&', cfg.getString("tab.suffix"));
            chatPrefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("chat.prefix"));
            chatSuffix = ChatColor.translateAlternateColorCodes('&', cfg.getString("chat.suffix"));
            overNamePrefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("overname.prefix"));
            overNameSuffix = ChatColor.translateAlternateColorCodes('&', cfg.getString("overname.suffix"));
        //});
    }

    public File getRangFile() {
        return rangFile;
    }

    public int getRangId() {
        return rangId;
    }

    public String getRangName() {
        return rangName;
    }

    public String getRangNameColor() {
        return rangNameColor;
    }

    public String getTabPrefix() {
        return tabPrefix;
    }

    public String getTabSuffix() {
        return tabSuffix;
    }

    public String getChatPrefix() {
        return chatPrefix;
    }

    public String getChatSuffix() {
        return chatSuffix;
    }

    public String getOverNamePrefix() {
        return overNamePrefix;
    }

    public String getOverNameSuffix() {
        return overNameSuffix;
    }
}
