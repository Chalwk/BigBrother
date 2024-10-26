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

    public static boolean socialSpy(CommandSender sender, Player receiver, String message) {
        Player player = (Player) sender;
        String senderName = player.getName();
        String receiverName = receiver.getName();

        for (Player admin : player.getServer().getOnlinePlayers()) {
            String name = admin.getName();
            if (!name.equals(senderName) && !name.equals(receiverName) && canUseSpyFeature(admin, "socialspy")) {
                String notification = SOCIAL_SPY_NOTIFICATION;
                assert notification != null;
                notification = notification
                        .replace("{sender}", senderName)
                        .replace("{receiver}", receiverName)
                        .replace("{message}", message);
                send(admin, notification);
                return true;
            }
        }
        return false;
    }
}
