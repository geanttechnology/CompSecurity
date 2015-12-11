// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;


public class ShouldGetAdEvent
{

    private final double latitude;
    private final double longitude;
    private final boolean startImmediately;

    public ShouldGetAdEvent(boolean flag)
    {
        longitude = 0.0D;
        latitude = 0.0D;
        startImmediately = flag;
    }

    public ShouldGetAdEvent(boolean flag, double d, double d1)
    {
        latitude = d;
        longitude = d1;
        startImmediately = flag;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public boolean isStartImmediately()
    {
        return startImmediately;
    }
}
