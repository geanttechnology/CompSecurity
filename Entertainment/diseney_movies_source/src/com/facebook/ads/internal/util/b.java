// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class com.facebook.ads.internal.util.b
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a g[];
        int f;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/ads/internal/util/b$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("OPEN_STORE", 0, 0);
            b = new a("OPEN_LINK", 1, 1);
            c = new a("XOUT", 2, 2);
            d = new a("OPEN_URL", 3, 3);
            e = new a("SHOW_INTERSTITIAL", 4, 4);
            g = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            f = j;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        private static final b c[];
        int b;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/facebook/ads/internal/util/b$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("LOADING_AD", 0, 0);
            c = (new b[] {
                a
            });
        }

        private b(String s, int i, int j)
        {
            super(s, i);
            b = j;
        }
    }


    public static String a = null;
    private String b;
    private Map c;
    private int d;
    private String e;

    public com.facebook.ads.internal.util.b(String s, Map map, int i, String s1)
    {
        b = s;
        c = map;
        d = i;
        e = s1;
    }

    public static com.facebook.ads.internal.util.b a(long l, a a1, String s)
    {
        long l1 = System.currentTimeMillis();
        HashMap hashmap = new HashMap();
        hashmap.put("Time", String.valueOf(l1 - l));
        hashmap.put("AdAction", String.valueOf(a1.f));
        return new com.facebook.ads.internal.util.b("bounceback", hashmap, (int)(l1 / 1000L), s);
    }

    public static com.facebook.ads.internal.util.b a(b b1, AdPlacementType adplacementtype, long l, String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("LatencyType", String.valueOf(b1.b));
        hashmap.put("AdPlacementType", adplacementtype.toString());
        hashmap.put("Time", String.valueOf(l));
        int i = (int)(System.currentTimeMillis() / 1000L);
        if (s == null)
        {
            s = a;
        }
        return new com.facebook.ads.internal.util.b("latency", hashmap, i, s);
    }

    public static com.facebook.ads.internal.util.b a(Throwable throwable, String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("ex", throwable.getClass().getSimpleName());
        hashmap.put("ex_msg", throwable.getMessage());
        int i = (int)(System.currentTimeMillis() / 1000L);
        if (s == null)
        {
            s = a;
        }
        return new com.facebook.ads.internal.util.b("error", hashmap, i, s);
    }

    public JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("name", b);
            jsonobject.put("data", new JSONObject(c));
            jsonobject.put("time", d);
            jsonobject.put("request_id", e);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

}
