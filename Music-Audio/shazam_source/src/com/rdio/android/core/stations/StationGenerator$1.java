// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.stations;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.GenerateStationEvent;
import java.util.List;

// Referenced classes of package com.rdio.android.core.stations:
//            StationGenerator

class val.existingTracks
    implements com.rdio.android.core.ponseListener
{

    final StationGenerator this$0;
    final GenerateStationEvent val$event;
    final List val$existingTracks;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        handleGenerateStationResponse(val$event, val$existingTracks, rdioapiresponse);
    }

    ener()
    {
        this$0 = final_stationgenerator;
        val$event = generatestationevent;
        val$existingTracks = List.this;
        super();
    }
}
