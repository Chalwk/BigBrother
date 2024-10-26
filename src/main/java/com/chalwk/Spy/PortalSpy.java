/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.Spy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import static com.chalwk.Config.PORTAL_SPY_NOTIFICATION;
import static com.chalwk.Misc.canUseSpyFeature;
import static com.chalwk.Misc.send;

public class PortalSpy implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String destination = event.getTo().getWorld().getName();

        for (Player admin : Bukkit.getOnlinePlayers()) {
            if (!admin.getName().equals(playerName) && canUseSpyFeature(admin, "portalspy")) {
                String notification = PORTAL_SPY_NOTIFICATION
                        .replace("{player}", playerName)
                        .replace("{destination}", destination);
                send(admin, notification);
            }
        }
    }
}