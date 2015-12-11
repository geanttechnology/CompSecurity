// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import aca;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import oo;
import oq;
import tk;

public final class ay
    implements SafeParcelable
{

    public static final tk CREATOR = new tk();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final ay h[];

    public ay()
    {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    public ay(int i, String s, int j, int k, boolean flag, int l, int i1, 
            ay aay[])
    {
        a = i;
        b = s;
        c = j;
        d = k;
        e = flag;
        f = l;
        g = i1;
        h = aay;
    }

    public ay(Context context, oo oo1)
    {
        this(context, new oo[] {
            oo1
        });
    }

    public ay(Context context, oo aoo[])
    {
        boolean flag1 = false;
        super();
        oo oo1 = aoo[0];
        a = 2;
        e = false;
        f = oo1.b();
        c = oo1.a();
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
            g = a(displaymetrics);
            j = (int)((float)g / displaymetrics.density);
        } else
        {
            j = f;
            g = aca.a(displaymetrics, f);
        }
        if (flag)
        {
            k = c(displaymetrics);
        } else
        {
            k = c;
        }
        d = aca.a(displaymetrics, k);
        if (i != 0 || flag)
        {
            b = (new StringBuilder()).append(j).append("x").append(k).append("_as").toString();
        } else
        {
            b = oo1.toString();
        }
        if (aoo.length > 1)
        {
            h = new ay[aoo.length];
            for (i = ((flag1) ? 1 : 0); i < aoo.length; i++)
            {
                h[i] = new ay(context, aoo[i]);
            }

        } else
        {
            h = null;
        }
    }

    public ay(ay ay1, ay aay[])
    {
        this(2, ay1.b, ay1.c, ay1.d, ay1.e, ay1.f, ay1.g, aay);
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

    public oo a()
    {
        return oq.a(f, c, b);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        tk.a(this, parcel, i);
    }

}
