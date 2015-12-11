// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            ky, er

public final class x
    implements SafeParcelable
{

    public static final ky CREATOR = new ky();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final x h[];

    public x()
    {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    x(int i, String s, int j, int k, boolean flag, int l, int i1, 
            x ax[])
    {
        a = i;
        b = s;
        c = j;
        d = k;
        e = flag;
        f = l;
        g = i1;
        h = ax;
    }

    public x(Context context, AdSize adsize)
    {
        this(context, new AdSize[] {
            adsize
        });
    }

    public x(Context context, AdSize aadsize[])
    {
        boolean flag1 = false;
        super();
        AdSize adsize = aadsize[0];
        a = 2;
        e = false;
        f = adsize.getWidth();
        c = adsize.getHeight();
        DisplayMetrics displaymetrics;
        int i;
        boolean flag;
        int j;
        int k;
        if (f == -1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (c == -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displaymetrics = context.getResources().getDisplayMetrics();
        if (i != 0)
        {
            g = displaymetrics.widthPixels;
            j = (int)((float)g / displaymetrics.density);
        } else
        {
            j = f;
            g = er.a(displaymetrics, f);
        }
        if (flag)
        {
            k = c(displaymetrics);
        } else
        {
            k = c;
        }
        d = er.a(displaymetrics, k);
        if (i != 0 || flag)
        {
            b = (new StringBuilder()).append(j).append("x").append(k).append("_as").toString();
        } else
        {
            b = adsize.toString();
        }
        if (aadsize.length > 1)
        {
            h = new x[aadsize.length];
            for (i = ((flag1) ? 1 : 0); i < aadsize.length; i++)
            {
                h[i] = new x(context, aadsize[i]);
            }

        } else
        {
            h = null;
        }
    }

    public x(x x1, x ax[])
    {
        this(2, x1.b, x1.c, x1.d, x1.e, x1.f, x1.g, ax);
    }

    public static int a(DisplayMetrics displaymetrics)
    {
        return displaymetrics.widthPixels;
    }

    public static int b(DisplayMetrics displaymetrics)
    {
        return (int)((float)c(displaymetrics) * displaymetrics.density);
    }

    private static int c(DisplayMetrics displaymetrics)
    {
        int i = (int)((float)displaymetrics.heightPixels / displaymetrics.density);
        if (i <= 400)
        {
            return 32;
        }
        return i > 720 ? 90 : 50;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ky.a(this, parcel, i);
    }

}
