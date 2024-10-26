/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {

    public static String NO_PERMISSION;
    public static String ON_PLUGIN_ENABLE;
    public static String ON_PLUGIN_DISABLE;

    public static String ANVIL_SPY_NOTIFICATION;
    public static String BOOK_SPY_NOTIFICATION;
    public static String PORTAL_SPY_NOTIFICATION;
    public static String SIGN_SPY_NOTIFICATION;
    public static String SOCIAL_SPY_NOTIFICATION;
    public static String COMMAND_SPY_NOTIFICATION;

    public static String TOGGLE_MESSAGE;
    public static String TOGGLE_OTHER_MESSAGE;
    public static String INVALID_MODULE;
    public static String CONFIG_RELOAD;
    public static String INVALID_PLAYER;

    public static List<String> SOCIAL_SPY_TRIGGER_COMMANDS;
    public static List<String> COMMAND_SPY_HIDDEN_LIST;


    public static void loadSettings(FileConfiguration config) {

        NO_PERMISSION = config.getString("no-permission");
        ON_PLUGIN_ENABLE = config.getString("on-enable");
        ON_PLUGIN_DISABLE = config.getString("on-disable");

        ANVIL_SPY_NOTIFICATION = config.getString("anvil-spy.notification");
        BOOK_SPY_NOTIFICATION = config.getString("book-spy.notification");
        PORTAL_SPY_NOTIFICATION = config.getString("portal-spy.notification");
        SIGN_SPY_NOTIFICATION = config.getString("sign-spy.notification");
        SOCIAL_SPY_NOTIFICATION = config.getString("social-spy.notification");
        COMMAND_SPY_NOTIFICATION = config.getString("command-spy.notification");

        TOGGLE_MESSAGE = config.getString("toggle-message");
        TOGGLE_OTHER_MESSAGE = config.getString("toggle-other");
        INVALID_MODULE = config.getString("invalid-module");
        CONFIG_RELOAD = config.getString("config-reload");
        INVALID_PLAYER = config.getString("invalid-player");

        SOCIAL_SPY_TRIGGER_COMMANDS = config.getStringList("social-spy.trigger-commands");
        COMMAND_SPY_HIDDEN_LIST = config.getStringList("command-spy.hidden");
    }
}