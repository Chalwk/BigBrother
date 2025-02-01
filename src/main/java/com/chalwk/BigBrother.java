/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk;

import com.chalwk.Spy.AnvilSpy;
import com.chalwk.Spy.BookSpy;
import com.chalwk.Spy.PortalSpy;
import com.chalwk.Spy.SignSpy;
import com.chalwk.listeners.CommandPreprocess;
import com.chalwk.listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static com.chalwk.Config.ON_PLUGIN_DISABLE;
import static com.chalwk.Config.ON_PLUGIN_ENABLE;
import static com.chalwk.Misc.Log;
import static com.chalwk.listeners.Commands.commandHandler;

public final class BigBrother extends JavaPlugin implements Listener {

    public static FileConfiguration config;
    static BigBrother instance;

    public static BigBrother getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;
        this.saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);

        Config.loadSettings(config);

        registerListeners();
        Log(ON_PLUGIN_ENABLE.replace("{version}", getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        Log(ON_PLUGIN_DISABLE);
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new AnvilSpy(), this);
        Bukkit.getPluginManager().registerEvents(new BookSpy(), this);
        Bukkit.getPluginManager().registerEvents(new SignSpy(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PortalSpy(), this);
        Bukkit.getPluginManager().registerEvents(new CommandPreprocess(), this);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        config = getConfig();
        Config.loadSettings(config);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return false;

        return commandHandler(sender, args);
    }
}