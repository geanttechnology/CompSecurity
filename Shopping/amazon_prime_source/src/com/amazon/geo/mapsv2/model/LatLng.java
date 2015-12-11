// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            LatLngCreator

public final class LatLng
    implements SafeParcelable
{

    public static final LatLngCreator CREATOR = new LatLngCreator();
    private static final double DEGREES_CIRCLE = 360D;
    private static final double LAT_MAX = 90D;
    private static final double LAT_MIN = -90D;
    private static final double LNG_MAX = 180D;
    private static final double LNG_MIN = -180D;
    public final double latitude;
    public final double longitude;

    public LatLng(double d, double d1)
    {
        latitude = clamp(d, -90D, 90D);
        longitude = normalizeLng(d1);
    }

    private static double clamp(double d, double d1, double d2)
    {
        return Math.max(d1, Math.min(d2, d));
    }

    private static double normalizeLng(double d)
    {
        if (-180D <= d && d < 180D)
        {
            return d;
        } else
        {
            return ((d - 180D) % 360D + 360D) % 360D - 180D;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof LatLng))
            {
                return false;
            }
            obj = (LatLng)obj;
            if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(((LatLng) (obj)).latitude))
            {
                return false;
            }
            if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(((LatLng) (obj)).longitude))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(latitude);
        int i = (int)(l >>> 32 ^ l);
        l = Double.doubleToLongBits(longitude);
        return (i + 31) * 31 + (int)(l >>> 32 ^ l);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("lat/lng: (");
        stringbuilder.append(latitude);
        stringbuilder.append(",");
        stringbuilder.append(longitude);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        LatLngCreator.write(this, parcel, i);
    }

}
