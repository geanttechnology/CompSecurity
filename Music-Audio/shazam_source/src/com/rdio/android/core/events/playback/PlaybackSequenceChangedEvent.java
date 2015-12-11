// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

public class PlaybackSequenceChangedEvent
{

    private final List currentItemKeys;
    private final ApiModel currentItemModel;
    private final int currentPosition;
    private final List queuedKeys;

    public PlaybackSequenceChangedEvent(ApiModel apimodel, List list, List list1, int i)
    {
        currentItemModel = apimodel;
        currentItemKeys = list;
        queuedKeys = list1;
        currentPosition = i;
    }

    public List getCurrentItemKeys()
    {
        return currentItemKeys;
    }

    public ApiModel getCurrentItemModel()
    {
        return currentItemModel;
    }

    public int getCurrentPosition()
    {
        return currentPosition;
    }

    public List getQueuedKeys()
    {
        return queuedKeys;
    }
}
