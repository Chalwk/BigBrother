/*
 * Copyright (c) 2024 Jericho Crosby <jericho.crosby@gmail.com>
 *
 * This software is licensed under the MIT License. See the LICENSE file for details.
 */

package com.chalwk.data;

public enum SocialSpyCommand {

    // Requires recipient
    TELL("/tell", 1),                       // /tell playerName message
    WHISPER("/whisper", 1),                 // /whisper playerName message
    M("/m", 1),                             // /m playerName message
    T("/t", 1),                             // /t playerName message
    EMESSAGE("/emsg", 1),                   // /emsg playerName message
    ETELL("/etell", 1),                     // /etell playerName message
    EWHISPER("/ewhisper", 1),               // /ewhisper playerName message
    PM("/pm", 1),                           // /pm playerName message
    BMSG("/bmsg", 1),                       // /bmsg playerName message
    BPM("/bpm", 1),                         // /bpm playerName message
    MESSAGE("/message", 1),                 // /message playerName message
    MSGCHAT("/msgchat", 1),                 // /msgchat playerName message
    PRIVMSG("/privmsg", 1),                 // /privmsg playerName message
    PMC("/pmc", 1),                         // /pmc playerName message
    CMI_MSG("/cmi msg", 2),                 // /cmi msg playerName message
    CMI_T("/cmi t", 2),                     // /cmi t playerName message
    CMI_WHISPER("/cmi whisper", 2),         // /cmi whisper playerName message
    CMI_TELL("/cmi tell", 2),               // /cmi tell playerName message

    // No recipient required
    BREPLY("/breply", 0),                   // /breply message
    CMI_REPLY("/cmi reply", 0),             // /cmi reply message
    CMI_R("/cmi r", 0),                     // /cmi r message
    EREPLY("/ereply", 0),                   // /ereply message
    ER("/er", 0),                           // /er message
    MREPLY("/mreply", 0),                   // /mreply message
    REPLY("/reply", 0),                     // /reply message
    R("/r", 0);                             // /r message

    private final String command;
    private final int recipientIndex;

    SocialSpyCommand(String command, int recipientIndex) {
        this.command = command;
        this.recipientIndex = recipientIndex;
    }

    public static boolean requiresRecipient(String command) {
        for (SocialSpyCommand socialSpyCommand : values()) {
            if (socialSpyCommand.getCommand().equalsIgnoreCase(command)) {
                return socialSpyCommand.getRecipientIndex() > 0;
            }
        }
        return false;
    }

    public static SocialSpyCommand fromCommand(String command) {
        for (SocialSpyCommand socialSpyCommand : values()) {
            if (socialSpyCommand.getCommand().equalsIgnoreCase(command)) {
                return socialSpyCommand;
            }
        }
        return null; // or throw an exception based on your use case
    }

    public String getCommand() {
        return command;
    }

    public int getRecipientIndex() {
        return recipientIndex;
    }
}