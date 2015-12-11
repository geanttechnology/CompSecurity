// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import android.content.Intent;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseCorePlugins, PLog, ParseUser, ParseTaskUtils, 
//            NoObjectsEncoder, ParseAnalyticsController, SaveCallback

public class ParseAnalytics
{

    private static final String TAG = "com.parse.ParseAnalytics";
    private static final Map lruSeenPushes = new LinkedHashMap() {

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > 10;
        }

    };

    public ParseAnalytics()
    {
    }

    static void clear()
    {
        synchronized (lruSeenPushes)
        {
            lruSeenPushes.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static ParseAnalyticsController getAnalyticsController()
    {
        return ParseCorePlugins.getInstance().getAnalyticsController();
    }

    static String getPushHashFromIntent(Intent intent)
    {
        if (intent != null && intent.getExtras() != null)
        {
            intent = intent.getExtras().getString("com.parse.Data");
        } else
        {
            intent = null;
        }
        if (intent == null)
        {
            return null;
        }
        try
        {
            intent = JSONObjectInstrumentation.init(intent).optString("push_hash");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            PLog.e("com.parse.ParseAnalytics", (new StringBuilder()).append("Failed to parse push data: ").append(intent.getMessage()).toString());
            return null;
        }
        return intent;
    }

    public static void trackAppOpened(Intent intent)
    {
        trackAppOpenedInBackground(intent);
    }

    public static j trackAppOpenedInBackground(Intent intent)
    {
        Object obj;
        h h1;
        obj = getPushHashFromIntent(intent);
        h1 = new h();
        if (obj != null && ((String) (obj)).length() > 0)
        {
label0:
            {
                synchronized (lruSeenPushes)
                {
                    if (!lruSeenPushes.containsKey(obj))
                    {
                        break label0;
                    }
                    obj = j.a(null);
                }
                return ((j) (obj));
            }
        }
          goto _L1
        lruSeenPushes.put(obj, Boolean.valueOf(true));
        h1.a(obj);
        intent;
        JVM INSTR monitorexit ;
_L1:
        return ParseUser.getCurrentSessionTokenAsync().d(new i(h1) {

            final h val$pushHash;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String)pushHash.a(), j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                pushHash = h1;
                super();
            }
        });
        exception;
        intent;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void trackAppOpenedInBackground(Intent intent, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(trackAppOpenedInBackground(intent), savecallback);
    }

    public static void trackEvent(String s)
    {
        trackEventInBackground(s);
    }

    public static void trackEvent(String s, Map map)
    {
        trackEventInBackground(s, map);
    }

    public static j trackEventInBackground(String s)
    {
        return trackEventInBackground(s, (Map)null);
    }

    public static j trackEventInBackground(String s, Map map)
    {
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("A name for the custom event must be provided.");
        }
        if (map != null)
        {
            map = (JSONObject)NoObjectsEncoder.get().encode(map);
        } else
        {
            map = null;
        }
        return ParseUser.getCurrentSessionTokenAsync().d(new i(s, map) {

            final JSONObject val$jsonDimensions;
            final String val$name;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                return ParseAnalytics.getAnalyticsController().trackEventInBackground(name, jsonDimensions, j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                name = s;
                jsonDimensions = jsonobject;
                super();
            }
        });
    }

    public static void trackEventInBackground(String s, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(s), savecallback);
    }

    public static void trackEventInBackground(String s, Map map, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(trackEventInBackground(s, map), savecallback);
    }

}
