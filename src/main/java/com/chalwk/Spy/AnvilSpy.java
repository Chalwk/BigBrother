/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.Spy;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.chalwk.Config.ANVIL_SPY_NOTIFICATION;
import static com.chalwk.Misc.canUseSpyFeature;
import static com.chalwk.Misc.send;

public class AnvilSpy implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.isCancelled()) {
            return;
        }

        HumanEntity entity = event.getWhoClicked();
        Inventory inventory = event.getInventory();

        if (!(entity instanceof Player) || !(inventory instanceof AnvilInventory)) {
            return;
        }

        InventoryView view = event.getView();
        int rawSlot = event.getRawSlot();

        if (rawSlot != view.convertSlot(rawSlot) && rawSlot != 2) {
            return;
        }

        ItemStack item = event.getCurrentItem();
        if (item == null || !item.hasItemMeta()) {
            return;
        }

        Player player = (Player) entity;
        ItemMeta meta = item.getItemMeta();

        if (meta.hasDisplayName()) {
            String playerName = player.getName();
            String itemDisplayName = meta.getDisplayName();

            for (Player admin : Bukkit.getOnlinePlayers()) {
                if (!admin.getName().equals(playerName) && canUseSpyFeature(admin, "anvilspy")) {
                    String notification = ANVIL_SPY_NOTIFICATION
                            .replace("{player}", playerName)
                            .replace("{item}", item.getType().toString())
                            .replace("{newname}", itemDisplayName);
                    send(admin, notification);
                }
            }
        }
    }
}