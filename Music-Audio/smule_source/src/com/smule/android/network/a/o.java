// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class o
{

    private static final String a = com/smule/android/network/a/o.getName();
    private static o b;

    private o()
    {
    }

    private int a(com.smule.android.network.core.o o1)
    {
        switch (o1.b)
        {
        default:
            com.smule.android.network.core.b.a(o1);
            return 7;

        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 1;

        case 1001: 
            return 2;

        case 1002: 
            return 3;

        case 1003: 
            return 4;

        case 1004: 
            return 5;

        case 1005: 
            return 6;
        }
    }

    public static o a()
    {
        com/smule/android/network/a/o;
        JVM INSTR monitorenter ;
        o o1;
        if (b == null)
        {
            b = new o();
        }
        o1 = b;
        com/smule/android/network/a/o;
        JVM INSTR monitorexit ;
        return o1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.smule.android.network.core.o a(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("productType", "SONG");
        hashmap.put("productId", s);
        s = new k(m.a, "/v2/store/product/reward", l.b, n.c, hashmap, true);
        return com.smule.android.network.core.b.a().a(s);
    }

    private boolean a(Map map)
    {
        map = new k(m.b, "/v2/store/product/purchase", l.b, n.c, map, true);
        map = com.smule.android.network.core.b.a().a(map);
        if (((com.smule.android.network.core.o) (map)).b != 0)
        {
            com.smule.android.network.core.b.a(map);
            return false;
        } else
        {
            map = ((com.smule.android.network.core.o) (map)).h;
            aa.a(a, map);
            return true;
        }
    }

    public int a(boolean flag, String s, String s1)
    {
        if (flag)
        {
            Object obj = new HashMap();
            ((Map) (obj)).put("listingId", (new StringBuilder()).append("").append(s1).toString());
            ((Map) (obj)).put("productId", (new StringBuilder()).append("").append(s).toString());
            s1 = new k(m.a, "/v2/store/product/acquire_free", l.b, n.c, ((Map) (obj)), true);
            s1 = com.smule.android.network.core.b.a().a(s1);
            obj = a;
            if (((com.smule.android.network.core.o) (s1)).h == null)
            {
                s = (new StringBuilder()).append("Failed to claim song: ").append(s).toString();
            } else
            {
                s = ((com.smule.android.network.core.o) (s1)).h;
            }
            aa.c(((String) (obj)), s);
            return a(((com.smule.android.network.core.o) (s1)));
        }
        HashMap hashmap = new HashMap();
        hashmap.put("listingId", (new StringBuilder()).append("").append(s1).toString());
        hashmap.put("productId", (new StringBuilder()).append("").append(s).toString());
        s = new k(m.a, "/v2/store/product/acquire", l.b, n.c, hashmap, true);
        s = com.smule.android.network.core.b.a().a(s);
        if (((com.smule.android.network.core.o) (s)).h != null)
        {
            aa.c(a, ((com.smule.android.network.core.o) (s)).h);
        }
        return a(((com.smule.android.network.core.o) (s)));
    }

    public boolean a(String s, String s1, long l1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("market", "Google Play");
        hashmap.put("data", s2);
        hashmap.put("signature", s3);
        s3 = (new JSONObject(hashmap)).toString();
        s2 = new HashMap();
        s2.put("productId", s);
        s2.put("orderId", s1);
        s2.put("receipt", s3);
        s2.put("productType", "CNPCK");
        s = new HashMap();
        s.put("orders", Arrays.asList(new Map[] {
            s2
        }));
        int i = 0;
        while (i < 4) 
        {
            if (i > 0)
            {
                aa.e(a, (new StringBuilder()).append("Re-trying the coin packs purchase API call to server. Try #").append(i + 1).toString());
            }
            if (a(((Map) (s))))
            {
                return true;
            }
            try
            {
                Thread.sleep(600L);
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            i++;
        }
        return false;
    }

}
