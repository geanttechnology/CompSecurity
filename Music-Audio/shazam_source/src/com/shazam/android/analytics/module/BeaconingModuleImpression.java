// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.module;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.i.e.a;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.module.ModuleCommonData;
import com.shazam.model.module.ModuleDimension;
import com.shazam.n.h;
import com.shazam.n.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.analytics.module:
//            ModuleImpression

public class BeaconingModuleImpression
    implements ModuleImpression
{

    private final EventAnalytics eventAnalytics;
    private final i stopWatchFactory;
    private final Map stopWatches = a.a(0);

    public BeaconingModuleImpression(EventAnalytics eventanalytics, i j)
    {
        eventAnalytics = eventanalytics;
        stopWatchFactory = j;
    }

    public void onImpressionFinished(ModuleCommonData modulecommondata, Map map)
    {
        onImpressionPaused();
        Iterator iterator = stopWatches.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            h h1 = (h)entry.getValue();
            if (h1.b)
            {
                EventAnalytics eventanalytics = eventAnalytics;
                com.shazam.android.analytics.event.Event.Builder builder = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION);
                com.shazam.android.analytics.event.EventParameters.Builder builder1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters();
                Object obj;
                if (map != null)
                {
                    obj = map;
                } else
                {
                    obj = new android.support.v4.f.a();
                }
                eventanalytics.logEvent(builder.withParameters(builder1.withNotEmptyOrNullParameters(((Map) (obj))).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER_NAME, (String)entry.getKey()).putNotEmptyOrNullParameter(DefinedEventParameterKey.MODULE_SIZE, modulecommondata.dimension.getStringRepresentation()).putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, String.valueOf(h1.a)).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "details").putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_ID, modulecommondata.trackId).build()).build());
            }
        } while (true);
        stopWatches.clear();
    }

    public void onImpressionPaused()
    {
        for (Iterator iterator = stopWatches.entrySet().iterator(); iterator.hasNext(); ((h)((java.util.Map.Entry)iterator.next()).getValue()).b()) { }
    }

    public void onImpressionStarted(String s)
    {
        if (s != null)
        {
            if (stopWatches.containsKey(s))
            {
                s = (h)stopWatches.get(s);
            } else
            {
                h h1 = stopWatchFactory.a();
                stopWatches.put(s, h1);
                s = h1;
            }
            s.a();
        }
    }
}
