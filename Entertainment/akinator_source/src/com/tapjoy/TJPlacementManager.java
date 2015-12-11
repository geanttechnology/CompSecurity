// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.bf;

// Referenced classes of package com.tapjoy:
//            TJPlacement, TapjoyLog

public class TJPlacementManager
{

    private static final bf a = bf.a();
    private static int b = 0;
    private static int c = 0;
    private static int d = 3;
    private static int e = 3;

    public TJPlacementManager()
    {
    }

    public static boolean canCachePlacement()
    {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement()
    {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static void decrementPlacementCacheCount()
    {
        int i = b - 1;
        b = i;
        if (i < 0)
        {
            b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementPreRenderCount()
    {
        int i = c - 1;
        c = i;
        if (i < 0)
        {
            c = 0;
        }
    }

    public static TJPlacement get(String s)
    {
        synchronized (a)
        {
            s = (TJPlacement)a.get(s);
        }
        return s;
    }

    public static int getCachedPlacementCount()
    {
        return b;
    }

    public static int getCachedPlacementLimit()
    {
        return d;
    }

    public static int getPreRenderedPlacementCount()
    {
        return c;
    }

    public static int getPreRenderedPlacementLimit()
    {
        return e;
    }

    public static void incrementPlacementCacheCount()
    {
        int i = b + 1;
        b = i;
        if (i > d)
        {
            b = d;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount()
    {
        int i = c + 1;
        c = i;
        if (i > e)
        {
            c = e;
        }
    }

    public static void printPlacementCacheInformation()
    {
        TapjoyLog.i("TJPlacementManager", (new StringBuilder("Space available in placement cache: ")).append(b).append(" out of ").append(d).toString());
    }

    public static void printPlacementPreRenderInformation()
    {
        TapjoyLog.i("TJPlacementManager", (new StringBuilder("Space available for placement pre-render: ")).append(c).append(" out of ").append(e).toString());
    }

    public static void put(String s, TJPlacement tjplacement)
    {
        synchronized (a)
        {
            a.put(s, tjplacement);
        }
    }

    public static void setCachedPlacementLimit(int i)
    {
        d = i;
    }

    public static void setPreRenderedPlacementLimit(int i)
    {
        e = i;
    }

}
