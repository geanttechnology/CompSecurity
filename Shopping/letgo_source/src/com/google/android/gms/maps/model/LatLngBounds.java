// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.maps.model:
//            j, LatLng

public final class LatLngBounds
    implements SafeParcelable
{
    public static final class a
    {

        private double a;
        private double b;
        private double c;
        private double d;

        private boolean a(double d1)
        {
            boolean flag = false;
            if (c <= d)
            {
                return c <= d1 && d1 <= d;
            }
            if (c <= d1 || d1 <= d)
            {
                flag = true;
            }
            return flag;
        }

        public a a(LatLng latlng)
        {
            a = Math.min(a, latlng.a);
            b = Math.max(b, latlng.a);
            double d1 = latlng.b;
            if (Double.isNaN(c))
            {
                c = d1;
                d = d1;
            } else
            if (!a(d1))
            {
                if (LatLngBounds.a(c, d1) < LatLngBounds.b(d, d1))
                {
                    c = d1;
                    return this;
                } else
                {
                    d = d1;
                    return this;
                }
            }
            return this;
        }

        public LatLngBounds a()
        {
            boolean flag;
            if (!Double.isNaN(c))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.a(flag, "no included points");
            return new LatLngBounds(new LatLng(a, c), new LatLng(b, d));
        }

        public a()
        {
            a = (1.0D / 0.0D);
            b = (-1.0D / 0.0D);
            c = (0.0D / 0.0D);
            d = (0.0D / 0.0D);
        }
    }


    public static final j CREATOR = new j();
    public final LatLng a;
    public final LatLng b;
    private final int c;

    LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        x.a(latlng, "null southwest");
        x.a(latlng1, "null northeast");
        boolean flag;
        if (latlng1.a >= latlng.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.a(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.a), Double.valueOf(latlng1.a)
        });
        c = i;
        a = latlng;
        b = latlng1;
    }

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        this(1, latlng, latlng1);
    }

    static double a(double d1, double d2)
    {
        return c(d1, d2);
    }

    static double b(double d1, double d2)
    {
        return d(d1, d2);
    }

    public static a b()
    {
        return new a();
    }

    private static double c(double d1, double d2)
    {
        return ((d1 - d2) + 360D) % 360D;
    }

    private static double d(double d1, double d2)
    {
        return ((d2 - d1) + 360D) % 360D;
    }

    int a()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!a.equals(((LatLngBounds) (obj)).a) || !b.equals(((LatLngBounds) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            a, b
        });
    }

    public String toString()
    {
        return w.a(this).a("southwest", a).a("northeast", b).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        j.a(this, parcel, i);
    }

}
