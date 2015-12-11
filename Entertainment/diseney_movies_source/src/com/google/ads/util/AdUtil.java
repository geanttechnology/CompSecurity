// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.ads.util:
//            e, b, d

public final class AdUtil
{
    public static class UserActivityReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT"))
            {
                AdUtil.a(true);
            } else
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
            {
                AdUtil.a(false);
                return;
            }
        }

        public UserActivityReceiver()
        {
        }
    }

    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/ads/util/AdUtil$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("INVALID", 0);
            b = new a("SPEAKER", 1);
            c = new a("HEADPHONES", 2);
            d = new a("VIBRATE", 3);
            e = new a("EMULATOR", 4);
            f = new a("OTHER", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }


    public static final int a;
    private static Boolean b = null;
    private static String c = null;
    private static String d;
    private static String e = null;
    private static AudioManager f;
    private static boolean g = true;
    private static boolean h = false;
    private static String i = null;

    public static int a()
    {
        return a < 9 ? 0 : 6;
    }

    public static int a(Context context, int j)
    {
        return (int)TypedValue.applyDimension(1, j, context.getResources().getDisplayMetrics());
    }

    public static int a(Context context, DisplayMetrics displaymetrics)
    {
        if (a >= 4)
        {
            return com.google.ads.util.e.a(context, displaymetrics);
        } else
        {
            return displaymetrics.heightPixels;
        }
    }

    public static int a(String s)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.ads.util.b.e((new StringBuilder()).append("The Android SDK version couldn't be parsed to an int: ").append(android.os.Build.VERSION.SDK).toString());
            com.google.ads.util.b.e("Defaulting to Android SDK version 3.");
            return 3;
        }
        return j;
    }

    public static DisplayMetrics a(Activity activity)
    {
        if (activity.getWindowManager() == null)
        {
            return null;
        } else
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            return displaymetrics;
        }
    }

    public static String a(Context context)
    {
        if (c == null)
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (context == null || c())
            {
                context = b("emulator");
            } else
            {
                context = b(context);
            }
            if (context == null)
            {
                return null;
            }
            c = context.toUpperCase(Locale.US);
        }
        return c;
    }

    public static String a(Readable readable)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        CharBuffer charbuffer = CharBuffer.allocate(2048);
        do
        {
            int j = readable.read(charbuffer);
            if (j != -1)
            {
                charbuffer.flip();
                stringbuilder.append(charbuffer, 0, j);
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    public static String a(Map map)
    {
        try
        {
            map = b(map).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            com.google.ads.util.b.d("JsonException in serialization: ", map);
            return null;
        }
        return map;
    }

    public static HashMap a(Location location)
    {
        if (location == null)
        {
            return null;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("time", Long.valueOf(location.getTime() * 1000L));
            hashmap.put("lat", Long.valueOf((long)(location.getLatitude() * 10000000D)));
            hashmap.put("long", Long.valueOf((long)(location.getLongitude() * 10000000D)));
            hashmap.put("radius", Long.valueOf((long)(location.getAccuracy() * 1000F)));
            return hashmap;
        }
    }

    public static JSONArray a(Set set)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        if (set == null || set.isEmpty())
        {
            return jsonarray;
        }
        for (set = set.iterator(); set.hasNext();)
        {
            Object obj = set.next();
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float))
            {
                jsonarray.put(obj);
            } else
            if (obj instanceof Map)
            {
                try
                {
                    jsonarray.put(b((Map)obj));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.ads.util.b.d("Unknown map type in json serialization: ", ((Throwable) (obj)));
                }
            } else
            if (obj instanceof Set)
            {
                try
                {
                    jsonarray.put(a((Set)obj));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.ads.util.b.d("Unknown map type in json serialization: ", ((Throwable) (obj)));
                }
            } else
            {
                com.google.ads.util.b.e((new StringBuilder()).append("Unknown value in json serialization: ").append(obj).toString());
            }
        }

        return jsonarray;
    }

    public static void a(WebView webview)
    {
        String s = i(webview.getContext().getApplicationContext());
        webview.getSettings().setUserAgentString(s);
    }

    public static void a(HttpURLConnection httpurlconnection, Context context)
    {
        httpurlconnection.setRequestProperty("User-Agent", i(context));
    }

    public static void a(boolean flag)
    {
        g = flag;
    }

    public static boolean a(int j, int k, String s)
    {
        if ((j & k) == 0)
        {
            com.google.ads.util.b.b((new StringBuilder()).append("The android:configChanges value of the com.google.ads.AdActivity must include ").append(s).append(".").toString());
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean a(Context context, String s)
    {
        try
        {
            context.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Intent intent, Context context)
    {
        return context.getPackageManager().resolveActivity(intent, 0x10000) != null;
    }

    public static boolean a(Uri uri)
    {
        if (uri != null)
        {
            if ("http".equalsIgnoreCase(uri = uri.getScheme()) || "https".equalsIgnoreCase(uri))
            {
                return true;
            }
        }
        return false;
    }

    static boolean a(d d1)
    {
        d d2 = d1;
        if (d1 == null)
        {
            d2 = d.d;
        }
        return d2.equals(d.e) || d2.equals(d.f);
    }

    public static int b()
    {
        return a < 9 ? 1 : 7;
    }

    public static int b(Context context, DisplayMetrics displaymetrics)
    {
        if (a >= 4)
        {
            return com.google.ads.util.e.b(context, displaymetrics);
        } else
        {
            return displaymetrics.widthPixels;
        }
    }

    public static String b(String s)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (s != null)
        {
            obj = obj1;
            if (s.length() > 0)
            {
                try
                {
                    obj = MessageDigest.getInstance("MD5");
                    ((MessageDigest) (obj)).update(s.getBytes(), 0, s.length());
                    obj = String.format(Locale.US, "%032X", new Object[] {
                        new BigInteger(1, ((MessageDigest) (obj)).digest())
                    });
                }
                catch (NoSuchAlgorithmException nosuchalgorithmexception)
                {
                    return s.substring(0, 32);
                }
            }
        }
        return ((String) (obj));
    }

    public static HashMap b(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        uri = uri.getEncodedQuery();
        if (uri != null)
        {
            uri = uri.split("&");
            int k = uri.length;
            int j = 0;
            while (j < k) 
            {
                String s = uri[j];
                int l = s.indexOf("=");
                if (l < 0)
                {
                    hashmap.put(Uri.decode(s), null);
                } else
                {
                    hashmap.put(Uri.decode(s.substring(0, l)), Uri.decode(s.substring(l + 1, s.length())));
                }
                j++;
            }
        }
        return hashmap;
    }

    public static JSONObject b(Map map)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        if (map == null || map.isEmpty())
        {
            return jsonobject;
        }
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            Object obj1 = map.get(obj);
            if ((obj1 instanceof String) || (obj1 instanceof Integer) || (obj1 instanceof Double) || (obj1 instanceof Long) || (obj1 instanceof Float))
            {
                jsonobject.put(((String) (obj)), obj1);
            } else
            if (obj1 instanceof Map)
            {
                try
                {
                    jsonobject.put(((String) (obj)), b((Map)obj1));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    com.google.ads.util.b.d("Unknown map type in json serialization: ", ((Throwable) (obj)));
                }
            } else
            if (obj1 instanceof Set)
            {
                try
                {
                    jsonobject.put(((String) (obj)), a((Set)obj1));
                }
                catch (ClassCastException classcastexception)
                {
                    com.google.ads.util.b.d("Unknown map type in json serialization: ", classcastexception);
                }
            } else
            {
                com.google.ads.util.b.e((new StringBuilder()).append("Unknown value in json serialization: ").append(obj1).toString());
            }
        }

        return jsonobject;
    }

    public static boolean b(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        context = context.getPackageName();
        if (packagemanager.checkPermission("android.permission.INTERNET", context) == -1)
        {
            com.google.ads.util.b.b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            return false;
        }
        if (packagemanager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context) == -1)
        {
            com.google.ads.util.b.b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean c()
    {
        return a(((d) (null)));
    }

    public static boolean c(Context context)
    {
        if (b != null)
        {
            return b.booleanValue();
        }
        context = context.getPackageManager().resolveActivity(new Intent(context, com/google/ads/AdActivity), 0x10000);
        b = Boolean.valueOf(true);
        if (context != null && ((ResolveInfo) (context)).activityInfo != null) goto _L2; else goto _L1
_L1:
        com.google.ads.util.b.b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
        b = Boolean.valueOf(false);
_L4:
        return b.booleanValue();
_L2:
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 16, "keyboard"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 32, "keyboardHidden"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 128, "orientation"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 256, "screenLayout"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 512, "uiMode"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 1024, "screenSize"))
        {
            b = Boolean.valueOf(false);
        }
        if (!a(((ResolveInfo) (context)).activityInfo.configChanges, 2048, "smallestScreenSize"))
        {
            b = Boolean.valueOf(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String d(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null)
        {
            return null;
        }
        switch (context.getType())
        {
        default:
            return "unknown";

        case 0: // '\0'
            return "ed";

        case 1: // '\001'
            return "wi";
        }
    }

    public static boolean d()
    {
        return g;
    }

    public static String e(Context context)
    {
        if (d == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            context = context.getPackageManager();
            List list = context.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 0x10000);
            if (list == null || list.isEmpty())
            {
                stringbuilder.append("m");
            }
            context = context.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 0x10000);
            if (context == null || context.isEmpty())
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append("a");
            }
            d = stringbuilder.toString();
        }
        return d;
    }

    public static String f(Context context)
    {
        Object obj = null;
        if (e == null) goto _L2; else goto _L1
_L1:
        context = e;
_L4:
        return context;
_L2:
        Object obj1;
        Object obj2;
        try
        {
            obj1 = context.getPackageManager();
            obj2 = ((PackageManager) (obj1)).resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 0x10000);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        context = obj;
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        obj2 = ((ResolveInfo) (obj2)).activityInfo;
        context = obj;
        if (obj2 == null) goto _L4; else goto _L5
_L5:
        obj1 = ((PackageManager) (obj1)).getPackageInfo(((ActivityInfo) (obj2)).packageName, 0);
        context = obj;
        if (obj1 == null) goto _L4; else goto _L6
_L6:
        e = (new StringBuilder()).append(((PackageInfo) (obj1)).versionCode).append(".").append(((ActivityInfo) (obj2)).packageName).toString();
        context = e;
        return context;
    }

    public static a g(Context context)
    {
        if (f == null)
        {
            f = (AudioManager)context.getSystemService("audio");
        }
        context = a.f;
        int j = f.getMode();
        if (c())
        {
            return a.e;
        }
        if (f.isMusicActive() || f.isSpeakerphoneOn() || j == 2 || j == 1)
        {
            return a.d;
        }
        j = f.getRingerMode();
        if (j == 0 || j == 1)
        {
            return a.d;
        } else
        {
            return a.b;
        }
    }

    public static void h(Context context)
    {
        if (h)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.USER_PRESENT");
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new UserActivityReceiver(), intentfilter);
            h = true;
            return;
        }
    }

    public static String i(Context context)
    {
label0:
        {
label1:
            {
                if (i != null)
                {
                    break label0;
                }
                Object obj = (new WebView(context)).getSettings().getUserAgentString();
                if (obj != null && ((String) (obj)).length() != 0)
                {
                    context = ((Context) (obj));
                    if (!((String) (obj)).equals("Java0"))
                    {
                        break label1;
                    }
                }
                String s = System.getProperty("os.name", "Linux");
                String s1 = (new StringBuilder()).append("Android ").append(android.os.Build.VERSION.RELEASE).toString();
                Object obj1 = Locale.getDefault();
                obj = ((Locale) (obj1)).getLanguage().toLowerCase(Locale.US);
                context = ((Context) (obj));
                if (((String) (obj)).length() == 0)
                {
                    context = "en";
                }
                obj1 = ((Locale) (obj1)).getCountry().toLowerCase(Locale.US);
                obj = context;
                if (((String) (obj1)).length() > 0)
                {
                    obj = (new StringBuilder()).append(context).append("-").append(((String) (obj1))).toString();
                }
                context = (new StringBuilder()).append(Build.MODEL).append(" Build/").append(Build.ID).toString();
                context = (new StringBuilder()).append("Mozilla/5.0 (").append(s).append("; U; ").append(s1).append("; ").append(((String) (obj))).append("; ").append(context).append(") AppleWebKit/0.0 (KHTML, like ").append("Gecko) Version/0.0 Mobile Safari/0.0").toString();
            }
            i = (new StringBuilder()).append(context).append(" (Mobile; ").append("afma-sdk-a-v").append("6.4.1").append(")").toString();
        }
        return i;
    }

    static 
    {
        a = a(android.os.Build.VERSION.SDK);
    }
}
