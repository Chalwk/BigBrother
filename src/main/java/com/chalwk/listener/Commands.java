/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.listener;

import com.chalwk.BigBrother;
import com.chalwk.data.Module;
import com.chalwk.data.PlayerData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import static com.chalwk.Config.*;
import static com.chalwk.Misc.hasPermission;
import static com.chalwk.Misc.send;
import static com.chalwk.data.PlayerDataManager.getData;

public class Commands {

    private static final BigBrother instance = BigBrother.getInstance();

    public static boolean commandHandler(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        PlayerData playerData = getData(player);

        if (args.length == 0) {
            toggleActivation(player);
        } else {
            String command = args[0].toLowerCase();
            if (command.equals("reload") && hasPermission(player, "bigbrother.reload")) {
                instance.reloadConfig();
                send(player, CONFIG_RELOAD);
            } else {
                handleModuleCommand(player, command, playerData, args);
            }
        }
        return true;
    }

    private static void toggleActivation(Player player) {
        boolean activationState = getData(player).getActivationState();
        getData(player).setActivationState(!activationState);
        notify(player, TOGGLE_MESSAGE, activationState, "Big Brother", null);
    }

    private static void handleModuleCommand(Player player, String moduleName, PlayerData playerData, String[] args) {
        for (Module module : Module.values()) {
            if (module.getName().equals(moduleName)) {
                toggleModule(player, playerData, module, args);
                return;
            }
        }
        send(player, INVALID_MODULE);
    }

    private static void toggleModule(Player player, PlayerData playerData, Module module, String[] args) {
        boolean currentState;

        switch (module) {
            case COMMANDS:
                currentState = !playerData.commands;
                break;
            case SIGNS:
                currentState = !playerData.signs;
                break;
            case ANVILS:
                currentState = !playerData.anvils;
                break;
            case BOOKS:
                currentState = !playerData.books;
                break;
            case SOCIAL:
                currentState = !playerData.social;
                break;
            case PORTALS:
                currentState = !playerData.portals;
                break;
            default:
                return; // This should not happen due to previous checks
        }

        if (args.length == 1) {
            togglePlayerData(playerData, module);
            notify(player, TOGGLE_MESSAGE, currentState, module.getDisplayName(), null);
        } else if (hasPermission(player, module.getPermission() + ".others")) {
            Player target = getPlayer(player, args);
            if (target != null) {
                togglePlayerData(getData(target), module);
                notify(player, TOGGLE_OTHER_MESSAGE, currentState, module.getDisplayName(), target.getName());
            }
        }
    }

    private static void togglePlayerData(PlayerData playerData, Module module) {
        switch (module) {
            case COMMANDS:
                playerData.setCommands(!playerData.commands);
                break;
            case SIGNS:
                playerData.setSigns(!playerData.signs);
                break;
            case ANVILS:
                playerData.setAnvils(!playerData.anvils);
                break;
            case BOOKS:
                playerData.setBooks(!playerData.books);
                break;
            case SOCIAL:
                playerData.setSocial(!playerData.social);
                break;
            case PORTALS:
                playerData.setPortals(!playerData.portals);
                break;
        }
    }

    private static void notify(Player sender, String toggleMessage, boolean currentState, String label, String targetName) {
        targetName = targetName == null ? "" : targetName;
        String message = toggleMessage
                .replace("{state}", currentState ? "disabled" : "enabled")
                .replace("{module}", label)
                .replace("{player}", targetName);
        send(sender, message);
    }

    @Nullable
    private static Player getPlayer(Player sender, String[] args) {
        if (args.length < 2) {
            send(sender, INVALID_PLAYER);
            return null;
        }

        Player target = sender.getServer().getPlayer(args[1]);
        if (target == null) {
            send(sender, INVALID_PLAYER);
            return null;
        }
        return target;
    }
}