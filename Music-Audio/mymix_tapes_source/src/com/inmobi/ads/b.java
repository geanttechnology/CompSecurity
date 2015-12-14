// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.graphics.Color;
import com.inmobi.commons.core.configs.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class com.inmobi.ads.b extends com.inmobi.commons.core.configs.a
{
    static final class a
    {

        private int a;
        private int b;
        private int c;
        private long d;

        static int a(a a1)
        {
            return a1.a;
        }

        static int a(a a1, int i1)
        {
            a1.a = i1;
            return i1;
        }

        static long a(a a1, long l1)
        {
            a1.d = l1;
            return l1;
        }

        static int b(a a1)
        {
            return a1.b;
        }

        static int b(a a1, int i1)
        {
            a1.b = i1;
            return i1;
        }

        static int c(a a1)
        {
            return a1.c;
        }

        static int c(a a1, int i1)
        {
            a1.c = i1;
            return i1;
        }

        static long d(a a1)
        {
            return a1.d;
        }

        public boolean a()
        {
            return b > 0 && a >= 0 && c >= 0 && d >= 0L;
        }

        public int b()
        {
            return a;
        }

        public int c()
        {
            return b;
        }

        public int d()
        {
            return c;
        }

        public long e()
        {
            return d;
        }

        a()
        {
        }
    }

    public static final class b
    {

        private int a;
        private int b;
        private int c;
        private int d;
        private int e;

        static int a(b b1, int i1)
        {
            b1.a = i1;
            return i1;
        }

        static int b(b b1, int i1)
        {
            b1.b = i1;
            return i1;
        }

        static int c(b b1, int i1)
        {
            b1.c = i1;
            return i1;
        }

        static int d(b b1, int i1)
        {
            b1.d = i1;
            return i1;
        }

        static int e(b b1, int i1)
        {
            b1.e = i1;
            return i1;
        }

        public int a()
        {
            return a;
        }

        public int b()
        {
            return b;
        }

        public int c()
        {
            return c;
        }

        public int d()
        {
            return d;
        }

        public int e()
        {
            return e;
        }

        public b()
        {
            a = 3;
            b = 60;
            c = 120;
            d = 500;
            e = 10;
        }
    }

    public static final class c
    {

        private long a;
        private int b;
        private int c;
        private String d;

        static int a(c c1, int i1)
        {
            c1.b = i1;
            return i1;
        }

        static long a(c c1, long l1)
        {
            c1.a = l1;
            return l1;
        }

        static String a(c c1, String s)
        {
            c1.d = s;
            return s;
        }

        static int b(c c1, int i1)
        {
            c1.c = i1;
            return i1;
        }

        public long a()
        {
            return a;
        }

        public int b()
        {
            return b;
        }

        public int c()
        {
            return c;
        }

        public String d()
        {
            return d;
        }

        public c()
        {
            a = 0x69780L;
            b = 3;
            c = 60;
            d = "https://inmobisdk-a.akamaihd.net/sdk/500/android/mraid.js";
        }
    }

    public static final class d
    {

        private boolean a;
        private long b;
        private int c;

        static int a(d d1, int i1)
        {
            d1.c = i1;
            return i1;
        }

        static long a(d d1)
        {
            return d1.b;
        }

        static long a(d d1, long l1)
        {
            d1.b = l1;
            return l1;
        }

        static boolean a(d d1, boolean flag)
        {
            d1.a = flag;
            return flag;
        }

        static int b(d d1)
        {
            return d1.c;
        }

        public long a()
        {
            return b;
        }

        public boolean b()
        {
            return a;
        }

        public int c()
        {
            return c;
        }

        public d()
        {
            a = false;
            b = 0x3f480L;
            c = 5;
        }
    }

    public static final class e
    {

        private int a;
        private int b;
        private int c;
        private int d;
        private String e;
        private int f;
        private int g;
        private int h;
        private long i;
        private ArrayList j;

        static int a(e e1, int i1)
        {
            e1.a = i1;
            return i1;
        }

        static long a(e e1, long l1)
        {
            e1.i = l1;
            return l1;
        }

        static String a(e e1, String s)
        {
            e1.e = s;
            return s;
        }

        static ArrayList a(e e1)
        {
            return e1.j;
        }

        static int b(e e1, int i1)
        {
            e1.c = i1;
            return i1;
        }

        static String b(e e1)
        {
            return e1.e;
        }

        static int c(e e1, int i1)
        {
            e1.b = i1;
            return i1;
        }

        static int d(e e1, int i1)
        {
            e1.d = i1;
            return i1;
        }

        static int e(e e1, int i1)
        {
            e1.g = i1;
            return i1;
        }

        static int f(e e1, int i1)
        {
            e1.h = i1;
            return i1;
        }

        static int g(e e1, int i1)
        {
            e1.f = i1;
            return i1;
        }

        public int a()
        {
            return b;
        }

        public int b()
        {
            return c;
        }

        public int c()
        {
            return d;
        }

        public int d()
        {
            return f;
        }

        public int e()
        {
            return g;
        }

        public int f()
        {
            return h;
        }

        public long g()
        {
            return i;
        }

        public ArrayList h()
        {
            return j;
        }

        public int i()
        {
            return a;
        }

        public e()
        {
            a = 60;
            b = 320;
            c = 480;
            d = 100;
            e = "#00000000";
            f = Color.parseColor("#00000000");
            g = 5;
            h = 20;
            i = 0x500000L;
            j = new ArrayList(Arrays.asList(new String[] {
                "video/mp4"
            }));
        }
    }

    public static final class f
    {

        private int a;
        private int b;
        private int c;
        private int d;

        static int a(f f1, int i1)
        {
            f1.a = i1;
            return i1;
        }

        static int b(f f1, int i1)
        {
            f1.b = i1;
            return i1;
        }

        static int c(f f1, int i1)
        {
            f1.c = i1;
            return i1;
        }

        static int d(f f1, int i1)
        {
            f1.d = i1;
            return i1;
        }

        public int a()
        {
            return a;
        }

        public int b()
        {
            return b;
        }

        public int c()
        {
            return c;
        }

        public int d()
        {
            return d;
        }

        public f()
        {
            a = 50;
            b = 1000;
            c = 100;
            d = 250;
        }
    }


    private static final String a = com/inmobi/ads/b.getSimpleName();
    private static final String b = "http://i.w.inmobi.com/showad.asm";
    private String c;
    private int d;
    private int e;
    private int f;
    private a g;
    private Map h;
    private b i;
    private e j;
    private c k;
    private f l;
    private JSONObject m;
    private d n;

    public com.inmobi.ads.b()
    {
        c = b;
        d = 20;
        e = 60;
        f = 60;
        i = new b();
        j = new e();
        k = new c();
        l = new f();
        n = new d();
        try
        {
            b(p());
            m = q();
            return;
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Default config provided for ads is invalid.", jsonexception);
        }
    }

    private void b(JSONObject jsonobject)
        throws JSONException
    {
        Object obj = jsonobject.getJSONObject("base");
        g = new a();
        com.inmobi.ads.a.a(g, ((JSONObject) (obj)).getInt("maxCacheSize"));
        a.b(g, ((JSONObject) (obj)).getInt("fetchLimit"));
        a.c(g, ((JSONObject) (obj)).getInt("minThreshold"));
        com.inmobi.ads.a.a(g, ((JSONObject) (obj)).getLong("timeToLive"));
        jsonobject.remove("base");
        h = new HashMap();
        obj = jsonobject.keys();
        while (((Iterator) (obj)).hasNext()) 
        {
            String s = (String)((Iterator) (obj)).next();
            JSONObject jsonobject1 = jsonobject.getJSONObject(s);
            a a1 = new a();
            int i1;
            long l1;
            if (jsonobject1.has("maxCacheSize"))
            {
                i1 = jsonobject1.getInt("maxCacheSize");
            } else
            {
                i1 = com.inmobi.ads.a.a(g);
            }
            com.inmobi.ads.a.a(a1, i1);
            if (jsonobject1.has("fetchLimit"))
            {
                i1 = jsonobject1.getInt("fetchLimit");
            } else
            {
                i1 = a.b(g);
            }
            a.b(a1, i1);
            if (jsonobject1.has("minThreshold"))
            {
                i1 = jsonobject1.getInt("minThreshold");
            } else
            {
                i1 = a.c(g);
            }
            a.c(a1, i1);
            if (jsonobject1.has("timeToLive"))
            {
                l1 = jsonobject1.getInt("timeToLive");
            } else
            {
                l1 = a.d(g);
            }
            com.inmobi.ads.a.a(a1, l1);
            h.put(s, a1);
        }
    }

    private JSONObject p()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("maxCacheSize", 0);
        jsonobject1.put("fetchLimit", 1);
        jsonobject1.put("minThreshold", 0);
        jsonobject1.put("timeToLive", 3300);
        jsonobject.put("base", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("maxCacheSize", 100);
        jsonobject1.put("fetchLimit", 5);
        jsonobject1.put("minThreshold", 2);
        jsonobject1.put("timeToLive", 3300);
        jsonobject.put("native", jsonobject1);
        return jsonobject;
    }

    private JSONObject q()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("enabled", false);
        jsonobject.put("samplingFactor", 0);
        jsonobject.put("metricEnabled", false);
        return jsonobject;
    }

    private JSONObject r()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("maxCacheSize", g.b());
        jsonobject1.put("fetchLimit", g.c());
        jsonobject1.put("minThreshold", g.d());
        jsonobject1.put("timeToLive", g.e());
        jsonobject.put("base", jsonobject1);
        java.util.Map.Entry entry;
        JSONObject jsonobject2;
        for (Iterator iterator = h.entrySet().iterator(); iterator.hasNext(); jsonobject.put((String)entry.getKey(), jsonobject2))
        {
            entry = (java.util.Map.Entry)iterator.next();
            jsonobject2 = new JSONObject();
            a a1 = (a)entry.getValue();
            jsonobject2.put("maxCacheSize", a1.b());
            jsonobject2.put("fetchLimit", a1.c());
            jsonobject2.put("minThreshold", a1.d());
            jsonobject2.put("timeToLive", a1.e());
        }

        return jsonobject;
    }

    public a a(String s)
    {
        a a1 = (a)h.get(s);
        s = a1;
        if (a1 == null)
        {
            s = g;
        }
        return s;
    }

    public String a()
    {
        return "ads";
    }

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        super.a(jsonobject);
        if (jsonobject.has("url"))
        {
            c = jsonobject.getString("url");
        }
        d = jsonobject.getInt("minimumRefreshInterval");
        e = jsonobject.getInt("defaultRefreshInterval");
        f = jsonobject.getInt("fetchTimeout");
        b(jsonobject.getJSONObject("cache"));
        Object obj = jsonobject.getJSONObject("imai");
        com.inmobi.ads.b.a(i, ((JSONObject) (obj)).getInt("maxRetries"));
        b.b(i, ((JSONObject) (obj)).getInt("pingInterval"));
        b.c(i, ((JSONObject) (obj)).getInt("pingTimeout"));
        b.d(i, ((JSONObject) (obj)).getInt("maxDbEvents"));
        b.e(i, ((JSONObject) (obj)).getInt("maxEventBatch"));
        obj = jsonobject.getJSONObject("rendering");
        com.inmobi.ads.e.a(j, ((JSONObject) (obj)).getInt("renderTimeout"));
        e.b(j, ((JSONObject) (obj)).getInt("picHeight"));
        e.c(j, ((JSONObject) (obj)).getInt("picWidth"));
        e.d(j, ((JSONObject) (obj)).getInt("picQuality"));
        com.inmobi.ads.e.a(j, ((JSONObject) (obj)).getString("webviewBackground"));
        e.e(j, ((JSONObject) (obj)).getInt("maxVibrationDuration"));
        e.f(j, ((JSONObject) (obj)).getInt("maxVibrationPatternLength"));
        com.inmobi.ads.e.a(j, ((JSONObject) (obj)).getJSONObject("savecontent").getInt("maxSaveSize"));
        obj = ((JSONObject) (obj)).getJSONObject("savecontent").getJSONArray("allowedContentType");
        for (int i1 = 0; i1 < ((JSONArray) (obj)).length(); i1++)
        {
            com.inmobi.ads.e.a(j).add(((JSONArray) (obj)).getString(i1));
        }

        obj = jsonobject.getJSONObject("mraid");
        com.inmobi.ads.c.a(k, ((JSONObject) (obj)).getLong("expiry"));
        com.inmobi.ads.c.a(k, ((JSONObject) (obj)).getInt("maxRetries"));
        c.b(k, ((JSONObject) (obj)).getInt("retryInterval"));
        com.inmobi.ads.c.a(k, ((JSONObject) (obj)).getString("url"));
        if (jsonobject.has("telemetry"))
        {
            m = jsonobject.getJSONObject("telemetry");
        }
        obj = jsonobject.getJSONObject("viewability");
        com.inmobi.ads.f.a(l, ((JSONObject) (obj)).getInt("impressionMinPercentageViewed"));
        f.b(l, ((JSONObject) (obj)).getInt("impressionMinTimeViewed"));
        f.c(l, ((JSONObject) (obj)).optInt("visibilityThrottleMillis", 100));
        f.d(l, ((JSONObject) (obj)).optInt("impressionPollIntervalMillis", 250));
        jsonobject = jsonobject.getJSONObject("preload").getJSONObject("base");
        com.inmobi.ads.d.a(n, jsonobject.getBoolean("enabled"));
        com.inmobi.ads.d.a(n, jsonobject.getLong("placementExpiry"));
        com.inmobi.ads.d.a(n, jsonobject.getInt("maxPreloadedAds"));
    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = super.b();
        jsonobject.put("url", c);
        jsonobject.put("minimumRefreshInterval", d);
        jsonobject.put("defaultRefreshInterval", e);
        jsonobject.put("fetchTimeout", f);
        jsonobject.put("cache", r());
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("maxRetries", i.a());
        jsonobject1.put("pingInterval", i.b());
        jsonobject1.put("pingTimeout", i.c());
        jsonobject1.put("maxDbEvents", i.d());
        jsonobject1.put("maxEventBatch", i.e());
        jsonobject.put("imai", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("renderTimeout", j.i());
        jsonobject1.put("picWidth", j.a());
        jsonobject1.put("picHeight", j.b());
        jsonobject1.put("picQuality", j.c());
        jsonobject1.put("webviewBackground", e.b(j));
        jsonobject1.put("maxVibrationDuration", j.e());
        jsonobject1.put("maxVibrationPatternLength", j.f());
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.put("maxSaveSize", j.g());
        jsonobject2.put("allowedContentType", new JSONArray(j.h()));
        jsonobject1.put("savecontent", jsonobject2);
        jsonobject.put("rendering", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("expiry", k.a());
        jsonobject1.put("maxRetries", k.b());
        jsonobject1.put("retryInterval", k.c());
        jsonobject1.put("url", k.d());
        jsonobject.put("mraid", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject1.put("impressionMinPercentageViewed", l.a());
        jsonobject1.put("impressionMinTimeViewed", l.b());
        jsonobject1.put("visibilityThrottleMillis", l.c());
        jsonobject1.put("impressionPollIntervalMillis", l.d());
        jsonobject.put("viewability", jsonobject1);
        jsonobject1 = new JSONObject();
        jsonobject2 = new JSONObject();
        jsonobject2.put("enabled", n.b());
        jsonobject2.put("placementExpiry", n.a());
        jsonobject2.put("maxPreloadedAds", n.c());
        jsonobject1.put("base", jsonobject2);
        jsonobject.put("preload", jsonobject1);
        if (m != null)
        {
            jsonobject.put("telemetry", m);
        }
        return jsonobject;
    }

    public boolean c()
    {
        if (!c.startsWith("http://") && !c.startsWith("https://") || d < 0 || e < 0 || f <= 0)
        {
            return false;
        }
        if (g == null || !g.a())
        {
            return false;
        }
        for (Iterator iterator = h.entrySet().iterator(); iterator.hasNext();)
        {
            if (!((a)((java.util.Map.Entry)iterator.next()).getValue()).a())
            {
                return false;
            }
        }

        if (i.d() < 0 || i.e() < 0 || i.a() < 0 || i.b() < 0 || i.c() <= 0)
        {
            return false;
        }
        if (k.a() < 0L || k.c() < 0 || k.b() < 0 || !k.d().startsWith("http://") && !k.d().startsWith("https://"))
        {
            return false;
        }
        if (j.i() < 0 || j.b() < 0 || j.a() < 0 || j.c() < 0 || j.e() < 0 || j.f() < 0 || j.g() < 0L || e.b(j) == null || e.b(j).trim().length() == 0)
        {
            return false;
        }
        try
        {
            e.g(j, Color.parseColor(e.b(j)));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Webview color specified in config is invalid.", illegalargumentexception);
            return false;
        }
        if (k.b() < 0 || k.c() < 0 || k.d() == null || k.d().trim().length() == 0)
        {
            return false;
        }
        if (l.a() <= 0 || l.a() > 100 || l.b() < 0 || l.c() < 50 || l.c() * 5 > l.b() || l.d() < 50 || l.d() * 4 > l.b())
        {
            return false;
        }
        return com.inmobi.ads.d.a(n) >= 0L && d.b(n) > 0;
    }

    public com.inmobi.commons.core.configs.a d()
    {
        return new com.inmobi.ads.b();
    }

    public String e()
    {
        return c;
    }

    public int f()
    {
        return d;
    }

    public int g()
    {
        return e;
    }

    public int h()
    {
        return f;
    }

    public b i()
    {
        return i;
    }

    public e j()
    {
        return j;
    }

    public c k()
    {
        return k;
    }

    public f l()
    {
        return l;
    }

    public JSONObject m()
    {
        return m;
    }

    public d n()
    {
        return n;
    }

    static 
    {
        if (!"production".equals("staging"));
    }
}
