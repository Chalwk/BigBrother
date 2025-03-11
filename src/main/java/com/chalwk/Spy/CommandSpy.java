/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.Spy;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.chalwk.Config.COMMAND_SPY_NOTIFICATION;
import static com.chalwk.Misc.*;

public class CommandSpy {

    public static void commandSpy(CommandSender sender, String command) {
        String senderName = sender.getName();

        for (Player admin : Bukkit.getOnlinePlayers()) {
            if (!admin.getName().equalsIgnoreCase(senderName) && canUseSpyFeature(admin, "commandspy")) {
                String notification = COMMAND_SPY_NOTIFICATION;
                notification = notification
                        .replace("{player}", senderName)
                        .replace("{cmd}", command);
                send(admin, notification);
            }
        }
    }
}