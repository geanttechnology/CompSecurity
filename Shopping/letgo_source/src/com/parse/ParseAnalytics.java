// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
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

    public static cu trackAppOpenedInBackground(Intent intent)
    {
        Object obj;
        cs cs1;
        obj = getPushHashFromIntent(intent);
        cs1 = new cs();
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
                    obj = cu.a(null);
                }
                return ((cu) (obj));
            }
        }
          goto _L1
        lruSeenPushes.put(obj, Boolean.valueOf(true));
        cs1.a(obj);
        intent;
        JVM INSTR monitorexit ;
_L1:
        return ParseUser.getCurrentSessionTokenAsync().d(new ct(cs1) {

            final cs val$pushHash;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return ParseAnalytics.getAnalyticsController().trackAppOpenedInBackground((String)pushHash.a(), cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                pushHash = cs1;
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

    public static cu trackEventInBackground(String s)
    {
        return trackEventInBackground(s, (Map)null);
    }

    public static cu trackEventInBackground(String s, Map map)
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
        return ParseUser.getCurrentSessionTokenAsync().d(new ct(s, map) {

            final JSONObject val$jsonDimensions;
            final String val$name;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (String)cu1.e();
                return ParseAnalytics.getAnalyticsController().trackEventInBackground(name, jsonDimensions, cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
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
