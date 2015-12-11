// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import android.util.Log;
import b.b.a.a.a.a.e;
import com.smule.android.f.f;
import com.smule.android.network.core.b;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.android.network.a:
//            n, m, l

public class k
{

    private static String a = com/smule/android/network/a/k.getName();

    public k()
    {
    }

    public static o a(com.smule.android.network.a.n n1, Integer integer, Integer integer1)
    {
        return a(n1, integer, integer1, null, null, null, null);
    }

    public static o a(com.smule.android.network.a.n n1, Integer integer, Integer integer1, com.smule.android.network.a.l l1, com.smule.android.network.a.m m1, String s, String s1)
    {
        return a(n1, integer, integer1, l1, m1, s, null, s1, false);
    }

    public static o a(com.smule.android.network.a.n n1, Integer integer, Integer integer1, com.smule.android.network.a.l l1, com.smule.android.network.a.m m1, String s, String s1, String s2, 
            boolean flag)
    {
        com.smule.android.network.core.k k1 = b("/v2/performance/list");
        k1.d = new HashMap();
        Map map = k1.d;
        if (s1 == null)
        {
            s1 = com.smule.android.network.core.b.b();
        }
        map.put("app", s1);
        if (n1 != null)
        {
            k1.d.put("sort", n1.toString());
        } else
        {
            k1.d.put("sort", n.a.toString());
        }
        if (integer != null)
        {
            k1.d.put("offset", integer);
        } else
        {
            k1.d.put("offset", Integer.valueOf(0));
        }
        if (integer1 != null)
        {
            k1.d.put("limit", integer1);
        } else
        {
            k1.d.put("limit", Integer.valueOf(25));
        }
        integer = k1.d;
        if (l1 == null)
        {
            n1 = "FILLED";
        } else
        {
            n1 = l1.toString();
        }
        integer.put("fillStatus", n1);
        if (m1 != null)
        {
            k1.d.put("hotType", m1.toString());
        }
        if (s != null)
        {
            if (flag)
            {
                k1.d.put("arrKey", s);
            } else
            {
                k1.d.put("songUid", s);
            }
        }
        if (s2 != null)
        {
            k1.d.put("mixApp", s2);
        }
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(String s)
    {
        com.smule.android.network.core.k k1 = b("/v2/performance/play");
        k1.d = new HashMap();
        k1.d.put("performanceKey", s);
        k1.f = true;
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(String s, float f1, float f2)
    {
        Log.i(a, (new StringBuilder()).append("Adding a love for performance ").append(s).toString());
        com.smule.android.network.core.k k1 = b("/v2/performance/love");
        k1.d = new HashMap();
        k1.d.put("performanceKey", s);
        if (f.a(f1, f2))
        {
            k1.d.put("latitude", Float.valueOf(f1));
            k1.d.put("longitude", Float.valueOf(f2));
        }
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(String s, String s1, String s2, String s3, Long long1, Boolean boolean1, float f1, float f2, 
            String s4, Map map, Integer integer)
    {
        Log.i(a, (new StringBuilder()).append("Creating performance for song ").append(s1).toString());
        com.smule.android.network.core.k k1 = b("/v2/performance/create");
        k1.d = new HashMap();
        k1.d.put("songUid", s1);
        k1.d.put("title", s2);
        s2 = k1.d;
        s1 = s3;
        if (s3 == null)
        {
            s1 = "";
        }
        s2.put("message", s1);
        if (long1 != null && long1.longValue() > 0L)
        {
            k1.d.put("seconds", String.valueOf(long1));
        }
        if (boolean1 != null)
        {
            k1.d.put("isPrivate", String.valueOf(boolean1));
        }
        if (f.a(f1, f2))
        {
            k1.d.put("latitude", Float.valueOf(f1));
            k1.d.put("longitude", Float.valueOf(f2));
        }
        k1.d.put("ensembleType", s4);
        if (map != null)
        {
            k1.d.put("trackOptions", map);
        }
        if (integer != null)
        {
            k1.a(integer.intValue());
        }
        s = new e(new File(s), s, "application/octet-stream", "UTF-8");
        s1 = new HashMap();
        s1.put("track", s);
        k1.j = s1;
        return com.smule.android.network.core.b.a().a(k1);
    }

    private static com.smule.android.network.core.k b(String s)
    {
        return new com.smule.android.network.core.k(m.a, s, l.b, n.c, null, true);
    }

    public static o b(String s, float f1, float f2)
    {
        com.smule.android.network.core.k k1 = b("/v2/performance/listen");
        k1.d = new HashMap();
        k1.d.put("performanceKey", s);
        if (f.a(f1, f2))
        {
            k1.d.put("latitude", Float.valueOf(f1));
            k1.d.put("longitude", Float.valueOf(f2));
        }
        return com.smule.android.network.core.b.a().a(k1);
    }

}
