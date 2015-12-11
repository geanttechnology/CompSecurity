// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            et, ej

public final class dz
{

    String a;
    String b;
    String c;
    List d;
    List e;
    long f;
    boolean g;
    List h;
    long i;
    int j;
    private final long k = -1L;

    public dz()
    {
        f = -1L;
        g = false;
        i = -1L;
        j = -1;
    }

    private static long a(Map map, String s)
    {
        map = (List)map.get(s);
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        map = (String)map.get(0);
        float f1 = Float.parseFloat(map);
        return (long)(f1 * 1000F);
        NumberFormatException numberformatexception;
        numberformatexception;
        et.d((new StringBuilder("Could not parse float from ")).append(s).append(" header: ").append(map).toString());
        return -1L;
    }

    private static List b(Map map, String s)
    {
        map = (List)map.get(s);
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

    public final void a(Map map)
    {
        List list = (List)map.get("X-Afma-Ad-Size");
        if (list != null && !list.isEmpty())
        {
            a = (String)list.get(0);
        }
        list = b(map, "X-Afma-Click-Tracking-Urls");
        if (list != null)
        {
            d = list;
        }
        list = b(map, "X-Afma-Tracking-Urls");
        if (list != null)
        {
            e = list;
        }
        long l = a(map, "X-Afma-Interstitial-Timeout");
        if (l != -1L)
        {
            f = l;
        }
        list = (List)map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty())
        {
            g = Boolean.valueOf((String)list.get(0)).booleanValue();
        }
        list = b(map, "X-Afma-Manual-Tracking-Urls");
        if (list != null)
        {
            h = list;
        }
        l = a(map, "X-Afma-Refresh-Rate");
        if (l != -1L)
        {
            i = l;
        }
        map = (List)map.get("X-Afma-Orientation");
        if (map != null && !map.isEmpty())
        {
            map = (String)map.get(0);
            if ("portrait".equalsIgnoreCase(map))
            {
                j = ej.c();
            } else
            if ("landscape".equalsIgnoreCase(map))
            {
                j = ej.b();
                return;
            }
        }
    }
}
