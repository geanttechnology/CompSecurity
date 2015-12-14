// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;
import android.os.Bundle;
import bolts.Task;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseCommand, ParseUser, Parse, ParseEventuallyQueue, 
//            NoObjectsEncodingStrategy, SaveCallback

public class ParseAnalytics
{

    private static final String APP_OPENED = "AppOpened";
    private static final String OP = "client_events";
    private static final String TAG = "com.parse.ParseAnalytics";
    static Map lruSeenPushes = new LinkedHashMap() {

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > 10;
        }

    };

    public ParseAnalytics()
    {
    }

    static ParseCommand createCommand(String s)
    {
        ParseCommand parsecommand = new ParseCommand("client_events", ParseUser.getCurrentSessionToken());
        parsecommand.put("at", Parse.encodeDate(new Date()));
        parsecommand.put("name", s);
        return parsecommand;
    }

    public static void trackAppOpened(Intent intent)
    {
        trackAppOpenedInBackground(intent);
    }

    public static Task trackAppOpenedInBackground(Intent intent)
    {
        String s;
        Object obj = null;
        s = obj;
        if (intent != null)
        {
            s = obj;
            if (intent.getExtras() != null)
            {
                s = intent.getExtras().getString("com.parse.Data");
            }
        }
        intent = createCommand("AppOpened");
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj1 = (new JSONObject(s)).optString("push_hash");
        if (((String) (obj1)).length() > 0)
        {
label0:
            {
                synchronized (lruSeenPushes)
                {
                    if (!lruSeenPushes.containsKey(obj1))
                    {
                        break label0;
                    }
                    obj1 = Task.forResult(null);
                }
                return ((Task) (obj1));
            }
        }
          goto _L2
        lruSeenPushes.put(obj1, Boolean.valueOf(true));
        intent.put("push_hash", ((String) (obj1)));
        map;
        JVM INSTR monitorexit ;
_L2:
        return Parse.getEventuallyQueue().enqueueEventuallyAsync(intent, null).makeVoid();
        exception;
        map;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (JSONException jsonexception)
        {
            Parse.logE("com.parse.ParseAnalytics", (new StringBuilder()).append("Failed to parse push data: ").append(jsonexception.getMessage()).toString());
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

    public static void trackAppOpenedInBackground(Intent intent, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(trackAppOpenedInBackground(intent), savecallback);
    }

    public static void trackEvent(String s)
    {
        trackEventInBackground(s);
    }

    public static void trackEvent(String s, Map map)
    {
        trackEventInBackground(s, map);
    }

    public static Task trackEventInBackground(String s)
    {
        return trackEventInBackground(s, (Map)null);
    }

    public static Task trackEventInBackground(String s, Map map)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new RuntimeException("A name for the custom event must be provided.");
        }
        s = createCommand(s);
        if (map != null)
        {
            s.put("dimensions", (JSONObject)Parse.encode(map, NoObjectsEncodingStrategy.get()));
        }
        return Parse.getEventuallyQueue().enqueueEventuallyAsync(s, null).makeVoid();
    }

    public static void trackEventInBackground(String s, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(trackEventInBackground(s), savecallback);
    }

    public static void trackEventInBackground(String s, Map map, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(trackEventInBackground(s, map), savecallback);
    }

}
