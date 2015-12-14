// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.millennialmedia.google.gson.b;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, MMAdImpl, PreCacheWorker, MRaid, 
//            MMSDK, DTOCachedVideo, HttpGetRequest

class HandShake
{

    static String a = "28913";
    private static String h = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static HandShake i;
    private static String w = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    boolean b;
    long c;
    boolean d;
    String e;
    long f;
    NuanceCredentials g;
    private WeakReference j;
    private WeakReference k;
    private final Handler l;
    private long m;
    private String n;
    private final LinkedHashMap o;
    private final ArrayList p;
    private String q;
    private long r;
    private long s;
    private String t;
    private String u;
    private String v;
    private final Runnable x;
    private DTOCachedVideo y[];

    private HandShake()
    {
        l = new Handler(Looper.getMainLooper());
        o = new LinkedHashMap();
        p = new ArrayList();
        r = 0x36ee80L;
        b = false;
        s = 0x5265c00L;
        c = 0xf731400L;
        x = new Runnable() {

            private HandShake a;

            public void run()
            {
                Context context1 = (Context)HandShake.a(a).get();
                Context context = context1;
                if (context1 == null)
                {
                    context = (Context)com.millennialmedia.android.HandShake.b(a).get();
                }
                if (context != null)
                {
                    HandShake.a(context);
                }
            }

            
            {
                a = HandShake.this;
                super();
            }
        };
    }

    private HandShake(Context context)
    {
        l = new Handler(Looper.getMainLooper());
        o = new LinkedHashMap();
        p = new ArrayList();
        r = 0x36ee80L;
        b = false;
        s = 0x5265c00L;
        c = 0xf731400L;
        x = new _cls2();
        j = new WeakReference(context);
        k = new WeakReference(context.getApplicationContext());
        if (!f(context) || System.currentTimeMillis() - m > s)
        {
            m = System.currentTimeMillis();
            a(false);
        }
    }

    static HandShake a(Context context)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        MMLog.e("HandShake", "No apid set for the handshake.");
        context = null;
_L5:
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (i != null) goto _L4; else goto _L3
_L3:
        i = new HandShake(context);
_L7:
        context = i;
          goto _L5
_L4:
        if (System.currentTimeMillis() - i.m <= i.s) goto _L7; else goto _L6
_L6:
        com.millennialmedia.android.MMLog.b("HandShake", "Handshake expired, requesting new handshake from the server.");
        i = new HandShake(context);
          goto _L7
        context;
        throw context;
    }

    static String a()
    {
        if (!TextUtils.isEmpty(w) && URLUtil.isHttpUrl(w.replace("getAd.php5?", "")))
        {
            return w;
        } else
        {
            return "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
        }
    }

    static WeakReference a(HandShake handshake)
    {
        return handshake.j;
    }

    static void a(HandShake handshake, Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putLong("handshake_deferredviewtimeout", handshake.r);
        context.putBoolean("handshake_kill", handshake.b);
        context.putString("handshake_baseUrl", w);
        context.putLong("handshake_callback", handshake.s);
        context.putBoolean("handshake_hardwareAccelerationEnabled", handshake.d);
        context.putString("handshake_startSessionURL", handshake.e);
        if (handshake.g != null)
        {
            context.putString("handshake_nuanceCredentials", (new b()).a(handshake.g));
        }
        context.putString("handshake_endSessionURL", handshake.u);
        context.putLong("handshake_creativecaetimeout", handshake.c);
        context.putString("handshake_mmjs", handshake.v);
        String s1;
        for (Iterator iterator = handshake.o.keySet().iterator(); iterator.hasNext(); ((AdTypeHandShake)handshake.o.get(s1)).a(context, (String)s1))
        {
            s1 = (String)iterator.next();
        }

        handshake;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
_L2:
        Scheme scheme;
        if (i1 >= handshake.p.size())
        {
            break; /* Loop/switch isn't completed */
        }
        scheme = (Scheme)handshake.p.get(i1);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append(scheme.a).append("\t").append(scheme.b).toString());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        context.putString("handshake_schemes", stringbuilder.toString());
        handshake;
        JVM INSTR monitorexit ;
        if (handshake.y != null)
        {
            context.putString("handshake_cachedvideos5.0", (new b()).a(handshake.y));
        }
        context.putString("handshake_novideostocacheurl", handshake.n);
        context.putLong("handshake_lasthandshake", handshake.m);
        context.commit();
        return;
        context;
        handshake;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(HandShake handshake, JSONObject jsonobject)
    {
        Context context;
        context = (Context)handshake.j.get();
        if (context == null)
        {
            context = (Context)handshake.k.get();
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        MMLog.e("HandShake", "No context for handshake");
_L4:
        return;
_L2:
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        Object obj2;
        int i1;
        try
        {
            obj = jsonobject.optJSONArray("errors");
        }
        // Misplaced declaration of an exception variable
        catch (HandShake handshake)
        {
            MMLog.a("HandShake", "Error deserializing handshake", handshake);
            return;
        }
        if (obj == null) goto _L6; else goto _L5
_L5:
        i1 = 0;
_L23:
        if (i1 >= ((JSONArray) (obj)).length()) goto _L6; else goto _L7
_L7:
        obj2 = ((JSONArray) (obj)).optJSONObject(i1);
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        obj1 = ((JSONObject) (obj2)).optString("message", null);
        obj2 = ((JSONObject) (obj2)).optString("type", null);
        if (obj1 == null || obj2 == null) goto _L9; else goto _L10
_L10:
        if (!((String) (obj2)).equalsIgnoreCase("log")) goto _L12; else goto _L11
_L11:
        MMLog.e("HandShake", ((String) (obj1)));
          goto _L9
_L12:
        if (((String) (obj2)).equalsIgnoreCase("prompt"))
        {
            handshake.l.post(new Runnable(context, ((String) (obj1))) {

                private Context a;
                private String b;

                public void run()
                {
                    try
                    {
                        Toast.makeText(a, (new StringBuilder("Error: ")).append(b).toString(), 1).show();
                        return;
                    }
                    catch (android.view.WindowManager.BadTokenException badtokenexception)
                    {
                        MMLog.a("HandShake", "Error with toast token", badtokenexception);
                    }
                }

            
            {
                a = context;
                b = s1;
                super();
            }
            });
        }
          goto _L9
_L6:
        obj = jsonobject.optJSONObject("adtypes");
        if (obj == null) goto _L14; else goto _L13
_L13:
        String as[] = MMAdImpl.k();
        i1 = 0;
_L24:
        if (i1 >= 2) goto _L14; else goto _L15
_L15:
        Object obj3 = ((JSONObject) (obj)).optJSONObject(as[i1]);
        if (obj3 == null) goto _L17; else goto _L16
_L16:
        obj2 = handshake. new AdTypeHandShake();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        obj2.b = ((JSONObject) (obj3)).optLong("videointerval") * 1000L;
        obj3 = as[i1];
        SharedPreferences sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (sharedpreferences == null)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        if (sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(((String) (obj3))).toString()))
        {
            obj2.a = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(((String) (obj3))).toString(), ((AdTypeHandShake) (obj2)).a);
        }
        handshake.o.put(as[i1], obj2);
          goto _L17
_L14:
        handshake;
        JVM INSTR monitorenter ;
        obj = jsonobject.optJSONArray("schemes");
        if (obj == null) goto _L19; else goto _L18
_L18:
        if (handshake.p.size() > 0)
        {
            handshake.p.removeAll(handshake.p);
        }
          goto _L20
_L25:
        if (i1 >= ((JSONArray) (obj)).length()) goto _L19; else goto _L21
_L21:
        as = ((JSONArray) (obj)).optJSONObject(i1);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        obj2 = new Scheme();
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        obj2.a = as.optString("scheme", null);
        obj2.b = as.optInt("schemeid");
        handshake.p.add(obj2);
        break MISSING_BLOCK_LABEL_873;
_L19:
        handshake;
        JVM INSTR monitorexit ;
        handshake.f = jsonobject.optLong("adrefresh", 0L);
        handshake.r = jsonobject.optLong("deferredviewtimeout", 3600L) * 1000L;
        handshake.b = jsonobject.optBoolean("kill");
        obj = jsonobject.optString("baseURL");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            if (((String) (obj)).endsWith("/"))
            {
                break MISSING_BLOCK_LABEL_789;
            }
            w = (new StringBuilder()).append(((String) (obj))).append("/getAd.php5?").toString();
        }
_L22:
        handshake.s = jsonobject.optLong("handshakecallback", 0x15180L) * 1000L;
        handshake.c = jsonobject.optLong("creativeCacheTimeout", 0x3f480L) * 1000L;
        handshake.d = jsonobject.optBoolean("hardwareAccelerationEnabled");
        handshake.e = jsonobject.optString("startSessionURL");
        handshake.u = jsonobject.optString("endSessionURL");
        obj = jsonobject.optString("nuanceCredentials");
        handshake.g = (NuanceCredentials)(new b()).a(((String) (obj)), com/millennialmedia/android/HandShake$NuanceCredentials);
        handshake.v = jsonobject.optString("mmjs");
        obj = jsonobject.optJSONArray("cachedVideos");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_715;
        }
        handshake.y = (DTOCachedVideo[])(new b()).a(((JSONArray) (obj)).toString(), [Lcom/millennialmedia/android/DTOCachedVideo;);
        com.millennialmedia.android.MMLog.b("HandShake", handshake.y.toString());
        handshake.n = jsonobject.optString("noVideosToCacheURL");
        if (handshake.y != null)
        {
            PreCacheWorker.a(handshake.y, context, handshake.n);
        }
        if (!TextUtils.isEmpty(handshake.v) && !MRaid.d(context, handshake.v))
        {
            com.millennialmedia.android.MRaid.b((Context)handshake.k.get(), handshake.v);
            return;
        }
        break MISSING_BLOCK_LABEL_814;
        jsonobject;
        handshake;
        JVM INSTR monitorexit ;
        throw jsonobject;
        w = (new StringBuilder()).append(((String) (obj))).append("getAd.php5?").toString();
          goto _L22
        MMLog.d("HandShake", (new StringBuilder("Not downloading MMJS - (")).append(handshake.v).append(")").toString());
        return;
_L9:
        i1++;
          goto _L23
_L17:
        i1++;
          goto _L24
_L20:
        i1 = 0;
          goto _L25
        i1++;
          goto _L25
    }

    static String b()
    {
        return h;
    }

    static WeakReference b(HandShake handshake)
    {
        return handshake.k;
    }

    static Runnable c(HandShake handshake)
    {
        return handshake.x;
    }

    static long d(HandShake handshake)
    {
        return handshake.s;
    }

    static boolean d(Context context)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
        }
    }

    static Handler e(HandShake handshake)
    {
        return handshake.l;
    }

    static String e(String s1)
    {
        h = s1;
        return s1;
    }

    static void e(Context context)
    {
        if (context != null)
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            context.putBoolean("firstlaunchHandshake", false);
            context.commit();
        }
    }

    static JSONObject f(String s1)
    {
        return h(s1);
    }

    private boolean f(Context context)
    {
        SharedPreferences sharedpreferences;
        boolean flag;
        boolean flag2;
        flag = false;
        flag2 = false;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        if (sharedpreferences != null) goto _L2; else goto _L1
_L1:
        return flag2;
_L2:
        int i1;
        boolean flag1;
        String as[];
        int j1;
        if (sharedpreferences.contains("handshake_deferredviewtimeout"))
        {
            r = sharedpreferences.getLong("handshake_deferredviewtimeout", r);
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (sharedpreferences.contains("handshake_baseUrl"))
        {
            w = sharedpreferences.getString("handshake_baseUrl", w);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_callback"))
        {
            s = sharedpreferences.getLong("handshake_callback", s);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_hardwareAccelerationEnabled"))
        {
            d = sharedpreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_startSessionURL"))
        {
            e = sharedpreferences.getString("handshake_startSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_endSessionURL"))
        {
            u = sharedpreferences.getString("handshake_endSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_nuanceCredentials"))
        {
            String s1 = sharedpreferences.getString("handshake_nuanceCredentials", "");
            g = (NuanceCredentials)(new b()).a(s1, com/millennialmedia/android/HandShake$NuanceCredentials);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmdid"))
        {
            a(context, sharedpreferences.getString("handshake_mmdid", t), false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_creativecachetimeout"))
        {
            c = sharedpreferences.getLong("handshake_creativecachetimeout", c);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmjs"))
        {
            v = sharedpreferences.getString("handshake_mmjs", v);
            flag1 = true;
        }
        as = MMAdImpl.k();
        j1 = 0;
        while (j1 < 2) 
        {
            Object obj = new AdTypeHandShake();
            String s3 = as[j1];
            String s2;
            String as1[];
            if (sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(s3).toString()))
            {
                obj.a = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(s3).toString(), ((AdTypeHandShake) (obj)).a);
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (sharedpreferences.contains((new StringBuilder("handshake_videointerval_")).append(s3).toString()))
            {
                obj.b = sharedpreferences.getLong((new StringBuilder("handshake_videointerval_")).append(s3).toString(), ((AdTypeHandShake) (obj)).b);
                i1 = 1;
            }
            if (i1 != 0)
            {
                o.put(as[j1], obj);
                flag1 = true;
            }
            j1++;
        }
        this;
        JVM INSTR monitorenter ;
        if (!sharedpreferences.contains("handshake_schemes")) goto _L4; else goto _L3
_L3:
        s2 = sharedpreferences.getString("handshake_schemes", "");
        if (s2.length() <= 0) goto _L4; else goto _L5
_L5:
        s2 = s2.split("\n");
        j1 = s2.length;
        i1 = ((flag) ? 1 : 0);
_L10:
        if (i1 >= j1) goto _L7; else goto _L6
_L6:
        as1 = s2[i1].split("\t");
        if (as1.length >= 2)
        {
            as1 = new Scheme(as1[0], Integer.parseInt(as1[1]));
            p.add(as1);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        this;
        JVM INSTR monitorexit ;
        if (sharedpreferences.contains("handshake_cachedvideos5.0"))
        {
            s2 = sharedpreferences.getString("handshake_cachedvideos5.0", "");
            if (s2.length() > 0)
            {
                y = (DTOCachedVideo[])(new b()).a(s2, [Lcom/millennialmedia/android/DTOCachedVideo;);
            }
        }
        if (sharedpreferences.contains("handshake_lasthandshake"))
        {
            m = sharedpreferences.getLong("handshake_lasthandshake", m);
            flag1 = true;
        }
        flag2 = flag1;
        if (!flag1) goto _L1; else goto _L8
_L8:
        com.millennialmedia.android.MMLog.b("HandShake", "Handshake successfully loaded from shared preferences.");
        if (System.currentTimeMillis() - m < s)
        {
            l.postDelayed(x, s - (System.currentTimeMillis() - m));
        }
        n = sharedpreferences.getString("handshake_novideostocacheurl", "");
        flag2 = flag1;
        if (y == null) goto _L1; else goto _L9
_L9:
        PreCacheWorker.a(y, context, n);
        return flag1;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
          goto _L10
_L7:
        flag1 = true;
          goto _L4
    }

    private static boolean g(String s1)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s1);
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        String s2 = s1;
        if (s1.startsWith("http://"))
        {
            s2 = s1.replaceFirst("http://", "https://");
        }
        h = (new StringBuilder()).append(s2).append("?apid=").toString();
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    private static JSONObject h(String s1)
    {
        com.millennialmedia.android.MMLog.b("HandShake", String.format("JSON String: %s", new Object[] {
            s1
        }));
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s1 = new JSONObject(s1);
        MMLog.a("HandShake", s1.toString());
        if (!s1.has("mmishake"))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s1 = s1.getJSONObject("mmishake");
        return s1;
        s1;
        MMLog.a("HandShake", "Error parsing json", s1);
        return null;
    }

    final void a(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)o.get(s1);
        if (adtypehandshake == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        adtypehandshake.a = System.currentTimeMillis();
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        adtypehandshake.a(context, s1);
        context.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    final void a(Context context, String s1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (s1.length() != 0 && !s1.equals("NULL"))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        t = null;
_L1:
        MMSDK.a(t);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        context.putString("handshake_mmdid", t);
        context.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        t = s1;
          goto _L1
        context;
        throw context;
    }

    final void a(boolean flag)
    {
        Object obj = (Context)j.get();
        if (obj != null)
        {
            obj = ((Context) (obj)).getSharedPreferences("MillennialMediaSettings", 0).getString("handShakeUrl", null);
            if (obj != null)
            {
                g(((String) (obj)));
            }
        }
        Utils.ThreadUtils.a(new Runnable(flag) {

            private boolean a;
            private HandShake b;

            public void run()
            {
                Context context;
                context = (Context)HandShake.a(b).get();
                if (context == null)
                {
                    context = (Context)com.millennialmedia.android.HandShake.b(b).get();
                }
                if (context != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Object obj1;
                StringBuilder stringbuilder;
                boolean flag1;
                stringbuilder = new StringBuilder();
                obj1 = new TreeMap();
                ((Map) (obj1)).put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
                flag1 = HandShake.d(context);
                boolean flag2;
                if (!flag1)
                {
                    break MISSING_BLOCK_LABEL_107;
                }
                flag2 = flag1;
                ((Map) (obj1)).put("firstlaunch", "1");
                flag2 = flag1;
                if (!a)
                {
                    break MISSING_BLOCK_LABEL_133;
                }
                flag2 = flag1;
                ((Map) (obj1)).put("init", "1");
                flag2 = flag1;
                MMSDK.a(context, ((Map) (obj1)));
                flag2 = flag1;
                obj1 = ((Map) (obj1)).entrySet().iterator();
_L4:
                flag2 = flag1;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                flag2 = flag1;
                Object obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                flag2 = flag1;
                stringbuilder.append(String.format("&%s=%s", new Object[] {
                    ((java.util.Map.Entry) (obj2)).getKey(), URLEncoder.encode((String)((java.util.Map.Entry) (obj2)).getValue(), "UTF-8")
                }));
                if (true) goto _L4; else goto _L3
                obj1;
_L17:
                flag2 = flag1;
                MMLog.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
                return;
                obj1;
_L15:
                if (flag2)
                {
                    HandShake.e(context);
                }
                throw obj1;
_L3:
                flag2 = flag1;
                obj2 = (new StringBuilder()).append(com.millennialmedia.android.HandShake.b()).append(HandShake.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                MMLog.a("HandShake", String.format("Performing handshake: %s", new Object[] {
                    obj2
                }));
                obj1 = null;
                flag2 = flag1;
                obj2 = (new HttpGetRequest((byte)0)).a(((String) (obj2)));
                obj1 = obj2;
_L11:
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_368;
                }
                flag2 = flag1;
                int i1 = ((HttpResponse) (obj1)).getStatusLine().getStatusCode();
                obj2 = obj1;
                if (i1 == 200)
                {
                    break MISSING_BLOCK_LABEL_459;
                }
                flag2 = flag1;
                HandShake.e(com.millennialmedia.android.HandShake.b().replaceFirst("https://", "http://"));
                flag2 = flag1;
                obj2 = (new StringBuilder()).append(com.millennialmedia.android.HandShake.b()).append(HandShake.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                MMLog.a("HandShake", String.format("Performing handshake (HTTP Fallback): %s", new Object[] {
                    obj2
                }));
                flag2 = flag1;
                obj2 = (new HttpGetRequest()).a(((String) (obj2)));
_L12:
                if (obj2 == null) goto _L6; else goto _L5
_L5:
                flag2 = flag1;
                i1 = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
                if (i1 == 200) goto _L7; else goto _L6
_L6:
                flag2 = flag1;
                obj1 = (new StringBuilder("http://ads.mp.mydas.mobi/appConfigServlet?apid=")).append(HandShake.a).append(stringbuilder.toString()).toString();
                flag2 = flag1;
                MMLog.a("HandShake", (new StringBuilder("Performing handshake (HTTP Fallback Original): ")).append(((String) (obj1))).toString());
                flag2 = flag1;
                obj1 = (new HttpGetRequest()).a(((String) (obj1)));
_L13:
                if (obj1 == null) goto _L9; else goto _L8
_L8:
                flag2 = flag1;
                if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200) goto _L9; else goto _L10
_L10:
                flag2 = flag1;
                HandShake.a(b, HandShake.f(HttpGetRequest.a(((HttpResponse) (obj1)).getEntity().getContent())));
                flag2 = flag1;
                HandShake.a(b, context);
                flag2 = flag1;
                HandShake.e(b).postDelayed(HandShake.c(b), HandShake.d(b));
                flag2 = flag1;
                MMLog.a("HandShake", "Obtained a new handshake");
_L14:
                if (flag1)
                {
                    HandShake.e(context);
                    return;
                }
                  goto _L1
                obj2;
                flag2 = flag1;
                MMLog.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj2)));
                  goto _L11
                obj1;
_L16:
                flag2 = flag1;
                MMLog.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
                return;
                obj2;
                flag2 = flag1;
                MMLog.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj2)));
                obj2 = obj1;
                  goto _L12
                obj1;
                flag2 = flag1;
                MMLog.a("HandShake", "Could not get a handshake. ", ((Throwable) (obj1)));
_L7:
                obj1 = obj2;
                  goto _L13
_L9:
                flag1 = false;
                  goto _L14
                obj1;
                flag2 = false;
                  goto _L15
                obj1;
                flag1 = false;
                  goto _L16
                obj1;
                flag1 = false;
                  goto _L17
            }

            
            {
                b = HandShake.this;
                a = flag;
                super();
            }
        });
    }

    final boolean a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (AdTypeHandShake)o.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        long l1;
        long l2;
        long l3;
        l1 = System.currentTimeMillis();
        com.millennialmedia.android.MMLog.b("HandShake", (new StringBuilder("canRequestVideo() Current Time:")).append(l1).append(" Last Video: ").append(((AdTypeHandShake) (s1)).a / 1000L).append("  Diff: ").append((l1 - ((AdTypeHandShake) (s1)).a) / 1000L).append("  Video interval: ").append(((AdTypeHandShake) (s1)).b / 1000L).toString());
        l1 = System.currentTimeMillis();
        l2 = ((AdTypeHandShake) (s1)).a;
        l3 = ((AdTypeHandShake) (s1)).b;
        boolean flag;
        if (l1 - l2 > l3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final boolean a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (AdTypeHandShake)o.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        long l2;
        long l3;
        l2 = System.currentTimeMillis();
        l3 = ((AdTypeHandShake) (s1)).d.r;
        boolean flag;
        if (l2 - l1 < l3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final String b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator;
        if (q != null || p.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        stringbuilder = new StringBuilder();
        iterator = p.iterator();
_L1:
        Scheme scheme;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_121;
                }
                scheme = (Scheme)iterator.next();
            } while (!scheme.a(context));
            if (stringbuilder.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            stringbuilder.append((new StringBuilder(",")).append(scheme.b).toString());
        } while (true);
        context;
        throw context;
        stringbuilder.append(Integer.toString(scheme.b));
          goto _L1
        if (stringbuilder.length() > 0)
        {
            q = stringbuilder.toString();
        }
        context = q;
        this;
        JVM INSTR monitorexit ;
        return context;
    }

    final boolean b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (AdTypeHandShake)o.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        boolean flag = ((AdTypeHandShake) (s1)).c;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    final JSONArray c(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        jsonarray = new JSONArray();
        if (p.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        iterator = p.iterator();
_L1:
        Scheme scheme;
        boolean flag;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_128;
            }
            scheme = (Scheme)iterator.next();
            flag = scheme.a(context);
        } while (!flag);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("scheme", scheme.a);
        jsonobject.put("schemeid", scheme.b);
        jsonarray.put(jsonobject);
          goto _L1
        JSONException jsonexception;
        jsonexception;
        MMLog.a("HandShake", "Json error getting scheme", jsonexception);
          goto _L1
        context;
        throw context;
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
    }

    final void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (AdTypeHandShake)o.get(s1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s1.c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    final void d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (AdTypeHandShake)o.get(s1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s1.c = false;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }


    private class AdTypeHandShake
    {

        long a;
        long b;
        boolean c;
        final HandShake d;

        final void a(android.content.SharedPreferences.Editor editor, String s1)
        {
            editor.putLong((new StringBuilder("handshake_lastvideo_")).append(s1).toString(), a);
            editor.putLong((new StringBuilder("handshake_videointerval_")).append(s1).toString(), b);
        }

        AdTypeHandShake()
        {
            d = HandShake.this;
            super();
            a = 0L;
            b = 0L;
        }
    }


    private class Scheme
    {

        String a;
        int b;

        final boolean a(Context context)
        {
            Intent intent;
            if (a.contains("://"))
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(a).append("://").toString()));
            }
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        }

        Scheme()
        {
        }

        Scheme(String s1, int i1)
        {
            a = s1;
            b = i1;
        }
    }


    private class NuanceCredentials
    {

        public String toString()
        {
            return (new StringBuilder("Credentials: appid=")).append(null).append(" server=").append(null).append(" port=0 appKey=").append(null).append("sessionID=").append(null).toString();
        }

        private NuanceCredentials()
        {
        }
    }

}
