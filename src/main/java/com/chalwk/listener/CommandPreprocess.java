/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static com.chalwk.Config.COMMAND_SPY_HIDDEN_LIST;
import static com.chalwk.Config.SOCIAL_SPY_TRIGGER_COMMANDS;
import static com.chalwk.Spy.CommandSpy.commandSpy;
import static com.chalwk.Spy.SocialSpy.socialSpy;

public class CommandPreprocess implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();

        if (SOCIAL_SPY_TRIGGER_COMMANDS.stream().anyMatch(command::startsWith)) {
            socialSpy(player, command);
        } else if (COMMAND_SPY_HIDDEN_LIST.stream().noneMatch(command::startsWith)) {
            commandSpy(player, command);
        }
    }
}