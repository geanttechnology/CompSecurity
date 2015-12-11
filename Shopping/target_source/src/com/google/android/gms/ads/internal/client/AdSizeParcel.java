// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            g, h

public final class AdSizeParcel
    implements SafeParcelable
{

    public static final g CREATOR = new g();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final AdSizeParcel h[];
    public final boolean i;

    public AdSizeParcel()
    {
        this(3, "interstitial_mb", 0, 0, true, 0, 0, null, false);
    }

    AdSizeParcel(int j, String s, int k, int l, boolean flag, int i1, int j1, 
            AdSizeParcel aadsizeparcel[], boolean flag1)
    {
        a = j;
        b = s;
        c = k;
        d = l;
        e = flag;
        f = i1;
        g = j1;
        h = aadsizeparcel;
        i = flag1;
    }

    public AdSizeParcel(Context context, a a1)
    {
        this(context, new a[] {
            a1
        });
    }

    public AdSizeParcel(Context context, a aa[])
    {
        a a1 = aa[0];
        a = 3;
        e = false;
        f = a1.b();
        c = a1.a();
        DisplayMetrics displaymetrics;
        int j;
        boolean flag;
        boolean flag1;
        int k;
        if (f == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (c == -2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        displaymetrics = context.getResources().getDisplayMetrics();
        if (flag)
        {
            double d1;
            if (com.google.android.gms.ads.internal.client.h.a().a(context) && com.google.android.gms.ads.internal.client.h.a().b(context))
            {
                g = a(displaymetrics) - com.google.android.gms.ads.internal.client.h.a().c(context);
            } else
            {
                g = a(displaymetrics);
            }
            d1 = (float)g / displaymetrics.density;
            k = (int)d1;
            j = k;
            if (d1 - (double)(int)d1 >= 0.01D)
            {
                j = k + 1;
            }
        } else
        {
            j = f;
            g = com.google.android.gms.ads.internal.client.h.a().a(displaymetrics, f);
        }
        if (flag1)
        {
            k = b(displaymetrics);
        } else
        {
            k = c;
        }
        d = com.google.android.gms.ads.internal.client.h.a().a(displaymetrics, k);
        if (flag || flag1)
        {
            b = (new StringBuilder()).append(j).append("x").append(k).append("_as").toString();
        } else
        {
            b = a1.toString();
        }
        if (aa.length > 1)
        {
            h = new AdSizeParcel[aa.length];
            for (j = 0; j < aa.length; j++)
            {
                h[j] = new AdSizeParcel(context, aa[j]);
            }

        } else
        {
            h = null;
        }
        i = false;
    }

    public static int a(DisplayMetrics displaymetrics)
    {
        return displaymetrics.widthPixels;
    }

    private static int b(DisplayMetrics displaymetrics)
    {
        int j = (int)((float)displaymetrics.heightPixels / displaymetrics.density);
        if (j <= 400)
        {
            return 32;
        }
        return j > 720 ? 90 : 50;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        com.google.android.gms.ads.internal.client.g.a(this, parcel, j);
    }

}
