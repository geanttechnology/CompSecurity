// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.location;

import java.io.Serializable;

public class SimpleLocation
    implements Serializable
{

    public Double altitude;
    public final double latitude;
    public final double longitude;
    private final String provider;

    public SimpleLocation(String s, double d, double d1, Double double1)
    {
        provider = s;
        latitude = d;
        longitude = d1;
        altitude = double1;
    }

    public final double a()
    {
        Double double1 = altitude;
        if (double1 != null)
        {
            return double1.doubleValue();
        } else
        {
            return 0.0D;
        }
    }
}
