// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import android.location.Location;

public class LastKnownLocationEvent
{

    private Location location;

    public LastKnownLocationEvent(Location location1)
    {
        location = location1;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location1)
    {
        location = location1;
    }
}
