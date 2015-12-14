// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.Preconditions;
import com.mopub.common.util.Json;
import java.util.HashMap;
import java.util.Map;

public class EventDetails
{
    public static class Builder
    {

        private final Map eventDetailsMap = new HashMap();

        public Builder adHeightPx(Integer integer)
        {
            if (integer != null)
            {
                eventDetailsMap.put("ad_height_px_key", String.valueOf(integer));
            }
            return this;
        }

        public Builder adNetworkType(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("ad_network_type", s);
            }
            return this;
        }

        public Builder adType(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("ad_type", s);
            }
            return this;
        }

        public Builder adUnitId(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("ad_unit_id", s);
            }
            return this;
        }

        public Builder adWidthPx(Integer integer)
        {
            if (integer != null)
            {
                eventDetailsMap.put("ad_width_px", String.valueOf(integer));
            }
            return this;
        }

        public EventDetails build()
        {
            return new EventDetails(eventDetailsMap);
        }

        public Builder dspCreativeId(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("dsp_creative_id", s);
            }
            return this;
        }

        public Builder geoAccuracy(Float float1)
        {
            if (float1 != null)
            {
                eventDetailsMap.put("geo_accuracy_key", String.valueOf(float1.floatValue()));
            }
            return this;
        }

        public Builder geoLatitude(Double double1)
        {
            if (double1 != null)
            {
                eventDetailsMap.put("geo_latitude", String.valueOf(double1));
            }
            return this;
        }

        public Builder geoLongitude(Double double1)
        {
            if (double1 != null)
            {
                eventDetailsMap.put("geo_longitude", String.valueOf(double1));
            }
            return this;
        }

        public Builder performanceDurationMs(Long long1)
        {
            if (long1 != null)
            {
                eventDetailsMap.put("performance_duration_ms", String.valueOf(long1.longValue()));
            }
            return this;
        }

        public Builder requestId(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("request_id_key", s);
            }
            return this;
        }

        public Builder requestStatusCode(Integer integer)
        {
            if (integer != null)
            {
                eventDetailsMap.put("request_status_code", String.valueOf(integer));
            }
            return this;
        }

        public Builder requestUri(String s)
        {
            if (s != null)
            {
                eventDetailsMap.put("request_uri_key", s);
            }
            return this;
        }

        public Builder()
        {
        }
    }


    private static final String AD_HEIGHT_PX_KEY = "ad_height_px_key";
    private static final String AD_NETWORK_TYPE_KEY = "ad_network_type";
    private static final String AD_TYPE_KEY = "ad_type";
    private static final String AD_UNIT_ID_KEY = "ad_unit_id";
    private static final String AD_WIDTH_PX_KEY = "ad_width_px";
    private static final String DSP_CREATIVE_ID_KEY = "dsp_creative_id";
    private static final String GEO_ACCURACY_KEY = "geo_accuracy_key";
    private static final String GEO_LATITUDE_KEY = "geo_latitude";
    private static final String GEO_LONGITUDE_KEY = "geo_longitude";
    private static final String PERFORMANCE_DURATION_MS_KEY = "performance_duration_ms";
    private static final String REQUEST_ID_KEY = "request_id_key";
    private static final String REQUEST_STATUS_CODE_KEY = "request_status_code";
    private static final String REQUEST_URI_KEY = "request_uri_key";
    private final Map mEventDetailsMap;

    private EventDetails(Map map)
    {
        Preconditions.checkNotNull(map);
        mEventDetailsMap = map;
    }


    private static Double getNullableDoubleValue(Map map, String s)
    {
        map = (String)map.get(s);
        if (map == null)
        {
            return null;
        }
        double d;
        try
        {
            d = Double.parseDouble(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return Double.valueOf(d);
    }

    private static Integer getNullableIntegerValue(Map map, String s)
    {
        map = (String)map.get(s);
        if (map == null)
        {
            return null;
        }
        int i;
        try
        {
            i = Integer.parseInt(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return Integer.valueOf(i);
    }

    public Double getAdHeightPx()
    {
        return getNullableDoubleValue(mEventDetailsMap, "ad_height_px_key");
    }

    public String getAdNetworkType()
    {
        return (String)mEventDetailsMap.get("ad_network_type");
    }

    public String getAdType()
    {
        return (String)mEventDetailsMap.get("ad_type");
    }

    public String getAdUnitId()
    {
        return (String)mEventDetailsMap.get("ad_unit_id");
    }

    public Double getAdWidthPx()
    {
        return getNullableDoubleValue(mEventDetailsMap, "ad_width_px");
    }

    public String getDspCreativeId()
    {
        return (String)mEventDetailsMap.get("dsp_creative_id");
    }

    public Double getGeoAccuracy()
    {
        return getNullableDoubleValue(mEventDetailsMap, "geo_accuracy_key");
    }

    public Double getGeoLatitude()
    {
        return getNullableDoubleValue(mEventDetailsMap, "geo_latitude");
    }

    public Double getGeoLongitude()
    {
        return getNullableDoubleValue(mEventDetailsMap, "geo_longitude");
    }

    public Double getPerformanceDurationMs()
    {
        return getNullableDoubleValue(mEventDetailsMap, "performance_duration_ms");
    }

    public String getRequestId()
    {
        return (String)mEventDetailsMap.get("request_id_key");
    }

    public Integer getRequestStatusCode()
    {
        return getNullableIntegerValue(mEventDetailsMap, "request_status_code");
    }

    public String getRequestUri()
    {
        return (String)mEventDetailsMap.get("request_uri_key");
    }

    public String toJsonString()
    {
        return Json.mapToJsonString(mEventDetailsMap);
    }

    public String toString()
    {
        return toJsonString();
    }
}
