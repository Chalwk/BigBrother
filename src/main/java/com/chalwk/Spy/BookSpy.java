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
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import static com.chalwk.Config.BOOK_SPY_NOTIFICATION;
import static com.chalwk.Misc.*;

public class BookSpy implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBook(PlayerEditBookEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        BookMeta newBookMeta = event.getNewBookMeta();
        if (newBookMeta.getPageCount() == 0) {
            return;
        }

        String bookText = String.join("\n", newBookMeta.getPages());

        for (Player admin : Bukkit.getOnlinePlayers()) {
            if (!admin.getName().equals(playerName) && canUseSpyFeature(admin, "bookspy")) {
                String notification = BOOK_SPY_NOTIFICATION;

                notification = notification
                        .replace("{player}", playerName)
                        .replace("{text}", bookText.trim());
                send(admin, notification);
            }
        }
    }
}