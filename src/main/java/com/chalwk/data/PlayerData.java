/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.data;

import org.bukkit.entity.Player;


public class PlayerData {

    private Player lastMessagedPlayer;
    private final Player player;
    public boolean activationState;
    public boolean commands;
    public boolean signs;
    public boolean anvils;
    public boolean books;
    public boolean social;
    public boolean portals;

    public PlayerData(Player player) {
        this.player = player;
        this.activationState = true;
        this.commands = true;
        this.anvils = true;
        this.books = true;
        this.signs = true;
        this.social = true;
        this.portals = true;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getActivationState() {
        return activationState;
    }

    public void setActivationState(boolean activationState) {
        this.activationState = activationState;
    }

    public void setCommands(boolean commands) {
        this.commands = commands;
    }

    public void setAnvils(boolean anvils) {
        this.anvils = anvils;
    }

    public void setBooks(boolean books) {
        this.books = books;
    }

    public void setSigns(boolean signs) {
        this.signs = signs;
    }

    public void setSocial(boolean social) {
        this.social = social;
    }

    public void setPortals(boolean portals) {
        this.portals = portals;
    }

    public Player getLastMessagedPlayer() {
        return lastMessagedPlayer;
    }

    public void setLastMessagedPlayer(Player receiver) {
        this.lastMessagedPlayer = receiver;
    }
}
