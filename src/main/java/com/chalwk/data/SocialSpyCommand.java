/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.data;

public enum SocialSpyCommand {

    TELL("/tell", 1),
    WHISPER("/whisper", 1),
    M("/m", 1),
    T("/t", 1),
    EMESSAGE("/emsg", 1),
    ETELL("/etell", 1),
    EWHISPER("/ewhisper", 1),
    PM("/pm", 1),
    BMSG("/bmsg", 1),
    BPM("/bpm", 1),
    MESSAGE("/message", 1),
    MSGCHAT("/msgchat", 1),
    PRIVMSG("/privmsg", 1),
    PMC("/pmc", 1),
    CMI_MSG("/cmi msg", 2),
    CMI_T("/cmi t", 2),
    CMI_WHISPER("/cmi whisper", 2),
    CMI_TELL("/cmi tell", 2),

    BREPLY("/breply", 0),
    CMI_REPLY("/cmi reply", 0),
    CMI_R("/cmi r", 0),
    EREPLY("/ereply", 0),
    ER("/er", 0),
    MREPLY("/mreply", 0),
    REPLY("/reply", 0),
    R("/r", 0);

    private final String command;
    private final int recipientIndex;

    SocialSpyCommand(String command, int recipientIndex) {
        this.command = command;
        this.recipientIndex = recipientIndex;
    }

    public String getCommand() {
        return command;
    }

    public int getRecipientIndex() {
        return recipientIndex;
    }
}