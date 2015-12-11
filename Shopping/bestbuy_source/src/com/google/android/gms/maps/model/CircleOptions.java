// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import aks;
import android.os.Parcel;
import anq;
import anr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final anq CREATOR = new anq();
    private final int a;
    private LatLng b;
    private double c;
    private float d;
    private int e;
    private int f;
    private float g;
    private boolean h;

    public CircleOptions()
    {
        b = null;
        c = 0.0D;
        d = 10F;
        e = 0xff000000;
        f = 0;
        g = 0.0F;
        h = true;
        a = 1;
    }

    public CircleOptions(int i, LatLng latlng, double d1, float f1, int j, int k, 
            float f2, boolean flag)
    {
        b = null;
        c = 0.0D;
        d = 10F;
        e = 0xff000000;
        f = 0;
        g = 0.0F;
        h = true;
        a = i;
        b = latlng;
        c = d1;
        d = f1;
        e = j;
        f = k;
        g = f2;
        h = flag;
    }

    public int a()
    {
        return a;
    }

    public LatLng b()
    {
        return b;
    }

    public double c()
    {
        return c;
    }

    public float d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public int e()
    {
        return e;
    }

    public int f()
    {
        return f;
    }

    public float g()
    {
        return g;
    }

    public boolean h()
    {
        return h;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (aks.a())
        {
            anr.a(this, parcel, i);
            return;
        } else
        {
            anq.a(this, parcel, i);
            return;
        }
    }

}
