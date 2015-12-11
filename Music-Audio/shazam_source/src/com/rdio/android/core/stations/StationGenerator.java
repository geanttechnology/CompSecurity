// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.stations;

import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.GenerateStationEvent;
import com.rdio.android.core.events.StationGeneratedEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rdio.android.core.stations:
//            StationService

public abstract class StationGenerator
{

    private static final String STATION_EXTRAS[] = {
        "*.MOBILE", "availablePresets", "presetIndex", "restrictions", "trackKeys", "tracks", "allowVoting", "tracks-Track.backgroundImageUrl"
    };
    private static final String TAG = "StationGenerator";
    private e eventBus;
    private StationService rdioWebService;

    public StationGenerator(StationService stationservice, e e1)
    {
        eventBus = e1;
        rdioWebService = stationservice;
        e1.register(this);
    }

    private List getTracksFromApiModel(ApiModel apimodel)
    {
        Object obj = null;
        try
        {
            apimodel = ((ApiModel) (apimodel.getClass().getField("tracks").get(apimodel)));
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            Log.e("StationGenerator", "Failed to generate tracks for station", apimodel);
            apimodel = obj;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            Log.e("StationGenerator", "Failed to generate tracks for station", apimodel);
            apimodel = obj;
        }
        return (List)apimodel;
    }

    private void setTrackKeysOnApiModel(ApiModel apimodel, List list)
    {
        try
        {
            apimodel.getClass().getField("trackKeys").set(apimodel, list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            Log.e("StationGenerator", "Failed to generate tracks for station", apimodel);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            Log.e("StationGenerator", "Failed to generate tracks for station", apimodel);
        }
    }

    protected e getEventBus()
    {
        return eventBus;
    }

    public abstract void handleGenerateStationResponse(GenerateStationEvent generatestationevent, List list, RdioApiResponse rdioapiresponse);

    public void onGenerateStation(final GenerateStationEvent event)
    {
        final List existingTracks = getTracksFromApiModel(event.getStation());
        rdioWebService.generateStation(event.getStation().key, event.getExcludeTrackKeys(), event.getCount(), event.getPreset(), Arrays.asList(STATION_EXTRAS), new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final StationGenerator this$0;
            final GenerateStationEvent val$event;
            final List val$existingTracks;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                handleGenerateStationResponse(event, existingTracks, rdioapiresponse);
            }

            
            {
                this$0 = StationGenerator.this;
                event = generatestationevent;
                existingTracks = list;
                super();
            }
        });
    }

    public void processGeneratedStationList(GenerateStationEvent generatestationevent, List list, List list1)
    {
        list = (ApiModel)list.get(0);
        Object obj = getTracksFromApiModel(list);
        ArrayList arraylist = new ArrayList(((java.util.Collection) (obj)));
        if (list1 != null)
        {
            for (int i = list1.size() - 1; i >= 0; i--)
            {
                ((List) (obj)).add(0, list1.get(i));
            }

        }
        list1 = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); list1.add(((ApiModel)((Iterator) (obj)).next()).key)) { }
        setTrackKeysOnApiModel(list, list1);
        generatestationevent = new StationGeneratedEvent(list, arraylist, generatestationevent.getRequester(), generatestationevent.getEventId());
        eventBus.post(generatestationevent);
    }

}
