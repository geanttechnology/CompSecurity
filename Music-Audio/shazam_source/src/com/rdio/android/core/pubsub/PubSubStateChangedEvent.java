// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;


public class PubSubStateChangedEvent
{

    private final String clientName;
    private final PubSubConnection.State state;
    private final String userTopic;

    public PubSubStateChangedEvent(PubSubConnection.State state1, String s, String s1)
    {
        state = state1;
        userTopic = s;
        clientName = s1;
    }

    public String getClientName()
    {
        return clientName;
    }

    public PubSubConnection.State getState()
    {
        return state;
    }

    public String getUserTopic()
    {
        return userTopic;
    }
}
