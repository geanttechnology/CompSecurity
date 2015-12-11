// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.android.network.a:
//            v, u

public class t
{

    protected static t a = null;

    private t()
    {
    }

    public static t a()
    {
        if (a == null)
        {
            a = new t();
        }
        return a;
    }

    public static o a(String s, String s1, String s2, Integer integer, v v1, u u1, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("productId", s);
        hashmap.put("type", v1.d);
        hashmap.put("productType", u1.name());
        if (s3 != null)
        {
            hashmap.put("seedPerformanceKey", s3);
        }
        if (s1 != null)
        {
            hashmap.put("songId", s1);
        }
        if (v1 == com.smule.android.network.a.v.b)
        {
            s = new HashMap();
            s.put("currencyUid", s2);
            s.put("price", integer);
            hashmap.put("currencyPrice", s);
        }
        s = new k(m.a, "/v2/store/stream/log", l.b, n.c, hashmap, true);
        return com.smule.android.network.core.b.a().a(s);
    }

    private o a(String s, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s1, s2);
        s = new k(m.a, s, l.b, n.c, hashmap, true);
        if (s3 != null)
        {
            s.e = new HashMap();
            ((k) (s)).e.put("If-None-Match", s3);
        }
        s = com.smule.android.network.core.b.a().a(s);
        if (((o) (s)).b != 0)
        {
            com.smule.android.network.core.b.a(s);
        }
        return s;
    }

    public o a(String s, String s1)
    {
        return a("/v2/store/store", "storeId", s, s1);
    }

    public o b(String s, String s1)
    {
        return a("/v2/store/song", "songId", s, s1);
    }

}
