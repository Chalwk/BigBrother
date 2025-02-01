/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.listeners;

import com.chalwk.data.PlayerData;
import com.chalwk.data.PlayerDataManager;
import com.chalwk.data.SocialSpyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;

import static com.chalwk.Config.COMMAND_SPY_HIDDEN_LIST;
import static com.chalwk.Spy.CommandSpy.commandSpy;
import static com.chalwk.Spy.SocialSpy.socialSpy;

public class CommandPreprocess implements Listener {

    private boolean hiddenCommand(String command) {
        return COMMAND_SPY_HIDDEN_LIST.stream().anyMatch(command::startsWith);
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player sender = event.getPlayer();
        String command = event.getMessage();
        String[] args = command.split(" ");
        PlayerData senderData = PlayerDataManager.getData(sender);

        // Command spy logic
        if (!hiddenCommand(command)) {
            commandSpy(sender, command);
            return;
        }

        // Handle social spy commands:
        if (args.length > 1) {
            StringBuilder commandBuilder = new StringBuilder(args[0]);
            SocialSpyCommand socialSpyCommand = null;

            // Loop through args to handle multi-word commands
            for (int i = 1; i < args.length; i++) {
                String currentCommand = commandBuilder.toString();

                socialSpyCommand = Arrays.stream(SocialSpyCommand.values())
                        .filter(cmd -> cmd.getCommand().equalsIgnoreCase(currentCommand))
                        .findFirst()
                        .orElse(null);

                if (socialSpyCommand != null) {
                    break;
                }

                // Add the next word and continue building
                commandBuilder.append(" ").append(args[i]);
            }

            if (socialSpyCommand != null) {
                int recipientIndex = socialSpyCommand.getRecipientIndex();

                // Handle commands that require a recipient to be defined
                if (recipientIndex > 0 && args.length > recipientIndex + 1) {
                    String playerName = args[recipientIndex];
                    Player recipient = Bukkit.getPlayerExact(playerName);

                    if (recipient != null) {
                        String message = String.join(" ", Arrays.copyOfRange(args, recipientIndex + 1, args.length));
                        senderData.setLastMessagedPlayer(recipient);
                        socialSpy(sender, recipient, message);
                        return;
                    }
                }

                // Handle commands that do not require a recipient
                if (recipientIndex == 0) {
                    Player lastMessagedPlayer = senderData.getLastMessagedPlayer();
                    if (lastMessagedPlayer != null) {
                        String message = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                        socialSpy(sender, lastMessagedPlayer, message);
                    }
                }
            }
        }
    }
}