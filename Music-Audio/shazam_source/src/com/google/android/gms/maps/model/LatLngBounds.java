// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.maps.model:
//            i, LatLng

public final class LatLngBounds
    implements SafeParcelable
{
    public static final class a
    {

        public double a;
        public double b;
        public double c;
        public double d;

        public a()
        {
            a = (1.0D / 0.0D);
            b = (-1.0D / 0.0D);
            c = (0.0D / 0.0D);
            d = (0.0D / 0.0D);
        }
    }


    public static final i CREATOR = new i();
    final int a;
    public final LatLng b;
    public final LatLng c;

    LatLngBounds(int j, LatLng latlng, LatLng latlng1)
    {
        w.a(latlng, "null southwest");
        w.a(latlng1, "null northeast");
        boolean flag;
        if (latlng1.b >= latlng.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.b), Double.valueOf(latlng1.b)
        });
        a = j;
        b = latlng;
        c = latlng1;
    }

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        this(1, latlng, latlng1);
    }

    public static double a(double d, double d1)
    {
        return ((d - d1) + 360D) % 360D;
    }

    public static a a()
    {
        return new a();
    }

    public static double b(double d, double d1)
    {
        return ((d1 - d) + 360D) % 360D;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!b.equals(((LatLngBounds) (obj)).b) || !c.equals(((LatLngBounds) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c
        });
    }

    public final String toString()
    {
        return v.a(this).a("southwest", b).a("northeast", c).toString();
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        i.a(this, parcel, j);
    }

}
