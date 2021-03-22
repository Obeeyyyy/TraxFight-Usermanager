package de.obey.traxfight.backend;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        12.03.2021 | 12:59

*/

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClanManager {

    private final Map<Integer, Clan> clans = new HashMap<>();
    private final Map<String, Integer> nameClans = new HashMap<>();

    public ClanManager() {}

    public void sendToAllClanMembers(Clan clan, String message){
        for(Object uuidObject : clan.getList("member")){
            final String uuidString = (String) uuidObject;
            final UUID uuid = UUID.fromString(uuidString);

            final Player member = Bukkit.getPlayer(uuid);

            if(member != null && member.isOnline())
                member.sendMessage(message);

        }
    }

    public boolean isLoaded(String clanName){
        if(nameClans.containsKey(clanName.toLowerCase()))
            return true;

        return false;
    }

    public Clan getClanFromId(int id){
        return clans.get(id);
    }

    public Clan getClanFromUser(User user){
        return clans.get(user.getInteger("clanid"));
    }

    public Clan getClanFromName(String clanName){
        clanName = clanName.toLowerCase();

        return clans.get(nameClans.get(clanName));
    }

    public boolean isInClan(User user){
        if(user.getClan() == null)
            return false;

        return true;
    }

    public void saveAllClans(){
        for(Clan clan : clans.values())
            clan.saveData();
    }

    public void loadClanById(int id){
        final Clan clan = new Clan(id);

        clans.put(id, clan);
    }

    public void loadClanByUser(User user){
        if(getClanFromUser(user) != null)
            return;

        final int clanId = user.getInteger("clanid");
        final Clan clan = new Clan(clanId);

        clans.put(clanId, clan);

        user.setClan(clan);
    }

    public Map<String, Integer> getNameClans() {
        return nameClans;
    }

    public Map<Integer, Clan> getClans() {
        return clans;
    }
}
