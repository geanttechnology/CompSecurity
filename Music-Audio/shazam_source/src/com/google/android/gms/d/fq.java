// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            gn

public final class fq
{

    String a;
    String b;
    String c;
    List d;
    String e;
    String f;
    List g;
    long h;
    boolean i;
    List j;
    long k;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;
    final AdRequestInfoParcel r;
    private final long s = -1L;

    public fq(AdRequestInfoParcel adrequestinfoparcel)
    {
        h = -1L;
        i = false;
        k = -1L;
        l = -1;
        m = false;
        n = false;
        o = false;
        p = true;
        q = 0;
        r = adrequestinfoparcel;
    }

    private static String a(Map map, String s1)
    {
        map = (List)map.get(s1);
        if (map != null && !map.isEmpty())
        {
            return (String)map.get(0);
        } else
        {
            return null;
        }
    }

    private static long b(Map map, String s1)
    {
        map = (List)map.get(s1);
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        map = (String)map.get(0);
        float f1 = Float.parseFloat(map);
        return (long)(f1 * 1000F);
        NumberFormatException numberformatexception;
        numberformatexception;
        (new StringBuilder("Could not parse float from ")).append(s1).append(" header: ").append(map);
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return -1L;
    }

    private static List c(Map map, String s1)
    {
        map = (List)map.get(s1);
        if (map != null && !map.isEmpty())
        {
            map = (String)map.get(0);
            if (map != null)
            {
                return Arrays.asList(map.trim().split("\\s+"));
            }
        }
        return null;
    }

    private static boolean d(Map map, String s1)
    {
        map = (List)map.get(s1);
        return map != null && !map.isEmpty() && Boolean.valueOf((String)map.get(0)).booleanValue();
    }

    public final void a(Map map)
    {
        Object obj;
        a = a(map, "X-Afma-Ad-Size");
        obj = c(map, "X-Afma-Click-Tracking-Urls");
        if (obj != null)
        {
            d = ((List) (obj));
        }
        obj = (List)map.get("X-Afma-Debug-Dialog");
        if (obj != null && !((List) (obj)).isEmpty())
        {
            e = (String)((List) (obj)).get(0);
        }
        obj = c(map, "X-Afma-Tracking-Urls");
        if (obj != null)
        {
            g = ((List) (obj));
        }
        long l1 = b(map, "X-Afma-Interstitial-Timeout");
        if (l1 != -1L)
        {
            h = l1;
        }
        i = i | d(map, "X-Afma-Mediation");
        obj = c(map, "X-Afma-Manual-Tracking-Urls");
        if (obj != null)
        {
            j = ((List) (obj));
        }
        l1 = b(map, "X-Afma-Refresh-Rate");
        if (l1 != -1L)
        {
            k = l1;
        }
        obj = (List)map.get("X-Afma-Orientation");
        boolean flag;
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = (String)((List) (obj)).get(0);
            boolean flag1;
            if ("portrait".equalsIgnoreCase(((String) (obj))))
            {
                l = com.google.android.gms.ads.internal.p.g().b();
            } else
            if ("landscape".equalsIgnoreCase(((String) (obj))))
            {
                l = com.google.android.gms.ads.internal.p.g().a();
            }
        }
        f = a(map, "X-Afma-ActiveView");
        obj = (List)map.get("X-Afma-Use-HTTPS");
        if (obj != null && !((List) (obj)).isEmpty())
        {
            o = Boolean.valueOf((String)((List) (obj)).get(0)).booleanValue();
        }
        m = m | d(map, "X-Afma-Custom-Rendering-Allowed");
        flag1 = n;
        if (r != null && r.m != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag | flag1;
        obj = (List)map.get("X-Afma-Content-Url-Opted-Out");
        if (obj != null && !((List) (obj)).isEmpty())
        {
            p = Boolean.valueOf((String)((List) (obj)).get(0)).booleanValue();
        }
        map = c(map, "X-Afma-OAuth-Token-Status");
        q = 0;
        if (map == null) goto _L2; else goto _L1
_L1:
        map = map.iterator();
_L4:
        if (map.hasNext())
        {
            obj = (String)map.next();
            if (!"Clear".equalsIgnoreCase(((String) (obj))))
            {
                continue; /* Loop/switch isn't completed */
            }
            q = 1;
        }
_L2:
        return;
        if (!"No-Op".equalsIgnoreCase(((String) (obj)))) goto _L4; else goto _L3
_L3:
        q = 0;
        return;
    }
}
