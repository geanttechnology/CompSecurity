// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;

import org.json.JSONObject;

public class PubSubMessageReceivedEvent
{

    private final JSONObject data;
    private final String topic;

    public PubSubMessageReceivedEvent(String s, JSONObject jsonobject)
    {
        topic = s;
        data = jsonobject;
    }

    public JSONObject getData()
    {
        return data;
    }

    public String getTopic()
    {
        return topic;
    }
}
