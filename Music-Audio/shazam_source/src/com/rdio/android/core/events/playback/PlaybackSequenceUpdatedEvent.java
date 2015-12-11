// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

public class PlaybackSequenceUpdatedEvent
{

    private final ApiModel currentItemModel;
    private final List keyList;
    private final int updatedIndices[];

    public PlaybackSequenceUpdatedEvent(ApiModel apimodel, List list, int ai[])
    {
        keyList = list;
        currentItemModel = apimodel;
        updatedIndices = ai;
    }

    public ApiModel getCurrentItemModel()
    {
        return currentItemModel;
    }

    public List getKeyList()
    {
        return keyList;
    }

    public int[] getUpdatedIndices()
    {
        return updatedIndices;
    }
}
