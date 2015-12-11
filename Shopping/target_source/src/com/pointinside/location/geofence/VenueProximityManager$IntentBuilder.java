// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Intent;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityManager, VenueProximityService

static class duration
{

    private int duration;
    private int interval;
    private String pkgName;
    private type type;

    public Intent build()
    {
        switch (om.pointinside.location.geofence.VenueProximityManager.ACTIONS[type.l()])
        {
        default:
            return null;

        case 1: // '\001'
            return VenueProximityService.getStartIntent(pkgName, interval, duration);

        case 2: // '\002'
            return VenueProximityService.getStopIntent(pkgName);
        }
    }

    public pkgName setDuration(int i)
    {
        duration = i;
        return this;
    }

    public duration setInterval(int i)
    {
        interval = i;
        return this;
    }

    public interval setPkgName(String s)
    {
        pkgName = new String(s);
        return this;
    }

    public pkgName setType(pkgName pkgname)
    {
        type = pkgname;
        return this;
    }

    ()
    {
        interval = 0x80000000;
        duration = 0x80000000;
    }
}
