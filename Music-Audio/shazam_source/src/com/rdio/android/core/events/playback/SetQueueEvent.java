// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;

import java.util.List;

public class SetQueueEvent
{

    private final List queueItems;

    public SetQueueEvent(List list)
    {
        queueItems = list;
    }

    public List getQueueItems()
    {
        return queueItems;
    }
}
