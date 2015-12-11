// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import com.inc247.errors.ChatSDKError;
import org.json.JSONObject;

public interface ChatSDKEventsListener
{

    public abstract void onAgentMessage(JSONObject jsonobject);

    public abstract void onChatAgentAvailability(boolean flag);

    public abstract void onChatEnded(JSONObject jsonobject);

    public abstract void onChatError(ChatSDKError chatsdkerror);

    public abstract void onChatMaximized(JSONObject jsonobject);

    public abstract void onChatMinimized(JSONObject jsonobject);

    public abstract void onChatStarted(JSONObject jsonobject);

    public abstract void onNavigationRequest(JSONObject jsonobject);

    public abstract void onQueueIdParamRetrievalFinished();

    public abstract void onQueueIdParamRetrievalStarted();
}
