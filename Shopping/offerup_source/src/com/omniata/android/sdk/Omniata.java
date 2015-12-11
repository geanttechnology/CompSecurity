// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.omniata.android.sdk:
//            OmniataLog, OmniataUtils, PersistentBlockingQueue, OmniataEventLogger, 
//            OmniataEventWorker, OmniataChannelResponseHandler

public class Omniata
{

    private static final String EVENT_LOG = "events";
    private static final String SDK_VERSION = "android-2.0.1";
    private static final String TAG = "Omniata";
    private static Omniata instance;
    private String apiKey;
    private Context context;
    private BlockingQueue eventBuffer;
    private PersistentBlockingQueue eventLog;
    private OmniataEventLogger eventLogger;
    private OmniataEventWorker eventWorker;
    private String userID;

    private Omniata(Context context1, String s, String s1, String s2)
    {
    }

    private void _initialize(Context context1, String s, String s1, String s2)
    {
        OmniataLog.i("Omniata", (new StringBuilder("Initializing Omniata with apiKey: ")).append(s).append(" and userID: ").append(s1).toString());
        if (context1 == null)
        {
            throw new IllegalArgumentException("Activity is null");
        }
        OmniataUtils.assertApiKeyValid(s);
        OmniataUtils.assertUserIdValid(s1);
        OmniataUtils.setURL(s2);
        apiKey = s;
        userID = s1;
        if (context == null)
        {
            context = context1;
        }
        if (eventBuffer == null)
        {
            eventBuffer = new LinkedBlockingQueue();
        }
        if (eventLog == null)
        {
            eventLog = new PersistentBlockingQueue(context1, "events", org/json/JSONObject);
        }
        if (eventLogger == null)
        {
            eventLogger = new OmniataEventLogger(eventBuffer, eventLog);
        }
        if (eventWorker == null)
        {
            eventWorker = new OmniataEventWorker(context1, eventLog);
        }
        eventLogger.start();
        eventWorker.start();
    }

    private void _setApiKey(String s)
    {
        apiKey = s;
    }

    private void _setUserId(String s)
    {
        userID = s;
    }

    private static void assertInitialized()
    {
        if (instance == null)
        {
            throw new IllegalStateException("Uninitialized SDK");
        } else
        {
            return;
        }
    }

    public static void channel(int i, OmniataChannelResponseHandler omniatachannelresponsehandler)
    {
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorenter ;
        assertInitialized();
        instance._channel(i, omniatachannelresponsehandler);
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        return;
        omniatachannelresponsehandler;
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        throw omniatachannelresponsehandler;
    }

    public static void disablePushNotifications()
    {
        track("om_gcm_disable");
    }

    public static void enablePushNotifications(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("om_registration_id", s);
            track("om_gcm_enable", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            OmniataLog.e("Omniata", s.toString());
        }
    }

    protected static JSONObject getAutomaticParameters()
    {
        JSONObject jsonobject = new JSONObject();
        Locale locale = Locale.getDefault();
        try
        {
            jsonobject.put("om_sdk_version", "android-2.0.1");
            jsonobject.put("om_os_version", android.os.Build.VERSION.SDK_INT);
            jsonobject.put("om_platform", "android");
            jsonobject.put("om_device", Build.MODEL);
            jsonobject.put("om_android_id", "android_id");
            jsonobject.put("om_android_serial", Build.SERIAL);
            jsonobject.put("om_android_device", Build.DEVICE);
            jsonobject.put("om_android_hardware", Build.HARDWARE);
        }
        catch (Throwable throwable)
        {
            return jsonobject;
        }
        if (locale == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        jsonobject.put("om_locale", locale);
        return jsonobject;
    }

    public static void initialize(Context context1, String s, String s1, String s2)
    {
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            OmniataLog.i("Omniata", "Initializing Omniata API");
            instance = new Omniata(context1, s, s1, s2);
        }
        instance._initialize(context1, s, s1, s2);
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        return;
        context1;
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public static void setApiKey(String s)
    {
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorenter ;
        assertInitialized();
        OmniataUtils.assertApiKeyValid(s);
        instance._setApiKey(s);
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        return;
        s;
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setLogLevel(int i)
    {
        OmniataLog.setPriority(i);
    }

    public static void setUserId(String s)
    {
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorenter ;
        assertInitialized();
        OmniataUtils.assertUserIdValid(s);
        instance._setUserId(s);
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        return;
        s;
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void track(String s)
    {
        track(s, null);
    }

    public static void track(String s, JSONObject jsonobject)
    {
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorenter ;
        assertInitialized();
        instance._track(s, jsonobject);
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        return;
        s;
        com/omniata/android/sdk/Omniata;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void trackLoad()
    {
        trackLoad(null);
    }

    public static void trackLoad(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        track("om_load", OmniataUtils.mergeJSON(getAutomaticParameters(), jsonobject1));
    }

    public static void trackRevenue(double d, String s)
    {
        trackRevenue(d, s, null);
    }

    public static void trackRevenue(double d, String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        jsonobject1 = new JSONObject();
        String s1;
        try
        {
            jsonobject1.put("total", d);
            jsonobject1.put("currency_code", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            OmniataLog.e("Omniata", s.toString());
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        for (s = jsonobject.keys(); s.hasNext(); jsonobject1.put(s1, jsonobject.get(s1)))
        {
            s1 = (String)s.next();
        }

        track("om_revenue", jsonobject1);
        return;
    }

    private static JSONObject unityJsonGenerator(String s)
    {
        int i = 0;
        JSONObject jsonobject = new JSONObject();
        s = s.split("\n");
        while (i < s.length) 
        {
            String as[] = s[i].split("=");
            try
            {
                jsonobject.put(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
            }
            catch (Exception exception)
            {
                OmniataLog.e("Omniata", exception.toString());
            }
            i++;
        }
        return jsonobject;
    }

    public static void unityTrack(String s, String s1)
    {
        instance._track(s, unityJsonGenerator(s1));
    }

    public static void unityTrackLoad(String s)
    {
        trackLoad(unityJsonGenerator(s));
    }

    public static void unity_log(String s)
    {
        Log.i("Omniata", s);
    }

    protected void _channel(final int channelId, final OmniataChannelResponseHandler handler)
    {
        (new Thread(new _cls1())).start();
    }

    protected void _track(String s, JSONObject jsonobject)
    {
        OmniataUtils.assertValidEventType(s);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        jsonobject = new JSONObject(jsonobject.toString());
_L1:
        jsonobject.put("om_event_type", s);
        jsonobject.put("api_key", apiKey);
        jsonobject.put("uid", userID);
        jsonobject.put("om_creation_time", System.currentTimeMillis());
        do
        {
            try
            {
                eventBuffer.put(jsonobject);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        } while (true);
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            OmniataLog.e("Omniata", s.toString());
            return;
        }
          goto _L1
    }



    private class _cls1
        implements Runnable
    {

        final Omniata this$0;
        final int val$channelId;
        final OmniataChannelResponseHandler val$handler;

        public void run()
        {
            Object obj = (new StringBuilder()).append(OmniataUtils.getChannelAPI(true)).append("?api_key=").append(apiKey).append("&uid=").append(userID).append("&channel_id=").append(channelId).toString();
            int i;
            obj = (HttpURLConnection)(new URL(((String) (obj)))).openConnection();
            i = ((HttpURLConnection) (obj)).getResponseCode();
            if (i >= 200 && i < 300)
            {
                try
                {
                    obj = (new JSONObject(OmniataUtils.convertStreamToString(((HttpURLConnection) (obj)).getInputStream()))).getJSONArray("content");
                    handler.onSuccess(channelId, ((JSONArray) (obj)));
                    Log.i("Omniata", ((JSONArray) (obj)).toString());
                    return;
                }
                catch (Exception exception)
                {
                    try
                    {
                        handler.onError(channelId, exception);
                        return;
                    }
                    catch (Exception exception1)
                    {
                        handler.onError(channelId, exception1);
                    }
                }
                return;
            }
            handler.onError(channelId, new Exception((new StringBuilder("Error: Invalid http response code: ")).append(i).toString()));
            return;
        }

        _cls1()
        {
            this$0 = Omniata.this;
            channelId = i;
            handler = omniatachannelresponsehandler;
            super();
        }
    }

}
