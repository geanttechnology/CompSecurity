// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.Region;

public class BeaconRegionExitEvent
{

    private Region region;

    public BeaconRegionExitEvent(Region region1)
    {
        region = region1;
    }

    public Region getRegion()
    {
        return region;
    }

    public void setRegion(Region region1)
    {
        region = region1;
    }
}
