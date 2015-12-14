// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public class TSLocation
{

    private final double lattitude;
    private final double longitude;

    public TSLocation()
    {
        lattitude = 0.0D;
        longitude = 0.0D;
    }

    public TSLocation(double d, double d1)
    {
        lattitude = d;
        longitude = d1;
    }

    public double getLattitude()
    {
        return lattitude;
    }

    public double getLongitude()
    {
        return longitude;
    }
}
