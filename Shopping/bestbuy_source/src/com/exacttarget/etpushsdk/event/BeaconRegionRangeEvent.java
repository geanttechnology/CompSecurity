// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.Region;

public class BeaconRegionRangeEvent
{

    private double accuracy;
    private int proximity;
    private Region region;
    private int rssi;

    public BeaconRegionRangeEvent(Region region1, int i, int j, double d)
    {
        region = region1;
        proximity = i;
        rssi = j;
        accuracy = d;
    }

    public double getAccuracy()
    {
        return accuracy;
    }

    public int getProximity()
    {
        return proximity;
    }

    public Region getRegion()
    {
        return region;
    }

    public int getRssi()
    {
        return rssi;
    }

    public void setAccuracy(double d)
    {
        accuracy = d;
    }

    public void setProximity(int i)
    {
        proximity = i;
    }

    public void setRegion(Region region1)
    {
        region = region1;
    }

    public void setRssi(int i)
    {
        rssi = i;
    }
}
