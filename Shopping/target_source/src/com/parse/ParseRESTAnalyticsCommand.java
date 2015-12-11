// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.Uri;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand, NoObjectsEncoder

class ParseRESTAnalyticsCommand extends ParseRESTCommand
{

    static final String EVENT_APP_OPENED = "AppOpened";

    public ParseRESTAnalyticsCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static ParseRESTAnalyticsCommand trackAppOpenedCommand(String s, String s1)
    {
        HashMap hashmap = null;
        if (s != null)
        {
            hashmap = new HashMap();
            hashmap.put("push_hash", s);
        }
        return trackEventCommand("AppOpened", hashmap, s1);
    }

    static ParseRESTAnalyticsCommand trackEventCommand(String s, Map map, String s1)
    {
        s = String.format("events/%s", new Object[] {
            Uri.encode(s)
        });
        HashMap hashmap = new HashMap();
        if (map != null)
        {
            hashmap.putAll(map);
        }
        hashmap.put("at", NoObjectsEncoder.get().encode(new Date()));
        return new ParseRESTAnalyticsCommand(s, com.parse.http.ParseHttpRequest.Method.POST, hashmap, s1);
    }

    public static ParseRESTAnalyticsCommand trackEventCommand(String s, JSONObject jsonobject, String s1)
    {
        HashMap hashmap = null;
        if (jsonobject != null)
        {
            hashmap = new HashMap();
            hashmap.put("dimensions", jsonobject);
        }
        return trackEventCommand(s, ((Map) (hashmap)), s1);
    }
}
