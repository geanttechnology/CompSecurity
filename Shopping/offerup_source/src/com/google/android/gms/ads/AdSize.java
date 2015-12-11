// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;

public final class AdSize
{

    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    private final int zznQ;
    private final int zznR;
    private final String zznS;

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
        if (i < 0 && i != -1 && i != -3)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid width for AdSize: ")).append(i).toString());
        }
        if (j < 0 && j != -2 && j != -4)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid height for AdSize: ")).append(j).toString());
        } else
        {
            zznQ = i;
            zznR = j;
            zznS = s;
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
            if (zznQ != ((AdSize) (obj)).zznQ || zznR != ((AdSize) (obj)).zznR || !zznS.equals(((AdSize) (obj)).zznS))
            {
                return false;
            }
        }
        return true;
    }

    public final int getHeight()
    {
        return zznR;
    }

    public final int getHeightInPixels(Context context)
    {
        switch (zznR)
        {
        default:
            return zzl.zzcF().zzb(context, zznR);

        case -2: 
            return AdSizeParcel.zzb(context.getResources().getDisplayMetrics());

        case -4: 
        case -3: 
            return -1;
        }
    }

    public final int getWidth()
    {
        return zznQ;
    }

    public final int getWidthInPixels(Context context)
    {
        switch (zznQ)
        {
        case -2: 
        default:
            return zzl.zzcF().zzb(context, zznQ);

        case -1: 
            return AdSizeParcel.zza(context.getResources().getDisplayMetrics());

        case -4: 
        case -3: 
            return -1;
        }
    }

    public final int hashCode()
    {
        return zznS.hashCode();
    }

    public final boolean isAutoHeight()
    {
        return zznR == -2;
    }

    public final boolean isFluid()
    {
        return zznQ == -3 && zznR == -4;
    }

    public final boolean isFullWidth()
    {
        return zznQ == -1;
    }

    public final String toString()
    {
        return zznS;
    }

}
