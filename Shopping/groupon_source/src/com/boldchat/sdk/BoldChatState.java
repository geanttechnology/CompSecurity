// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;


public final class BoldChatState extends Enum
{

    private static final BoldChatState $VALUES[];
    public static final BoldChatState ChatActive;
    public static final BoldChatState ChatEnding;
    public static final BoldChatState ChatInactive;
    public static final BoldChatState Error;
    public static final BoldChatState Finished;
    public static final BoldChatState Idle;
    public static final BoldChatState InitialLoading;
    public static final BoldChatState PostChat;
    public static final BoldChatState PostChatSending;
    public static final BoldChatState PreChat;
    public static final BoldChatState PreChatSending;
    public static final BoldChatState UnavailableChat;
    public static final BoldChatState UnavailableChatSending;

    private BoldChatState(String s, int i)
    {
        super(s, i);
    }

    public static BoldChatState valueOf(String s)
    {
        return (BoldChatState)Enum.valueOf(com/boldchat/sdk/BoldChatState, s);
    }

    public static BoldChatState[] values()
    {
        return (BoldChatState[])$VALUES.clone();
    }

    static 
    {
        Idle = new BoldChatState("Idle", 0);
        InitialLoading = new BoldChatState("InitialLoading", 1);
        PreChat = new BoldChatState("PreChat", 2);
        PreChatSending = new BoldChatState("PreChatSending", 3);
        ChatActive = new BoldChatState("ChatActive", 4);
        ChatInactive = new BoldChatState("ChatInactive", 5);
        ChatEnding = new BoldChatState("ChatEnding", 6);
        PostChat = new BoldChatState("PostChat", 7);
        PostChatSending = new BoldChatState("PostChatSending", 8);
        UnavailableChat = new BoldChatState("UnavailableChat", 9);
        UnavailableChatSending = new BoldChatState("UnavailableChatSending", 10);
        Finished = new BoldChatState("Finished", 11);
        Error = new BoldChatState("Error", 12);
        $VALUES = (new BoldChatState[] {
            Idle, InitialLoading, PreChat, PreChatSending, ChatActive, ChatInactive, ChatEnding, PostChat, PostChatSending, UnavailableChat, 
            UnavailableChatSending, Finished, Error
        });
    }
}
