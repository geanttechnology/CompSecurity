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
//            d, a, LatLng, LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final d CREATOR = new d();
    final int a;
    LatLng b;
    float c;
    float d;
    LatLngBounds e;
    float f;
    float g;
    boolean h;
    float i;
    float j;
    float k;
    private com.google.android.gms.maps.model.a l;

    public GroundOverlayOptions()
    {
        h = true;
        i = 0.0F;
        j = 0.5F;
        k = 0.5F;
        a = 1;
    }

    GroundOverlayOptions(int i1, IBinder ibinder, LatLng latlng, float f1, float f2, LatLngBounds latlngbounds, float f3, 
            float f4, boolean flag, float f5, float f6, float f7)
    {
        h = true;
        i = 0.0F;
        j = 0.5F;
        k = 0.5F;
        a = i1;
        l = new com.google.android.gms.maps.model.a(com.google.android.gms.a.b.a(ibinder));
        b = latlng;
        c = f1;
        d = f2;
        e = latlngbounds;
        f = f3;
        g = f4;
        h = flag;
        i = f5;
        j = f6;
        k = f7;
    }

    final IBinder a()
    {
        return l.a.asBinder();
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
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, a());
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, b, i1, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, c);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, d);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 6, e, i1, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, f);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, g);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 9, h);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 10, i);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 11, j);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 12, k);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j1);
            return;
        } else
        {
            com.google.android.gms.maps.model.d.a(this, parcel, i1);
            return;
        }
    }

}
