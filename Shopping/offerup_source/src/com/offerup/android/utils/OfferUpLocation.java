// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.location.Address;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.utils:
//            ar, as

public class OfferUpLocation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ar();
    Location a;
    private String b;
    private String c;
    private double d;
    private double e;
    private boolean f;
    private String g;
    private String h;
    private boolean i;

    public OfferUpLocation()
    {
        b = "";
        c = "";
        g = "";
        h = "";
    }

    public OfferUpLocation(Address address, boolean flag)
    {
        b = "";
        c = "";
        g = "";
        h = "";
        if (address != null)
        {
            a(address.getPostalCode());
            if (address.hasLongitude())
            {
                d = address.getLongitude();
            }
            if (address.hasLatitude())
            {
                e = address.getLatitude();
            }
            f = flag;
            c(address.getLocality());
            d(address.getAdminArea());
        }
    }

    public OfferUpLocation(Location location)
    {
        b = "";
        c = "";
        g = "";
        h = "";
        if (location != null)
        {
            a = location;
            d = location.getLongitude();
            e = location.getLatitude();
        }
    }

    static double a(OfferUpLocation offeruplocation, double d1)
    {
        offeruplocation.d = d1;
        return d1;
    }

    static String a(OfferUpLocation offeruplocation, String s)
    {
        offeruplocation.b = s;
        return s;
    }

    static boolean a(OfferUpLocation offeruplocation, boolean flag)
    {
        offeruplocation.f = flag;
        return flag;
    }

    static double b(OfferUpLocation offeruplocation, double d1)
    {
        offeruplocation.e = d1;
        return d1;
    }

    static String b(OfferUpLocation offeruplocation, String s)
    {
        offeruplocation.c = s;
        return s;
    }

    static boolean b(OfferUpLocation offeruplocation, boolean flag)
    {
        offeruplocation.i = flag;
        return flag;
    }

    static String c(OfferUpLocation offeruplocation, String s)
    {
        offeruplocation.g = s;
        return s;
    }

    static String d(OfferUpLocation offeruplocation, String s)
    {
        offeruplocation.h = s;
        return s;
    }

    public final String a()
    {
        return c;
    }

    public final void a(double d1)
    {
        d = d1;
    }

    public final void a(Location location)
    {
        a = null;
    }

    public final void a(String s)
    {
        if (s != null)
        {
            c = s;
        }
    }

    public final void a(boolean flag)
    {
        f = flag;
    }

    public final String b()
    {
        return b;
    }

    public final void b(double d1)
    {
        e = d1;
    }

    public final void b(String s)
    {
        b = s;
    }

    public final double c()
    {
        return d;
    }

    public final void c(String s)
    {
        if (s != null)
        {
            g = s;
        }
    }

    public final double d()
    {
        return e;
    }

    public final void d(String s)
    {
        if (s != null)
        {
            h = s;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public final boolean e()
    {
        return f;
    }

    public final String f()
    {
        return g;
    }

    public final String g()
    {
        return as.c(h);
    }

    public final String h()
    {
        return h;
    }

    public final Location i()
    {
        return a;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        boolean flag = true;
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeDouble(d);
        parcel.writeDouble(e);
        int k;
        if (f)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        parcel.writeString(g);
        parcel.writeString(h);
        if (i)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        parcel.writeParcelable(a, j);
    }

}
