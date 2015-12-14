// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.common.event:
//            EventDetails

public static class 
{

    private final Map eventDetailsMap = new HashMap();

    public  adHeightPx(Integer integer)
    {
        if (integer != null)
        {
            eventDetailsMap.put("ad_height_px_key", String.valueOf(integer));
        }
        return this;
    }

    public eventDetailsMap adNetworkType(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("ad_network_type", s);
        }
        return this;
    }

    public eventDetailsMap adType(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("ad_type", s);
        }
        return this;
    }

    public eventDetailsMap adUnitId(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("ad_unit_id", s);
        }
        return this;
    }

    public eventDetailsMap adWidthPx(Integer integer)
    {
        if (integer != null)
        {
            eventDetailsMap.put("ad_width_px", String.valueOf(integer));
        }
        return this;
    }

    public EventDetails build()
    {
        return new EventDetails(eventDetailsMap, null);
    }

    public eventDetailsMap dspCreativeId(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("dsp_creative_id", s);
        }
        return this;
    }

    public eventDetailsMap geoAccuracy(Float float1)
    {
        if (float1 != null)
        {
            eventDetailsMap.put("geo_accuracy_key", String.valueOf(float1.floatValue()));
        }
        return this;
    }

    public eventDetailsMap geoLatitude(Double double1)
    {
        if (double1 != null)
        {
            eventDetailsMap.put("geo_latitude", String.valueOf(double1));
        }
        return this;
    }

    public eventDetailsMap geoLongitude(Double double1)
    {
        if (double1 != null)
        {
            eventDetailsMap.put("geo_longitude", String.valueOf(double1));
        }
        return this;
    }

    public eventDetailsMap performanceDurationMs(Long long1)
    {
        if (long1 != null)
        {
            eventDetailsMap.put("performance_duration_ms", String.valueOf(long1.longValue()));
        }
        return this;
    }

    public eventDetailsMap requestId(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("request_id_key", s);
        }
        return this;
    }

    public eventDetailsMap requestStatusCode(Integer integer)
    {
        if (integer != null)
        {
            eventDetailsMap.put("request_status_code", String.valueOf(integer));
        }
        return this;
    }

    public eventDetailsMap requestUri(String s)
    {
        if (s != null)
        {
            eventDetailsMap.put("request_uri_key", s);
        }
        return this;
    }

    public ()
    {
    }
}
