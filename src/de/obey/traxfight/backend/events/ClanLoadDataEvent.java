package de.obey.traxfight.backend.events;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        25.02.2021 | 09:41

*/

import de.obey.traxfight.backend.Clan;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanLoadDataEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private Clan clan;

    public ClanLoadDataEvent(Clan clan){
        this.clan = clan;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Clan getClan() {
        return clan;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
