// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;


public class LocationStatusEvent
{

    private boolean isWatchingLocation;

    public LocationStatusEvent(boolean flag)
    {
        isWatchingLocation = flag;
    }

    public boolean isWatchingLocation()
    {
        return isWatchingLocation;
    }
}
