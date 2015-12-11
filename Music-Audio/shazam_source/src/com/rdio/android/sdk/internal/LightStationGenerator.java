// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.google.b.f;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.GenerateStationEvent;
import com.rdio.android.core.stations.StationGenerator;
import com.rdio.android.core.stations.StationService;
import com.rdio.android.sdk.internal.sequencing.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LightStationGenerator extends StationGenerator
{

    private f gson;

    public LightStationGenerator(StationService stationservice, e e, f f)
    {
        super(stationservice, e);
        gson = f;
    }

    public void handleGenerateStationResponse(GenerateStationEvent generatestationevent, List list, RdioApiResponse rdioapiresponse)
    {
        ArrayList arraylist = new ArrayList();
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        try
        {
            arraylist.add(Utils.createNewModel(gson, rdioapiresponse.getString("key"), rdioapiresponse));
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse)
        {
            rdioapiresponse.printStackTrace();
        }
        processGeneratedStationList(generatestationevent, arraylist, list);
    }
}
