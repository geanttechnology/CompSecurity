// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.maps.a.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            c, LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final com.google.android.gms.maps.model.c CREATOR = new com.google.android.gms.maps.model.c();
    final int a;
    LatLng b;
    double c;
    float d;
    int e;
    int f;
    float g;
    boolean h;

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

    CircleOptions(int i, LatLng latlng, double d1, float f1, int j, int k, 
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

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            int j = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, b, i, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, c);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 5, e);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 6, f);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, g);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, h);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
            return;
        } else
        {
            com.google.android.gms.maps.model.c.a(this, parcel, i);
            return;
        }
    }

}
