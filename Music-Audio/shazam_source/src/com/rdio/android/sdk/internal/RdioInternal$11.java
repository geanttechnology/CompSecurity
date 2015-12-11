// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.LoadModelsEvent;
import com.rdio.android.core.events.ModelLoaderErrorEvent;
import com.rdio.android.core.events.ModelsLoadedEvent;
import com.rdio.android.sdk.internal.sequencing.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal

class val.event
    implements com.rdio.android.core.ResponseListener
{

    final RdioInternal this$0;
    final LoadModelsEvent val$event;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (!rdioapiresponse.isSuccess())
        {
            rdioapiresponse = new ModelLoaderErrorEvent("onLoadModels: Response unsuccessful.", val$event, val$event.getRequester(), val$event.getEventId());
            RdioInternal.access$1200(RdioInternal.this).post(rdioapiresponse);
            return;
        }
        ArrayList arraylist = new ArrayList();
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        for (Iterator iterator = rdioapiresponse.keys(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                arraylist.add(Utils.createNewModel(getGson(), s, rdioapiresponse.getJSONObject(s)));
            }
            catch (JSONException jsonexception)
            {
                ModelLoaderErrorEvent modelloadererrorevent = new ModelLoaderErrorEvent("onLoadModels: Error parsing JSON", val$event, val$event.getRequester(), val$event.getEventId());
                RdioInternal.access$1200(RdioInternal.this).post(modelloadererrorevent);
            }
        }

        rdioapiresponse = new ModelsLoadedEvent(arraylist, val$event.getKeys(), arraylist.size(), false, false, val$event.getRequester(), val$event.getEventId());
        RdioInternal.access$1200(RdioInternal.this).post(rdioapiresponse);
    }

    ()
    {
        this$0 = final_rdiointernal;
        val$event = LoadModelsEvent.this;
        super();
    }
}
