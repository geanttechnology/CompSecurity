// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.support.v7.lk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            l, a, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final l CREATOR = new l();
    private final int a;
    private LatLng b;
    private String c;
    private String d;
    private a e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;

    public MarkerOptions()
    {
        f = 0.5F;
        g = 1.0F;
        i = true;
        j = false;
        k = 0.0F;
        l = 0.5F;
        m = 0.0F;
        n = 1.0F;
        a = 1;
    }

    MarkerOptions(int i1, LatLng latlng, String s, String s1, IBinder ibinder, float f1, float f2, 
            boolean flag, boolean flag1, boolean flag2, float f3, float f4, float f5, float f6)
    {
        f = 0.5F;
        g = 1.0F;
        i = true;
        j = false;
        k = 0.0F;
        l = 0.5F;
        m = 0.0F;
        n = 1.0F;
        a = i1;
        b = latlng;
        c = s;
        d = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new a(android.support.v7.lk.a.a(ibinder));
        }
        e = latlng;
        f = f1;
        g = f2;
        h = flag;
        i = flag1;
        j = flag2;
        k = f3;
        l = f4;
        m = f5;
        n = f6;
    }

    int a()
    {
        return a;
    }

    public MarkerOptions a(LatLng latlng)
    {
        b = latlng;
        return this;
    }

    public MarkerOptions a(a a1)
    {
        e = a1;
        return this;
    }

    public MarkerOptions a(String s)
    {
        c = s;
        return this;
    }

    IBinder b()
    {
        if (e == null)
        {
            return null;
        } else
        {
            return e.a().asBinder();
        }
    }

    public MarkerOptions b(String s)
    {
        d = s;
        return this;
    }

    public LatLng c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return d;
    }

    public float f()
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

    public boolean i()
    {
        return i;
    }

    public boolean j()
    {
        return j;
    }

    public float k()
    {
        return k;
    }

    public float l()
    {
        return l;
    }

    public float m()
    {
        return m;
    }

    public float n()
    {
        return n;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.maps.model.l.a(this, parcel, i1);
    }

}
