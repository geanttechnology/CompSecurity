// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;


public class PubSubTopicSubscriptionEvent
{

    private final boolean subscribe;
    private final String topic;

    public PubSubTopicSubscriptionEvent(String s, boolean flag)
    {
        topic = s;
        subscribe = flag;
    }

    public String getTopic()
    {
        return topic;
    }

    public boolean isSubscribe()
    {
        return subscribe;
    }
}
