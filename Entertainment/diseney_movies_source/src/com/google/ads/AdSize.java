// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize
{

    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final int a;
    private final int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;

    public AdSize(int i, int j)
    {
        this(i, j, null);
        if (a())
        {
            e = false;
            f = "mb";
            return;
        } else
        {
            e = true;
            return;
        }
    }

    private AdSize(int i, int j, String s)
    {
        boolean flag1 = true;
        super();
        a = i;
        b = j;
        f = s;
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (j == -2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        d = flag;
        e = false;
    }

    private static int a(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (int)((float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density);
    }

    private boolean a()
    {
        return a < 0 || b < 0;
    }

    private static int b(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        int i = (int)((float)((DisplayMetrics) (context)).heightPixels / ((DisplayMetrics) (context)).density);
        if (i <= 400)
        {
            return 32;
        }
        return i > 720 ? 90 : 50;
    }

    public static AdSize createAdSize(AdSize adsize, Context context)
    {
        if (context == null || !adsize.a())
        {
            context = adsize;
            if (adsize.a())
            {
                context = BANNER;
            }
            return context;
        }
        int i;
        int j;
        if (adsize.c)
        {
            i = a(context);
        } else
        {
            i = adsize.getWidth();
        }
        if (adsize.d)
        {
            j = b(context);
        } else
        {
            j = adsize.getHeight();
        }
        context = new AdSize(i, j, adsize.f);
        context.d = adsize.d;
        context.c = adsize.c;
        context.e = adsize.e;
        return context;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof AdSize)
        {
            if (a == ((AdSize) (obj = (AdSize)obj)).a && b == ((AdSize) (obj)).b)
            {
                return true;
            }
        }
        return false;
    }

    public transient AdSize findBestSize(AdSize aadsize[])
    {
        double d1;
        AdSize adsize;
        AdSize adsize1;
        adsize1 = null;
        adsize = null;
        d1 = 0.0D;
        if (aadsize == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = aadsize.length;
        i = 0;
_L3:
        double d2;
        adsize1 = adsize;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        adsize1 = aadsize[i];
        if (!isSizeAppropriate(adsize1.a, adsize1.b))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        double d3 = ((double)adsize1.a * (double)adsize1.b) / ((double)a * (double)b);
        d2 = d3;
        if (d3 > 1.0D)
        {
            d2 = 1.0D / d3;
        }
        if (d2 <= d1)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        adsize = adsize1;
_L4:
        i++;
        d1 = d2;
        if (true) goto _L3; else goto _L2
_L2:
        return adsize1;
        d2 = d1;
          goto _L4
    }

    public int getHeight()
    {
        if (b < 0)
        {
            throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
        } else
        {
            return b;
        }
    }

    public int getHeightInPixels(Context context)
    {
        return (int)TypedValue.applyDimension(1, b, context.getResources().getDisplayMetrics());
    }

    public int getWidth()
    {
        if (a < 0)
        {
            throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
        } else
        {
            return a;
        }
    }

    public int getWidthInPixels(Context context)
    {
        return (int)TypedValue.applyDimension(1, a, context.getResources().getDisplayMetrics());
    }

    public int hashCode()
    {
        return Integer.valueOf(a).hashCode() << 16 | Integer.valueOf(b).hashCode() & 0xffff;
    }

    public boolean isAutoHeight()
    {
        return d;
    }

    public boolean isCustomAdSize()
    {
        return e;
    }

    public boolean isFullWidth()
    {
        return c;
    }

    public boolean isSizeAppropriate(int i, int j)
    {
        return (double)i <= (double)a * 1.25D && (double)i >= (double)a * 0.80000000000000004D && (double)j <= (double)b * 1.25D && (double)j >= (double)b * 0.80000000000000004D;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(getWidth()).append("x").append(getHeight());
        String s;
        if (f == null)
        {
            s = "";
        } else
        {
            s = (new StringBuilder()).append("_").append(f).toString();
        }
        return stringbuilder.append(s).toString();
    }

}
