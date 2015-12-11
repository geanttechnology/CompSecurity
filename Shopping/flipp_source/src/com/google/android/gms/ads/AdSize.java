// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.x;

public final class AdSize
{

    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    private final String dY;
    private final int v;
    private final int w;

    public AdSize(int i, int j)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (i == -1)
        {
            s = "FULL";
        } else
        {
            s = String.valueOf(i);
        }
        stringbuilder = stringbuilder.append(s).append("x");
        if (j == -2)
        {
            s = "AUTO";
        } else
        {
            s = String.valueOf(j);
        }
        this(i, j, stringbuilder.append(s).append("_as").toString());
    }

    AdSize(int i, int j, String s)
    {
        if (i < 0 && i != -1)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid width for AdSize: ")).append(i).toString());
        }
        if (j < 0 && j != -2)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid height for AdSize: ")).append(j).toString());
        } else
        {
            w = i;
            v = j;
            dY = s;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof AdSize))
            {
                return false;
            }
            obj = (AdSize)obj;
            if (w != ((AdSize) (obj)).w || v != ((AdSize) (obj)).v || !dY.equals(((AdSize) (obj)).dY))
            {
                return false;
            }
        }
        return true;
    }

    public final int getHeight()
    {
        return v;
    }

    public final int getHeightInPixels(Context context)
    {
        if (v == -2)
        {
            return x.b(context.getResources().getDisplayMetrics());
        } else
        {
            return er.a(context, v);
        }
    }

    public final int getWidth()
    {
        return w;
    }

    public final int getWidthInPixels(Context context)
    {
        if (w == -1)
        {
            return x.a(context.getResources().getDisplayMetrics());
        } else
        {
            return er.a(context, w);
        }
    }

    public final int hashCode()
    {
        return dY.hashCode();
    }

    public final boolean isAutoHeight()
    {
        return v == -2;
    }

    public final boolean isFullWidth()
    {
        return w == -1;
    }

    public final String toString()
    {
        return dY;
    }

}
