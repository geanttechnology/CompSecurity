// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            y, cs

public final class x
    implements SafeParcelable
{

    public static final y CREATOR = new y();
    public final String eF;
    public final boolean eG;
    public final x eH[];
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public x()
    {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    x(int i, String s, int j, int k, boolean flag, int l, int i1, 
            x ax[])
    {
        versionCode = i;
        eF = s;
        height = j;
        heightPixels = k;
        eG = flag;
        width = l;
        widthPixels = i1;
        eH = ax;
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
        versionCode = 2;
        eG = false;
        width = adsize.getWidth();
        height = adsize.getHeight();
        DisplayMetrics displaymetrics;
        int i;
        boolean flag;
        int j;
        int k;
        if (width == -1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (height == -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displaymetrics = context.getResources().getDisplayMetrics();
        if (i != 0)
        {
            widthPixels = a(displaymetrics);
            j = (int)((float)widthPixels / displaymetrics.density);
        } else
        {
            j = width;
            widthPixels = com.google.android.gms.internal.cs.a(displaymetrics, width);
        }
        if (flag)
        {
            k = c(displaymetrics);
        } else
        {
            k = height;
        }
        heightPixels = com.google.android.gms.internal.cs.a(displaymetrics, k);
        if (i != 0 || flag)
        {
            eF = (new StringBuilder()).append(j).append("x").append(k).append("_as").toString();
        } else
        {
            eF = adsize.toString();
        }
        if (aadsize.length > 1)
        {
            eH = new x[aadsize.length];
            for (i = ((flag1) ? 1 : 0); i < aadsize.length; i++)
            {
                eH[i] = new x(context, aadsize[i]);
            }

        } else
        {
            eH = null;
        }
    }

    public x(x x1, x ax[])
    {
        this(2, x1.eF, x1.height, x1.heightPixels, x1.eG, x1.width, x1.widthPixels, ax);
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

    public AdSize P()
    {
        return com.google.android.gms.ads.a.a(width, height, eF);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.internal.y.a(this, parcel, i);
    }

}
