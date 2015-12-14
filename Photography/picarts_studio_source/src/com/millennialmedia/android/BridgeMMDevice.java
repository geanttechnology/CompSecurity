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
//            MMJSObject, MMSDK, MMLog, MMJSResponse, 
//            MMWebView, HandShake, MMRequest

class BridgeMMDevice extends MMJSObject
{

    BridgeMMDevice()
    {
    }

    static JSONObject a(Context context)
    {
        Object obj = new JSONObject();
        ((JSONObject) (obj)).put("sdkVersion", "5.3.0-c3980670.a");
        ((JSONObject) (obj)).put("connection", MMSDK.b(context));
        ((JSONObject) (obj)).put("platform", "Android");
        if (android.os.Build.VERSION.RELEASE != null)
        {
            ((JSONObject) (obj)).put("version", android.os.Build.VERSION.RELEASE);
        }
        if (Build.MODEL != null)
        {
            ((JSONObject) (obj)).put("device", Build.MODEL);
        }
        ((JSONObject) (obj)).put("mmdid", MMSDK.c(context));
        context = context.getResources().getDisplayMetrics();
        ((JSONObject) (obj)).put("density", new Float(((DisplayMetrics) (context)).density));
        ((JSONObject) (obj)).put("height", new Integer(((DisplayMetrics) (context)).heightPixels));
        ((JSONObject) (obj)).put("width", new Integer(((DisplayMetrics) (context)).widthPixels));
        context = Locale.getDefault();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        ((JSONObject) (obj)).put("language", context.getLanguage());
        ((JSONObject) (obj)).put("country", context.getCountry());
        context = new JSONObject();
        context.put("name", "MAC-ID");
        context.put("path", "/");
        context.put("value", MMSDK.d);
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(context);
        ((JSONObject) (obj)).put("cookies", jsonarray);
        return ((JSONObject) (obj));
        obj;
        context = null;
_L2:
        MMLog.a("BridgeMMDevice", "Bridge getting deviceInfo json exception: ", ((Throwable) (obj)));
        return context;
        JSONException jsonexception;
        jsonexception;
        context = ((Context) (obj));
        obj = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("call".equals(s))
        {
            mmjsresponse = call(map);
        } else
        {
            if ("composeEmail".equals(s))
            {
                return composeEmail(map);
            }
            if ("composeSms".equals(s))
            {
                return composeSms(map);
            }
            if ("enableHardwareAcceleration".equals(s))
            {
                return enableHardwareAcceleration(map);
            }
            if ("getAvailableSchemes".equals(s))
            {
                return getAvailableSchemes(map);
            }
            if ("getInfo".equals(s))
            {
                return getInfo(map);
            }
            if ("getLocation".equals(s))
            {
                return getLocation(map);
            }
            if ("getOrientation".equals(s))
            {
                return getOrientation(map);
            }
            if ("isSchemeAvailable".equals(s))
            {
                return isSchemeAvailable(map);
            }
            if ("openAppStore".equals(s))
            {
                return openAppStore(map);
            }
            if ("openUrl".equals(s))
            {
                return openUrl(map);
            }
            if ("setMMDID".equals(s))
            {
                return setMMDID(map);
            }
            if ("showMap".equals(s))
            {
                return showMap(map);
            }
            if ("tweet".equals(s))
            {
                return tweet(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse call(Map map)
    {
        Context context = (Context)b.get();
        Object obj = (String)map.get("number");
        if (context != null && obj != null)
        {
            MMLog.b("BridgeMMDevice", String.format("Dialing Phone: %s", new Object[] {
                obj
            }));
            if (Boolean.parseBoolean((String)map.get("dial")) && context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)
            {
                obj = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder("tel:")).append(((String) (obj))).toString()));
            } else
            {
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("tel:")).append(((String) (obj))).toString()));
            }
            Utils.IntentUtils.c(context, ((Intent) (obj)));
            MMSDK.Event.a(context, "tel", a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeEmail(Map map)
    {
        Context context = (Context)b.get();
        String s = (String)map.get("recipient");
        String s1 = (String)map.get("subject");
        String s2 = (String)map.get("message");
        if (context != null)
        {
            MMLog.b("BridgeMMDevice", "Creating email");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            if (s != null)
            {
                intent.putExtra("android.intent.extra.EMAIL", s.split(","));
            }
            if (s1 != null)
            {
                intent.putExtra("android.intent.extra.SUBJECT", s1);
            }
            if (s2 != null)
            {
                intent.putExtra("android.intent.extra.TEXT", s2);
            }
            Utils.IntentUtils.c(context, intent);
            MMSDK.Event.a(context, "email", a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeSms(Map map)
    {
        Context context = (Context)b.get();
        Object obj = (String)map.get("number");
        String s = (String)map.get("message");
        if (context != null && obj != null)
        {
            MMLog.b("BridgeMMDevice", String.format("Creating sms: %s", new Object[] {
                obj
            }));
            obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("sms:")).append(((String) (obj))).toString()));
            if (s != null)
            {
                ((Intent) (obj)).putExtra("sms_body", s);
            }
            Utils.IntentUtils.c(context, ((Intent) (obj)));
            MMSDK.Event.a(context, "sms", a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a("SMS Sent");
        } else
        {
            return null;
        }
    }

    public MMJSResponse enableHardwareAcceleration(Map map)
    {
        MMLog.b("BridgeMMDevice", (new StringBuilder("hardware accel call")).append(map).toString());
        map = (String)map.get("enabled");
        MMWebView mmwebview = (MMWebView)c.get();
        if (mmwebview != null && mmwebview != null)
        {
            if (Boolean.parseBoolean(map))
            {
                mmwebview.c();
            } else
            {
                mmwebview.a();
            }
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse getAvailableSchemes(Map map)
    {
        map = (Context)b.get();
        if (map != null)
        {
            HandShake handshake = HandShake.a(map);
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.c = 1;
            mmjsresponse.d = handshake.c(map);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getInfo(Map map)
    {
        map = (Context)b.get();
        if (map != null)
        {
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.c = 1;
            mmjsresponse.d = a(map);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getLocation(Map map)
    {
        if (MMRequest.l == null) goto _L2; else goto _L1
_L1:
        map = new JSONObject();
        map.put("lat", Double.toString(MMRequest.l.getLatitude()));
        map.put("long", Double.toString(MMRequest.l.getLongitude()));
        if (MMRequest.l.hasAccuracy())
        {
            map.put("ha", Float.toString(MMRequest.l.getAccuracy()));
            map.put("va", Float.toString(MMRequest.l.getAccuracy()));
        }
        if (MMRequest.l.hasSpeed())
        {
            map.put("spd", Float.toString(MMRequest.l.getSpeed()));
        }
        if (MMRequest.l.hasBearing())
        {
            map.put("brg", Float.toString(MMRequest.l.getBearing()));
        }
        if (MMRequest.l.hasAltitude())
        {
            map.put("alt", Double.toString(MMRequest.l.getAltitude()));
        }
        map.put("tslr", Long.toString(MMRequest.l.getTime()));
_L3:
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.c = 1;
        mmjsresponse.d = map;
        return mmjsresponse;
        JSONException jsonexception;
        jsonexception;
        map = null;
_L4:
        MMLog.a("BridgeMMDevice", "Bridge getLocation json exception: ", jsonexception);
        if (true) goto _L3; else goto _L2
_L2:
        return MMJSResponse.b("location object has not been set");
        jsonexception;
          goto _L4
    }

    public MMJSResponse getOrientation(Map map)
    {
        map = (Context)b.get();
        if (map == null) goto _L2; else goto _L1
_L1:
        int i;
        i = map.getResources().getConfiguration().orientation;
        if (i == 0)
        {
            i = ((WindowManager)map.getSystemService("window")).getDefaultDisplay().getOrientation();
        }
        map = new MMJSResponse();
        map.c = 1;
        i;
        JVM INSTR tableswitch 2 2: default 80
    //                   2 89;
           goto _L3 _L4
_L3:
        map.d = "portrait";
_L5:
        return map;
_L4:
        map.d = "landscape";
        if (true) goto _L5; else goto _L2
_L2:
        return null;
    }

    public MMJSResponse isSchemeAvailable(Map map)
    {
        map = (String)map.get("scheme");
        if (!map.contains(":"))
        {
            map = (new StringBuilder()).append(map).append(":").toString();
        }
        Context context = (Context)b.get();
        if (map != null && context != null)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(map));
            if (context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
            {
                return MMJSResponse.a(map);
            }
        }
        return MMJSResponse.b(map);
    }

    public MMJSResponse openAppStore(Map map)
    {
        Context context = (Context)b.get();
        String s = (String)map.get("appId");
        String s1 = (String)map.get("referrer");
        if (context != null && s != null)
        {
            MMLog.b("BridgeMMDevice", String.format("Opening marketplace: %s", new Object[] {
                s
            }));
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.MANUFACTURER.equals("Amazon"))
            {
                intent.setData(Uri.parse(String.format("amzn://apps/android?p=%s", new Object[] {
                    s
                })));
            } else
            if (s1 != null)
            {
                intent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[] {
                    s, URLEncoder.encode(s1)
                })));
            } else
            {
                intent.setData(Uri.parse((new StringBuilder("market://details?id=")).append(s).toString()));
            }
            MMSDK.Event.a(context, "market", a((String)map.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.c(context, intent);
            return MMJSResponse.a();
        } else
        {
            return null;
        }
    }

    public MMJSResponse openUrl(Map map)
    {
        Context context = (Context)b.get();
        Object obj = (String)map.get("url");
        if (context != null && obj != null)
        {
            MMLog.b("BridgeMMDevice", String.format("Opening: %s", new Object[] {
                obj
            }));
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            if (((Intent) (obj)).getScheme().startsWith("http") || ((Intent) (obj)).getScheme().startsWith("https"))
            {
                MMSDK.Event.a(context, "browser", a((String)map.get("PROPERTY_EXPANDING")));
            }
            Utils.IntentUtils.c(context, ((Intent) (obj)));
            return MMJSResponse.a("Overlay opened");
        } else
        {
            return MMJSResponse.b("URL could not be opened");
        }
    }

    public MMJSResponse setMMDID(Map map)
    {
        map = (String)map.get("mmdid");
        Context context = (Context)b.get();
        if (context != null)
        {
            HandShake.a(context).a(context, map, true);
            return MMJSResponse.a("MMDID is set");
        } else
        {
            return null;
        }
    }

    public MMJSResponse showMap(Map map)
    {
        Context context = (Context)b.get();
        String s = (String)map.get("location");
        if (context != null && s != null)
        {
            MMLog.b("BridgeMMDevice", String.format("Launching Google Maps: %s", new Object[] {
                s
            }));
            Utils.IntentUtils.c(context, new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("geo:")).append(s).toString())));
            MMSDK.Event.a(context, "geo", a((String)map.get("PROPERTY_EXPANDING")));
            return MMJSResponse.a("Map successfully opened");
        } else
        {
            return null;
        }
    }

    public MMJSResponse tweet(Map map)
    {
        return null;
    }
}
