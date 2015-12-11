// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package android.support.v7:
//            agr

public class ags
{

    private static double a(double d, double d1, double d2, double d3)
    {
        return agr.b(agr.a(d, d2, d1 - d3));
    }

    static double a(LatLng latlng, LatLng latlng1)
    {
        return a(Math.toRadians(latlng.a), Math.toRadians(latlng.b), Math.toRadians(latlng1.a), Math.toRadians(latlng1.b));
    }

    public static double b(LatLng latlng, LatLng latlng1)
    {
        return a(latlng, latlng1) * 6371009D;
    }
}
