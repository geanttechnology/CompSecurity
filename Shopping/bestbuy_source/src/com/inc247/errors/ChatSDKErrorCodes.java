// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.errors;


public final class ChatSDKErrorCodes extends Enum
{

    public static final ChatSDKErrorCodes ChatSDKChatNotStartedError;
    public static final ChatSDKErrorCodes ChatSDKEndError;
    public static final ChatSDKErrorCodes ChatSDKInvalidParameterError;
    public static final ChatSDKErrorCodes ChatSDKNetworkError;
    public static final ChatSDKErrorCodes ChatSDKStartError;
    public static final ChatSDKErrorCodes ChatSDKUnknownError;
    private static final ChatSDKErrorCodes ENUM$VALUES[];
    private final int id;
    private final String msg;

    private ChatSDKErrorCodes(String s, int i, int j, String s1)
    {
        super(s, i);
        id = j;
        msg = s1;
    }

    public static ChatSDKErrorCodes valueOf(String s)
    {
        return (ChatSDKErrorCodes)Enum.valueOf(com/inc247/errors/ChatSDKErrorCodes, s);
    }

    public static ChatSDKErrorCodes[] values()
    {
        ChatSDKErrorCodes achatsdkerrorcodes[] = ENUM$VALUES;
        int i = achatsdkerrorcodes.length;
        ChatSDKErrorCodes achatsdkerrorcodes1[] = new ChatSDKErrorCodes[i];
        System.arraycopy(achatsdkerrorcodes, 0, achatsdkerrorcodes1, 0, i);
        return achatsdkerrorcodes1;
    }

    public int getId()
    {
        return id;
    }

    public String getMsg()
    {
        return msg;
    }

    static 
    {
        ChatSDKStartError = new ChatSDKErrorCodes("ChatSDKStartError", 0, 0, "An error occurred during chat launch.");
        ChatSDKNetworkError = new ChatSDKErrorCodes("ChatSDKNetworkError", 1, 1, "Network error occurred in agent availability check.");
        ChatSDKEndError = new ChatSDKErrorCodes("ChatSDKEndError", 2, 2, "An error occurred during ending chat session");
        ChatSDKUnknownError = new ChatSDKErrorCodes("ChatSDKUnknownError", 3, 3, "An unknown error occurred in the SDK.This will end the active chat session");
        ChatSDKChatNotStartedError = new ChatSDKErrorCodes("ChatSDKChatNotStartedError", 4, 4, "An error occurred as startChat has not been called prior to calling other methods on an active chat session");
        ChatSDKInvalidParameterError = new ChatSDKErrorCodes("ChatSDKInvalidParameterError", 5, 5, "An error occurred, as the parameters inside configuration xml are not valid.");
        ENUM$VALUES = (new ChatSDKErrorCodes[] {
            ChatSDKStartError, ChatSDKNetworkError, ChatSDKEndError, ChatSDKUnknownError, ChatSDKChatNotStartedError, ChatSDKInvalidParameterError
        });
    }
}
