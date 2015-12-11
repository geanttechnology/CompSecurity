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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMSDK, MMJSResponse, MMWebView, 
//            HandShake, MMRequest

class BridgeMMDevice extends MMJSObject
{

    BridgeMMDevice()
    {
    }

    static JSONObject getDeviceInfo(Context context)
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        try
        {
            jsonobject.put("sdkVersion", "5.0.1-13.05.14.a");
            jsonobject.put("mmisdk", "5.0.1-13.05.14.a");
            jsonobject.put("connection", MMSDK.getConnectionType(context));
            jsonobject.put("platform", "Android");
            if (android.os.Build.VERSION.RELEASE != null)
            {
                jsonobject.put("version", android.os.Build.VERSION.RELEASE);
            }
            if (Build.MODEL != null)
            {
                jsonobject.put("device", Build.MODEL);
            }
            jsonobject.put("mmdid", MMSDK.getMMdid(context));
            context = context.getResources().getDisplayMetrics();
            jsonobject.put("density", new Float(((DisplayMetrics) (context)).density));
            jsonobject.put("height", new Integer(((DisplayMetrics) (context)).heightPixels));
            jsonobject.put("width", new Integer(((DisplayMetrics) (context)).widthPixels));
            context = Locale.getDefault();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return jsonobject;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        jsonobject.put("language", context.getLanguage());
        jsonobject.put("country", context.getCountry());
        context = new JSONObject();
        try
        {
            context.put("name", "MAC-ID");
            context.put("path", "/");
            context.put("value", MMSDK.macId);
            jsonarray = new JSONArray();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return jsonobject;
        }
        try
        {
            jsonarray.put(context);
            jsonobject.put("cookies", jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public MMJSResponse call(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        Object obj = (String)hashmap.get("number");
        if (context != null && obj != null)
        {
            MMSDK.Log.d("Dialing Phone: %s", new Object[] {
                obj
            });
            if (Boolean.parseBoolean((String)hashmap.get("dial")) && context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)
            {
                obj = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(((String) (obj))).toString()));
            } else
            {
                obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("tel:").append(((String) (obj))).toString()));
            }
            Utils.IntentUtils.startActivity(context, ((Intent) (obj)));
            MMSDK.Event.intentStarted(context, "tel", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeEmail(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("recipients");
        String s1 = (String)hashmap.get("subject");
        String s2 = (String)hashmap.get("message");
        if (context != null)
        {
            MMSDK.Log.d("Creating email");
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
            Utils.IntentUtils.startActivity(context, intent);
            MMSDK.Event.intentStarted(context, "email", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeSms(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        Object obj = (String)hashmap.get("number");
        String s = (String)hashmap.get("message");
        if (context != null && obj != null)
        {
            MMSDK.Log.d("Creating sms: %s", new Object[] {
                obj
            });
            obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("sms:").append(((String) (obj))).toString()));
            if (s != null)
            {
                ((Intent) (obj)).putExtra("sms_body", s);
            }
            Utils.IntentUtils.startActivity(context, ((Intent) (obj)));
            MMSDK.Event.intentStarted(context, "sms", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess("SMS Sent");
        } else
        {
            return null;
        }
    }

    public MMJSResponse enableHardwareAcceleration(HashMap hashmap)
    {
        MMSDK.Log.d((new StringBuilder()).append("hardware accel call").append(hashmap).toString());
        hashmap = (String)hashmap.get("enabled");
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null && mmwebview != null)
        {
            if (Boolean.parseBoolean(hashmap))
            {
                mmwebview.enableHardwareAcceleration();
            } else
            {
                mmwebview.disableAllAcceleration();
            }
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse getAvailableSchemes(HashMap hashmap)
    {
        hashmap = (Context)contextRef.get();
        if (hashmap != null)
        {
            HandShake handshake = HandShake.sharedHandShake(hashmap);
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = handshake.getSchemesJSONArray(hashmap);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getInfo(HashMap hashmap)
    {
        hashmap = (Context)contextRef.get();
        if (hashmap != null)
        {
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = getDeviceInfo(hashmap);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getLocation(HashMap hashmap)
    {
        if (MMRequest.location != null)
        {
label0:
            {
                MMJSResponse mmjsresponse = null;
                try
                {
                    hashmap = new JSONObject();
                }
                // Misplaced declaration of an exception variable
                catch (HashMap hashmap)
                {
                    hashmap = mmjsresponse;
                    if (false)
                    {
                    } else
                    {
                        break label0;
                    }
                }
                try
                {
                    hashmap.put("lat", Double.toString(MMRequest.location.getLatitude()));
                    hashmap.put("long", Double.toString(MMRequest.location.getLongitude()));
                    if (MMRequest.location.hasAccuracy())
                    {
                        hashmap.put("ha", Float.toString(MMRequest.location.getAccuracy()));
                        hashmap.put("va", Float.toString(MMRequest.location.getAccuracy()));
                    }
                    if (MMRequest.location.hasSpeed())
                    {
                        hashmap.put("spd", Float.toString(MMRequest.location.getSpeed()));
                    }
                    if (MMRequest.location.hasBearing())
                    {
                        hashmap.put("brg", Float.toString(MMRequest.location.getBearing()));
                    }
                    if (MMRequest.location.hasAltitude())
                    {
                        hashmap.put("alt", Double.toString(MMRequest.location.getAltitude()));
                    }
                    hashmap.put("tslr", Long.toString(MMRequest.location.getTime()));
                }
                catch (JSONException jsonexception) { }
            }
            mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = hashmap;
            return mmjsresponse;
        } else
        {
            return MMJSResponse.responseWithError("location object has not been set");
        }
    }

    public MMJSResponse getOrientation(HashMap hashmap)
    {
        hashmap = (Context)contextRef.get();
        if (hashmap != null)
        {
            int j = hashmap.getResources().getConfiguration().orientation;
            int i = j;
            if (j == 0)
            {
                i = ((WindowManager)hashmap.getSystemService("window")).getDefaultDisplay().getOrientation();
            }
            hashmap = new MMJSResponse();
            hashmap.result = 1;
            switch (i)
            {
            default:
                hashmap.response = "portrait";
                return hashmap;

            case 2: // '\002'
                hashmap.response = "landscape";
                break;
            }
            return hashmap;
        } else
        {
            return null;
        }
    }

    public MMJSResponse isSchemeAvailable(HashMap hashmap)
    {
        Object obj = (String)hashmap.get("scheme");
        hashmap = ((HashMap) (obj));
        if (!((String) (obj)).contains(":"))
        {
            hashmap = (new StringBuilder()).append(((String) (obj))).append(":").toString();
        }
        obj = (Context)contextRef.get();
        if (hashmap != null && obj != null)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(hashmap));
            if (((Context) (obj)).getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
            {
                return MMJSResponse.responseWithSuccess(hashmap);
            }
        }
        return MMJSResponse.responseWithError(hashmap);
    }

    public MMJSResponse openAppStore(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("appId");
        String s1 = (String)hashmap.get("referrer");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Opening marketplace: %s", new Object[] {
                s
            });
            Intent intent = new Intent("android.intent.action.VIEW");
            if (s1 != null)
            {
                intent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[] {
                    s, URLEncoder.encode(s1)
                })));
            } else
            {
                intent.setData(Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
            }
            MMSDK.Event.intentStarted(context, "market", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.startActivity(context, intent);
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse openUrl(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        Object obj = (String)hashmap.get("url");
        if (context != null && obj != null)
        {
            MMSDK.Log.d("Opening: %s", new Object[] {
                obj
            });
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            if (((Intent) (obj)).getScheme().startsWith("http") || ((Intent) (obj)).getScheme().startsWith("https"))
            {
                MMSDK.Event.intentStarted(context, "browser", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            }
            Utils.IntentUtils.startActivity(context, ((Intent) (obj)));
            return MMJSResponse.responseWithSuccess("Overlay opened");
        } else
        {
            return MMJSResponse.responseWithError("URL could not be opened");
        }
    }

    public MMJSResponse setMMDID(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("mmdid");
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            HandShake.sharedHandShake(context).setMMdid(context, hashmap);
            return MMJSResponse.responseWithSuccess("MMDID is set");
        } else
        {
            return null;
        }
    }

    public MMJSResponse showMap(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("location");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Launching Google Maps: %s", new Object[] {
                s
            });
            Utils.IntentUtils.startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("geo:").append(s).toString())));
            MMSDK.Event.intentStarted(context, "geo", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess("Map successfully opened");
        } else
        {
            return null;
        }
    }

    public MMJSResponse tweet(HashMap hashmap)
    {
        return null;
    }
}
