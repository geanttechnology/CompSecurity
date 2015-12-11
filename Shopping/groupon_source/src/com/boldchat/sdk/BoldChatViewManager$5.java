// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;


// Referenced classes of package com.boldchat.sdk:
//            BoldChatViewManager, BoldChatState

static class 
{

    static final int $SwitchMap$com$boldchat$sdk$BoldChatState[];

    static 
    {
        $SwitchMap$com$boldchat$sdk$BoldChatState = new int[BoldChatState.values().length];
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Idle.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.InitialLoading.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.UnavailableChat.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.UnavailableChatSending.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PreChat.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PreChatSending.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatActive.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatInactive.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.ChatEnding.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PostChat.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.PostChatSending.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Finished.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$boldchat$sdk$BoldChatState[BoldChatState.Error.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
