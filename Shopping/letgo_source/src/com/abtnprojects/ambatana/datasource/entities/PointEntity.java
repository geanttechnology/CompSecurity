// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities;

import android.support.v7.aeu;

public class PointEntity
{

    double latitude;
    double longitude;
    long timeStamp;

    public PointEntity(double d, double d1, long l)
    {
        latitude = d;
        longitude = d1;
        timeStamp = l;
    }

    public String asJson()
    {
        return (new aeu()).a(this);
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }
}
