/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.data;

public enum Module {
    COMMANDS("commands", "bigbrother.commandspy.toggle", "Command Spy"),
    SIGNS("signs", "bigbrother.signspy.toggle", "Sign Spy"),
    ANVILS("anvils", "bigbrother.anvilspy.toggle", "Anvil Spy"),
    BOOKS("books", "bigbrother.bookspy.toggle", "Book Spy"),
    PORTALS("portals", "bigbrother.portalspy.toggle", "Portal Spy");

    private final String name;
    private final String permission;
    private final String displayName;

    Module(String name, String permission, String displayName) {
        this.name = name;
        this.permission = permission;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public String getDisplayName() {
        return displayName;
    }
}
