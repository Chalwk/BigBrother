/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.Spy;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.chalwk.Config.SOCIAL_SPY_NOTIFICATION;
import static com.chalwk.Misc.canUseSpyFeature;
import static com.chalwk.Misc.send;

public class SocialSpy {

    public static boolean socialSpy(CommandSender sender, String command) {
        Player player = (Player) sender;
        String playerName = player.getName();

        for (Player admin : player.getServer().getOnlinePlayers()) {
            if (!admin.getName().equals(playerName) && canUseSpyFeature(admin, "socialspy")) {
                String notification = SOCIAL_SPY_NOTIFICATION;
                assert notification != null;
                notification = notification
                        .replace("{player}", playerName)
                        .replace("{cmd}", command);
                send(admin, notification);
                return true;
            }
        }
        return false;
    }
}
