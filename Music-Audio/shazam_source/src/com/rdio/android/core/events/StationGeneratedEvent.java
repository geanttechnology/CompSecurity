// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;

import com.rdio.android.api.models.ApiModel;
import java.util.List;

// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class StationGeneratedEvent extends RequesterEvent
{

    private ApiModel station;
    private List tracks;

    public StationGeneratedEvent(ApiModel apimodel, List list, Object obj, Object obj1)
    {
        super(obj, obj1);
        tracks = list;
        station = apimodel;
    }

    public ApiModel getStation()
    {
        return station;
    }

    public List getTracks()
    {
        return tracks;
    }
}
