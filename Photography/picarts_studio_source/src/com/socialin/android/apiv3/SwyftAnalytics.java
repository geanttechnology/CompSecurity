// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.os.Build;
import android.text.TextUtils;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.parsers.StringParser;
import com.socialin.android.d;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3

public class SwyftAnalytics
{

    private static final String LOG_TAG = "swyft_analytics";
    private static SwyftAnalytics sInstance = null;
    public static String serverTestUrl = "https://sasandbox.swyftmedia.com";
    public static String serverUrl = "https://analytics.swyftmedia.com";
    public static String token = "f734ea463484158ae717d6d3";
    public static String tokenTest = "c3be55639ca5eeadf484bded";
    private HashMap events;
    private boolean isTestMode;

    private SwyftAnalytics()
    {
        isTestMode = false;
        events = new HashMap();
        events.put("shop_open", "viewStore");
        events.put("shop_package_open", "viewPack");
        events.put("shop_package_purchase", "downloadPack");
        events.put("shop_package_use", "useAsset");
    }

    private String getDefaultClient()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("OSName", "android");
            ((JSONObject) (obj)).put("deviceModel", Build.MODEL);
            ((JSONObject) (obj)).put("OSVersion", (new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).append(".").append(android.os.Build.VERSION.RELEASE).toString());
            obj = ((JSONObject) (obj)).toString().replace("\"", "'");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return null;
        }
        return ((String) (obj));
    }

    public static SwyftAnalytics getInstance()
    {
        com/socialin/android/apiv3/SwyftAnalytics;
        JVM INSTR monitorenter ;
        SwyftAnalytics swyftanalytics;
        if (sInstance == null)
        {
            sInstance = new SwyftAnalytics();
        }
        swyftanalytics = sInstance;
        com/socialin/android/apiv3/SwyftAnalytics;
        JVM INSTR monitorexit ;
        return swyftanalytics;
        Exception exception;
        exception;
        throw exception;
    }

    private String getLocalTime()
    {
        Object obj;
        try
        {
            obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("UTC"));
            obj = ((SimpleDateFormat) (obj)).format(new Date());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return ((String) (obj));
    }

    private void logEvent(String s, HashMap hashmap)
    {
        Object obj;
        if (TextUtils.isEmpty(s))
        {
            d.c(new Object[] {
                "swyft_analytics", "logEvent - eventName is NULL!"
            });
            return;
        }
        if (events.containsKey(s))
        {
            s = (String)events.get(s);
        }
        String s1;
        Object obj1;
        String s2;
        if (isTestMode)
        {
            obj = tokenTest;
        } else
        {
            obj = token;
        }
        obj1 = new StringBuilder();
        if (isTestMode)
        {
            s1 = serverTestUrl;
        } else
        {
            s1 = serverUrl;
        }
        s = ((StringBuilder) (obj1)).append(s1).append("/v2/events/").append(s).toString();
        d.a("swyft_analytics", s);
        d.a("swyft_analytics", (new StringBuilder("params= ")).append(hashmap.toString()).toString());
        s = new Request(s, StringParser.instance(), "POST");
        s.c("Content-Type", "application/json");
        s.c("Authorization", ((String) (obj)));
        s.c("Authentication", ((String) (obj)));
        obj = new JSONObject();
        s2 = String.valueOf(hashmap.get("client"));
        obj1 = String.valueOf(hashmap.get("serials"));
        s1 = String.valueOf(hashmap.get("price"));
        hashmap = String.valueOf(hashmap.get("currency"));
        ((JSONObject) (obj)).put("appName", "picsart");
        if (TextUtils.isEmpty(s2) || "null".equals(s2)) goto _L2; else goto _L1
_L1:
        ((JSONObject) (obj)).put("client", s2);
_L3:
        if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !"null".equals(obj1))
        {
            ((JSONObject) (obj)).put("serials", ((String) (obj1)).replace("\"", "'"));
        }
        if (!TextUtils.isEmpty(s1) && !"null".equals(s1))
        {
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("price", s1);
            if (!TextUtils.isEmpty(hashmap) && !"null".equals(hashmap))
            {
                ((JSONObject) (obj1)).put("currency", toISO4217CurrencyCode(hashmap));
            }
            ((JSONObject) (obj)).put("meta", ((JSONObject) (obj1)).toString().replace("\"", "'"));
        }
        ((JSONObject) (obj)).put("eventTime", getLocalTime());
        ((JSONObject) (obj)).put("userId", String.valueOf(SocialinV3.getInstance().getUser().id));
        d.a("swyft_analytics", (new StringBuilder("data= ")).append(((JSONObject) (obj)).toString()).toString());
        s.a(((JSONObject) (obj)).toString());
_L4:
        b.a().a(s, new com.socialin.asyncnet.d() {

            public final void onCancelRequest(Object obj2, Request request)
            {
                d.b("swyft_analytics", new Object[] {
                    "logEvent - onCancelRequest"
                });
            }

            public final void onFailure(Exception exception, Request request)
            {
                d.b("swyft_analytics", new Object[] {
                    (new StringBuilder("logEvent - onFailure! \n")).append(exception.getLocalizedMessage()).toString()
                });
                exception.printStackTrace();
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj2, Request request)
            {
                obj2 = (String)obj2;
                d.b("swyft_analytics", new Object[] {
                    (new StringBuilder("logEvent - onSuccess! \n")).append(((String) (obj2))).toString()
                });
            }

        });
        return;
_L2:
        String s3 = getDefaultClient();
        if (!TextUtils.isEmpty(s3) && !"null".equals(s3))
        {
            ((JSONObject) (obj)).put("client", s3);
        }
          goto _L3
        hashmap;
        hashmap.printStackTrace();
          goto _L4
    }

    private void setLocation(JSONObject jsonobject, Adress adress)
    {
        if (adress == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (!TextUtils.isEmpty(adress.city) && !TextUtils.isEmpty(adress.city))
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("city", adress.city);
            jsonobject1.put("state", adress.state);
            jsonobject.put("geolocation", jsonobject1.toString());
        }
        if (adress.coordinates != null && adress.coordinates.length > 1)
        {
            JSONObject jsonobject2 = new JSONObject();
            jsonobject2.put("lat", adress.coordinates[0]);
            jsonobject2.put("lng", adress.coordinates[1]);
            jsonobject.put("location", jsonobject2.toString());
        }
        return;
        jsonobject;
        d.a("swyft_analytics", "setLocation", jsonobject);
        return;
    }

    private String toISO4217CurrencyCode(String s)
    {
        if (!"$".equals(s)) goto _L2; else goto _L1
_L1:
        String s1 = "USD";
_L4:
        return s1;
_L2:
        if ("\u20AC".equals(s))
        {
            return "EUR";
        }
        if (":".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        if (!"\243".equals(s)) goto _L4; else goto _L3
_L3:
        return "GBP";
    }

    public TrackEvent createTrackEvent(String s)
    {
        return new TrackEvent(s);
    }



    private class TrackEvent
    {

        private final String id;
        private final HashMap params;
        final SwyftAnalytics this$0;

        public TrackEvent addParam(String s, Object obj)
        {
            if (obj != null)
            {
                params.put(s, obj);
            }
            return this;
        }

        public TrackEvent addParam(String s, String s1)
        {
            if (!TextUtils.isEmpty(s1))
            {
                params.put(s, s1);
            }
            return this;
        }

        public void track()
        {
            logEvent(id, params);
        }

        private TrackEvent(String s)
        {
            this$0 = SwyftAnalytics.this;
            super();
            id = s;
            params = new HashMap();
        }

    }

}
