// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ct, co, cb

public final class ch
{

    private String hP;
    private String hQ;
    private String hR;
    private List hS;
    private List hT;
    private long hU;
    private boolean hV;
    private final long hW = -1L;
    private List hX;
    private long hY;
    private int mOrientation;

    public ch()
    {
        hU = -1L;
        hV = false;
        hY = -1L;
        mOrientation = -1;
    }

    private static long a(Map map, String s)
    {
        map = (List)map.get(s);
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        map = (String)map.get(0);
        float f1 = Float.parseFloat(map);
        return (long)(f1 * 1000F);
        NumberFormatException numberformatexception;
        numberformatexception;
        ct.v((new StringBuilder()).append("Could not parse float from ").append(s).append(" header: ").append(map).toString());
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

    private void e(Map map)
    {
        map = (List)map.get("X-Afma-Ad-Size");
        if (map != null && !map.isEmpty())
        {
            hP = (String)map.get(0);
        }
    }

    private void f(Map map)
    {
        map = b(map, "X-Afma-Click-Tracking-Urls");
        if (map != null)
        {
            hS = map;
        }
    }

    private void g(Map map)
    {
        map = b(map, "X-Afma-Tracking-Urls");
        if (map != null)
        {
            hT = map;
        }
    }

    private void h(Map map)
    {
        long l1 = a(map, "X-Afma-Interstitial-Timeout");
        if (l1 != -1L)
        {
            hU = l1;
        }
    }

    private void i(Map map)
    {
        map = (List)map.get("X-Afma-Mediation");
        if (map != null && !map.isEmpty())
        {
            hV = Boolean.valueOf((String)map.get(0)).booleanValue();
        }
    }

    private void j(Map map)
    {
        map = b(map, "X-Afma-Manual-Tracking-Urls");
        if (map != null)
        {
            hX = map;
        }
    }

    private void k(Map map)
    {
        long l1 = a(map, "X-Afma-Refresh-Rate");
        if (l1 != -1L)
        {
            hY = l1;
        }
    }

    private void l(Map map)
    {
        map = (List)map.get("X-Afma-Orientation");
        if (map != null && !map.isEmpty())
        {
            map = (String)map.get(0);
            if ("portrait".equalsIgnoreCase(map))
            {
                mOrientation = co.av();
            } else
            if ("landscape".equalsIgnoreCase(map))
            {
                mOrientation = co.au();
                return;
            }
        }
    }

    public void a(String s, Map map, String s1)
    {
        hQ = s;
        hR = s1;
        d(map);
    }

    public cb aq()
    {
        return new cb(hQ, hR, hS, hT, hU, hV, -1L, hX, hY, mOrientation, hP);
    }

    public void d(Map map)
    {
        e(map);
        f(map);
        g(map);
        h(map);
        i(map);
        j(map);
        k(map);
        l(map);
    }
}
