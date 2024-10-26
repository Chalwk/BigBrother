/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.Spy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import static com.chalwk.Config.SIGN_SPY_NOTIFICATION;
import static com.chalwk.Misc.canUseSpyFeature;
import static com.chalwk.Misc.send;

public class SignSpy implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        String[] lines = event.getLines();

        if (lines[0].isEmpty() && lines[1].isEmpty() && lines[2].isEmpty() && lines[3].isEmpty()) {
            return;
        }

        Player player = event.getPlayer();
        String playerName = player.getName();
        String notification = SIGN_SPY_NOTIFICATION
                .replace("{player}", playerName);

        for (int i = 0; i < lines.length; i++) {
            notification = notification.replace("{line" + (i + 1) + "}", lines[i]);
        }

        for (Player admin : Bukkit.getOnlinePlayers()) {
            if (!admin.getName().equals(playerName) && canUseSpyFeature(admin, "signspy")) {
                send(admin, notification);
            }
        }
    }
}