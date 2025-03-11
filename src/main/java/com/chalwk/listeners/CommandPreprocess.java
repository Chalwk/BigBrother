/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static com.chalwk.Spy.CommandSpy.commandSpy;

public class CommandPreprocess implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player sender = event.getPlayer();
        String command = event.getMessage();
        commandSpy(sender, command);
    }
}