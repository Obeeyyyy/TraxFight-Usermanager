package de.obey.traxfight.backend.events;

/*

        (TraxFight-Usermanager)
  This Class was created by Obey
        20.02.2021 | 04:57

*/

import de.obey.traxfight.backend.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserSaveDataEvent extends Event {

    private static HandlerList handlers = new HandlerList();

    private User user;

    public UserSaveDataEvent(User user){
        this.user = user;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public User getUser() {
        return user;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
