// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.tasks;

import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.core.events.GenerateStationEvent;
import com.rdio.android.core.events.StationGeneratedEvent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.rdio.android.core.tasks:
//            PresenterTask

public class GenerateStationTask extends PresenterTask
{

    public static final int STATION = 0;
    public static final int TRACKS = 1;
    private int count;
    private List excludeTrackKeys;
    private int preset;
    private ApiModel station;

    public GenerateStationTask(ApiModel apimodel, List list, int i, int j, e e1)
    {
        super(e1);
        station = apimodel;
        excludeTrackKeys = list;
        count = i;
        preset = j;
    }

    protected void onPerformTask()
    {
        GenerateStationEvent generatestationevent = new GenerateStationEvent(station, excludeTrackKeys, count, preset, getEventRequesterId(), getEventId());
        getEventBus().post(generatestationevent);
    }

    public void onStationGenerated(StationGeneratedEvent stationgeneratedevent)
    {
label0:
        {
            if (checkRequesterId(stationgeneratedevent.getRequester()))
            {
                if (stationgeneratedevent.getTracks() != null && !stationgeneratedevent.getTracks().isEmpty())
                {
                    break label0;
                }
                onTaskError((new StringBuilder("No tracks returned for station: ")).append(station.key).toString());
            }
            return;
        }
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(stationgeneratedevent.getStation());
        arraylist.add(stationgeneratedevent.getTracks());
        onTaskCompleted(arraylist);
    }
}
