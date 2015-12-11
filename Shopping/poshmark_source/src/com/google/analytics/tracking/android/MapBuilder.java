// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            GAUsage, Log, Utils

public class MapBuilder
{

    private Map map;

    public MapBuilder()
    {
        map = new HashMap();
    }

    static String booleanToString(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return null;
        }
        if (boolean1.booleanValue())
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public static MapBuilder createAppView()
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_APP_VIEW);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "appview");
        return mapbuilder;
    }

    public static MapBuilder createEvent(String s, String s1, String s2, Long long1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "event");
        mapbuilder.set("&ec", s);
        mapbuilder.set("&ea", s1);
        mapbuilder.set("&el", s2);
        if (long1 == null)
        {
            s = null;
        } else
        {
            s = Long.toString(long1.longValue());
        }
        mapbuilder.set("&ev", s);
        return mapbuilder;
    }

    public static MapBuilder createException(String s, Boolean boolean1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "exception");
        mapbuilder.set("&exd", s);
        mapbuilder.set("&exf", booleanToString(boolean1));
        return mapbuilder;
    }

    public static MapBuilder createItem(String s, String s1, String s2, String s3, Double double1, Long long1, String s4)
    {
        Object obj = null;
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "item");
        mapbuilder.set("&ti", s);
        mapbuilder.set("&ic", s2);
        mapbuilder.set("&in", s1);
        mapbuilder.set("&iv", s3);
        if (double1 == null)
        {
            s = null;
        } else
        {
            s = Double.toString(double1.doubleValue());
        }
        mapbuilder.set("&ip", s);
        if (long1 == null)
        {
            s = obj;
        } else
        {
            s = Long.toString(long1.longValue());
        }
        mapbuilder.set("&iq", s);
        mapbuilder.set("&cu", s4);
        return mapbuilder;
    }

    public static MapBuilder createSocial(String s, String s1, String s2)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "social");
        mapbuilder.set("&sn", s);
        mapbuilder.set("&sa", s1);
        mapbuilder.set("&st", s2);
        return mapbuilder;
    }

    public static MapBuilder createTiming(String s, Long long1, String s1, String s2)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "timing");
        mapbuilder.set("&utc", s);
        s = null;
        if (long1 != null)
        {
            s = Long.toString(long1.longValue());
        }
        mapbuilder.set("&utt", s);
        mapbuilder.set("&utv", s1);
        mapbuilder.set("&utl", s2);
        return mapbuilder;
    }

    public static MapBuilder createTransaction(String s, String s1, Double double1, Double double2, Double double3, String s2)
    {
        Object obj = null;
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
        MapBuilder mapbuilder = new MapBuilder();
        mapbuilder.set("&t", "transaction");
        mapbuilder.set("&ti", s);
        mapbuilder.set("&ta", s1);
        if (double1 == null)
        {
            s = null;
        } else
        {
            s = Double.toString(double1.doubleValue());
        }
        mapbuilder.set("&tr", s);
        if (double2 == null)
        {
            s = null;
        } else
        {
            s = Double.toString(double2.doubleValue());
        }
        mapbuilder.set("&tt", s);
        if (double3 == null)
        {
            s = obj;
        } else
        {
            s = Double.toString(double3.doubleValue());
        }
        mapbuilder.set("&ts", s);
        mapbuilder.set("&cu", s2);
        return mapbuilder;
    }

    public Map build()
    {
        return new HashMap(map);
    }

    public String get(String s)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_GET);
        return (String)map.get(s);
    }

    public MapBuilder set(String s, String s1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET);
        if (s != null)
        {
            map.put(s, s1);
            return this;
        } else
        {
            Log.w(" MapBuilder.set() called with a null paramName.");
            return this;
        }
    }

    public MapBuilder setAll(Map map1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_ALL);
        if (map1 == null)
        {
            return this;
        } else
        {
            map.putAll(new HashMap(map1));
            return this;
        }
    }

    public MapBuilder setCampaignParamsFromUrl(String s)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        s = Utils.filterCampaign(s);
        if (TextUtils.isEmpty(s))
        {
            return this;
        } else
        {
            s = Utils.parseURLParameters(s);
            set("&cc", (String)s.get("utm_content"));
            set("&cm", (String)s.get("utm_medium"));
            set("&cn", (String)s.get("utm_campaign"));
            set("&cs", (String)s.get("utm_source"));
            set("&ck", (String)s.get("utm_term"));
            set("&ci", (String)s.get("utm_id"));
            set("&gclid", (String)s.get("gclid"));
            set("&dclid", (String)s.get("dclid"));
            set("&gmob_t", (String)s.get("gmob_t"));
            return this;
        }
    }
}
