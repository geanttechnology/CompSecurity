// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.data;


public class PushZoneLocation
{

    private long mDistanceTo;
    private double mLat;
    private double mLng;
    private String mName;

    public PushZoneLocation()
    {
    }

    public long getDistanceTo()
    {
        return mDistanceTo;
    }

    public void setDistanceTo(long l)
    {
        mDistanceTo = l;
    }

    public void setLat(double d)
    {
        mLat = d;
    }

    public void setLng(double d)
    {
        mLng = d;
    }

    public void setName(String s)
    {
        mName = s;
    }
}
