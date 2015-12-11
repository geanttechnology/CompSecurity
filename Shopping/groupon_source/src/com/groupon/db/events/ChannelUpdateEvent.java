// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import commonlib.loader.event.UpdateEvent;

public class ChannelUpdateEvent extends UpdateEvent
{

    public static final int UNUSED_DEAL_SIZE = -1;
    private String channel;
    private int dealSize;

    public ChannelUpdateEvent(String s, int i)
    {
        channel = s;
        dealSize = i;
    }

    public String getChannel()
    {
        return channel;
    }

    public int getDealSize()
    {
        return dealSize;
    }
}
