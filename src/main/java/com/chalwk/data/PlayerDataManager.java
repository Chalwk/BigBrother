/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.data;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {

    private static final Map<Player, PlayerData> dataMap = new HashMap<>();

    public static void setData(Player player) {
        dataMap.put(player, new PlayerData(player));
    }

    public static PlayerData getData(Player player) {
        return dataMap.getOrDefault(player, null);
    }

    public static boolean hasData(Player player) {
        return dataMap.containsKey(player);
    }
}
