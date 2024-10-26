/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk;

import com.chalwk.data.PlayerDataManager;
import org.bukkit.entity.Player;

import static com.chalwk.Config.NO_PERMISSION;
import static org.bukkit.Bukkit.getLogger;

public class Misc {

    private static String colorize(String message) {
        return message != null ? message.replace('&', '§') : null;
    }

    public static void send(Player sender, String msg) {
        if (msg != null) {
            sender.sendMessage(colorize(msg));
        }
    }

    public static void Log(String message) {
        if (message != null) {
            getLogger().info("[BigBrother] " + message);
        }
    }

    public static boolean hasPermission(Player player, String permission) {
        if (!(player.hasPermission(permission))) {
            send(player, NO_PERMISSION);
            return false;
        }
        return true;
    }

    private static boolean hasPerm(Player player, String perm) {
        return player.hasPermission(perm) || player.isOp();
    }

    public static boolean canUseSpyFeature(Player player, String spyType) {

        String togglePermission = "bigbrother." + spyType + ".toggle";
        boolean isSpyActive;

        switch (spyType.toLowerCase()) {
            case "anvilspy":
                isSpyActive = PlayerDataManager.getData(player).anvils;
                break;
            case "commandspy":
                isSpyActive = PlayerDataManager.getData(player).commands;
                break;
            case "signspy":
                isSpyActive = PlayerDataManager.getData(player).signs;
                break;
            case "bookspy":
                isSpyActive = PlayerDataManager.getData(player).books;
                break;
            case "socialspy":
                isSpyActive = PlayerDataManager.getData(player).social;
                break;
            case "portalspy":
                isSpyActive = PlayerDataManager.getData(player).portals;
                break;
            default:
                return false;
        }

        return hasPerm(player, "bigbrother.use")
                && hasPerm(player, togglePermission)
                && PlayerDataManager.getData(player).activationState
                && isSpyActive;
    }
}