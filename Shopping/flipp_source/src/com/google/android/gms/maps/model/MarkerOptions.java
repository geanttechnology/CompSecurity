// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.maps.model:
//            g, a, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final g CREATOR = new g();
    final int a;
    LatLng b;
    String c;
    String d;
    float e;
    float f;
    boolean g;
    boolean h;
    boolean i;
    float j;
    float k;
    float l;
    float m;
    private com.google.android.gms.maps.model.a n;

    public MarkerOptions()
    {
        e = 0.5F;
        f = 1.0F;
        h = true;
        i = false;
        j = 0.0F;
        k = 0.5F;
        l = 0.0F;
        m = 1.0F;
        a = 1;
    }

    MarkerOptions(int i1, LatLng latlng, String s, String s1, IBinder ibinder, float f1, float f2, 
            boolean flag, boolean flag1, boolean flag2, float f3, float f4, float f5, float f6)
    {
        e = 0.5F;
        f = 1.0F;
        h = true;
        i = false;
        j = 0.0F;
        k = 0.5F;
        l = 0.0F;
        m = 1.0F;
        a = i1;
        b = latlng;
        c = s;
        d = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new com.google.android.gms.maps.model.a(com.google.android.gms.a.b.a(ibinder));
        }
        n = latlng;
        e = f1;
        f = f2;
        g = flag;
        h = flag1;
        i = flag2;
        j = f3;
        k = f4;
        l = f5;
        m = f6;
    }

    final IBinder a()
    {
        if (n == null)
        {
            return null;
        } else
        {
            return n.a.asBinder();
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            int j1 = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, b, i1, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, c, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, d, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, a());
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, e);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, f);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, g);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, h);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j1);
            return;
        } else
        {
            com.google.android.gms.maps.model.g.a(this, parcel, i1);
            return;
        }
    }

}
