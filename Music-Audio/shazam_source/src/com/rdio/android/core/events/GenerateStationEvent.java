// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class GenerateStationEvent extends RequesterEvent
{

    private int count;
    private List excludeTrackKeys;
    private int preset;
    private ApiModel station;

    public GenerateStationEvent(ApiModel apimodel, List list, int i, int j, Object obj, Object obj1)
    {
        super(obj, obj1);
        station = apimodel;
        excludeTrackKeys = list;
        count = i;
        preset = j;
    }

    public int getCount()
    {
        return count;
    }

    public List getExcludeTrackKeys()
    {
        return excludeTrackKeys;
    }

    public int getPreset()
    {
        return preset;
    }

    public ApiModel getStation()
    {
        return station;
    }
}
