// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            ai, am, aj, al, 
//            ao, an, v

final class l extends ai
{

    l()
    {
    }

    private static aj a()
    {
        if (am.l == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("lat", Double.toString(am.l.getLatitude()));
        jsonobject.put("long", Double.toString(am.l.getLongitude()));
        if (am.l.hasAccuracy())
        {
            jsonobject.put("ha", Float.toString(am.l.getAccuracy()));
            jsonobject.put("va", Float.toString(am.l.getAccuracy()));
        }
        if (am.l.hasSpeed())
        {
            jsonobject.put("spd", Float.toString(am.l.getSpeed()));
        }
        if (am.l.hasBearing())
        {
            jsonobject.put("brg", Float.toString(am.l.getBearing()));
        }
        if (am.l.hasAltitude())
        {
            jsonobject.put("alt", Double.toString(am.l.getAltitude()));
        }
        jsonobject.put("tslr", Long.toString(am.l.getTime()));
_L3:
        aj aj1 = new aj();
        aj1.c = 1;
        aj1.d = jsonobject;
        return aj1;
        JSONException jsonexception;
        jsonexception;
        jsonobject = null;
_L4:
        al.a("BridgeMMDevice", "Bridge getLocation json exception: ", jsonexception);
        if (true) goto _L3; else goto _L2
_L2:
        return aj.b("location object has not been set");
        jsonexception;
          goto _L4
    }

    private aj a(Map map)
    {
        (new StringBuilder("hardware accel call")).append(map);
        al.b();
        map = (String)map.get("enabled");
        ao ao1 = (ao)c.get();
        if (ao1 != null && ao1 != null)
        {
            if (Boolean.parseBoolean(map))
            {
                ao1.c();
            } else
            {
                ao1.a();
            }
            return aj.a("Success.");
        } else
        {
            return null;
        }
    }

    static JSONObject a(Context context)
    {
        Object obj = new JSONObject();
        ((JSONObject) (obj)).put("sdkVersion", "5.4.0-c325424f.a");
        ((JSONObject) (obj)).put("connection", an.b(context));
        ((JSONObject) (obj)).put("platform", "Android");
        if (android.os.Build.VERSION.RELEASE != null)
        {
            ((JSONObject) (obj)).put("version", android.os.Build.VERSION.RELEASE);
        }
        if (Build.MODEL != null)
        {
            ((JSONObject) (obj)).put("device", Build.MODEL);
        }
        ((JSONObject) (obj)).put("mmdid", an.c(context));
        context = context.getResources().getDisplayMetrics();
        ((JSONObject) (obj)).put("density", new Float(((DisplayMetrics) (context)).density));
        ((JSONObject) (obj)).put("height", new Integer(((DisplayMetrics) (context)).heightPixels));
        ((JSONObject) (obj)).put("width", new Integer(((DisplayMetrics) (context)).widthPixels));
        context = Locale.getDefault();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        ((JSONObject) (obj)).put("language", context.getLanguage());
        ((JSONObject) (obj)).put("country", context.getCountry());
        context = new JSONObject();
        context.put("name", "MAC-ID");
        context.put("path", "/");
        context.put("value", an.e);
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(context);
        ((JSONObject) (obj)).put("cookies", jsonarray);
        return ((JSONObject) (obj));
        obj;
        context = null;
_L2:
        al.a("BridgeMMDevice", "Bridge getting deviceInfo json exception: ", ((Throwable) (obj)));
        return context;
        JSONException jsonexception;
        jsonexception;
        context = ((Context) (obj));
        obj = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    final aj a(String s, Map map)
    {
        Object obj1 = null;
        if (!"call".equals(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (Context)b.get();
        s = (String)map.get("number");
        if (obj != null && s != null)
        {
            String.format("Dialing Phone: %s", new Object[] {
                s
            });
            al.b();
            if (Boolean.parseBoolean((String)map.get("dial")) && ((Context) (obj)).checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)
            {
                s = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder("tel:")).append(s).toString()));
            } else
            {
                s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("tel:")).append(s).toString()));
            }
            au.b.b(((Context) (obj)), s);
            an.a.a(((Context) (obj)), "tel", a((String)map.get("PROPERTY_EXPANDING")));
            s = aj.a("Success.");
        } else
        {
            s = null;
        }
        obj = s;
_L4:
        return ((aj) (obj));
_L2:
        if (!"composeEmail".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        String s1 = (String)map.get("recipient");
        String s5 = (String)map.get("subject");
        String s8 = (String)map.get("message");
        obj = obj1;
        if (s != null)
        {
            al.b();
            obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("plain/text");
            if (s1 != null)
            {
                ((Intent) (obj)).putExtra("android.intent.extra.EMAIL", s1.split(","));
            }
            if (s5 != null)
            {
                ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", s5);
            }
            if (s8 != null)
            {
                ((Intent) (obj)).putExtra("android.intent.extra.TEXT", s8);
            }
            au.b.b(s, ((Intent) (obj)));
            an.a.a(s, "email", a((String)map.get("PROPERTY_EXPANDING")));
            return aj.a("Success.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!"composeSms".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        String s6 = (String)map.get("number");
        String s2 = (String)map.get("message");
        obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s6 != null)
            {
                String.format("Creating sms: %s", new Object[] {
                    s6
                });
                al.b();
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("sms:")).append(s6).toString()));
                if (s2 != null)
                {
                    ((Intent) (obj)).putExtra("sms_body", s2);
                }
                au.b.b(s, ((Intent) (obj)));
                an.a.a(s, "sms", a((String)map.get("PROPERTY_EXPANDING")));
                return aj.a("SMS Sent");
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        if ("enableHardwareAcceleration".equals(s))
        {
            return a(map);
        }
        if (!"getAvailableSchemes".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        obj = obj1;
        if (s != null)
        {
            map = v.a(s);
            obj = new aj();
            obj.c = 1;
            obj.d = map.c(s);
            return ((aj) (obj));
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (!"getInfo".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        obj = obj1;
        if (s != null)
        {
            map = new aj();
            map.c = 1;
            map.d = a(((Context) (s)));
            return map;
        }
        if (true) goto _L4; else goto _L7
_L7:
        if ("getLocation".equals(s))
        {
            return a();
        }
        if (!"getOrientation".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        obj = obj1;
        if (s != null)
        {
            int i = s.getResources().getConfiguration().orientation;
            if (i == 0)
            {
                i = ((WindowManager)s.getSystemService("window")).getDefaultDisplay().getOrientation();
            }
            s = new aj();
            s.c = 1;
            switch (i)
            {
            default:
                s.d = "portrait";
                return s;

            case 2: // '\002'
                s.d = "landscape";
                break;
            }
            return s;
        }
        if (true) goto _L4; else goto _L8
_L8:
        if (!"isSchemeAvailable".equals(s)) goto _L10; else goto _L9
_L9:
        s = (String)map.get("scheme");
        if (!s.contains(":"))
        {
            s = (new StringBuilder()).append(s).append(":").toString();
        }
        map = (Context)b.get();
        if (s == null || map == null) goto _L12; else goto _L11
_L11:
        obj = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (map.getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000).size() <= 0) goto _L12; else goto _L13
_L13:
        s = aj.a(s);
_L14:
        return s;
_L12:
        s = aj.b(s);
        if (true) goto _L14; else goto _L10
_L10:
        if (!"openAppStore".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        String s3 = (String)map.get("appId");
        String s7 = (String)map.get("referrer");
        obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s3 != null)
            {
                String.format("Opening marketplace: %s", new Object[] {
                    s3
                });
                al.b();
                obj = new Intent("android.intent.action.VIEW");
                if (Build.MANUFACTURER.equals("Amazon"))
                {
                    ((Intent) (obj)).setData(Uri.parse(String.format("amzn://apps/android?p=%s", new Object[] {
                        s3
                    })));
                } else
                if (s7 != null)
                {
                    ((Intent) (obj)).setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[] {
                        s3, URLEncoder.encode(s7)
                    })));
                } else
                {
                    ((Intent) (obj)).setData(Uri.parse((new StringBuilder("market://details?id=")).append(s3).toString()));
                }
                an.a.a(s, "market", a((String)map.get("PROPERTY_EXPANDING")));
                au.b.b(s, ((Intent) (obj)));
                return aj.a("Success.");
            }
        }
        if (true) goto _L4; else goto _L15
_L15:
        if ("openUrl".equals(s))
        {
            s = (Context)b.get();
            obj = (String)map.get("url");
            if (s != null && obj != null)
            {
                String.format("Opening: %s", new Object[] {
                    obj
                });
                al.b();
                obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
                if (((Intent) (obj)).getScheme().startsWith("http") || ((Intent) (obj)).getScheme().startsWith("https"))
                {
                    an.a.a(s, "browser", a((String)map.get("PROPERTY_EXPANDING")));
                }
                au.b.b(s, ((Intent) (obj)));
                s = aj.a("Overlay opened");
            } else
            {
                s = aj.b("URL could not be opened");
            }
            return s;
        }
        if (!"setMMDID".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)map.get("mmdid");
        map = (Context)b.get();
        obj = obj1;
        if (map != null)
        {
            v.a(map).a(map, s, true);
            return aj.a("MMDID is set");
        }
        if (true) goto _L4; else goto _L16
_L16:
        if (!"showMap".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        s = (Context)b.get();
        String s4 = (String)map.get("location");
        obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s4 != null)
            {
                String.format("Launching Google Maps: %s", new Object[] {
                    s4
                });
                al.b();
                au.b.b(s, new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("geo:")).append(s4).toString())));
                an.a.a(s, "geo", a((String)map.get("PROPERTY_EXPANDING")));
                return aj.a("Map successfully opened");
            }
        }
        if (true) goto _L4; else goto _L17
_L17:
        obj = obj1;
        if ("tweet".equals(s))
        {
            return null;
        }
        if (true) goto _L4; else goto _L18
_L18:
    }
}
