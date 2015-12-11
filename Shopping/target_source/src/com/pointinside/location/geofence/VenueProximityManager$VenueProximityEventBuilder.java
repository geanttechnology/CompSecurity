// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityManager, VenueProximityCache, VenueProximityState

static class date
{

    private VenueProximityState s;
    private t t;

    date build()
    {
        return new date(t, s, null);
    }

    s setState(VenueProximityState venueproximitystate)
    {
        s = venueproximitystate;
        return this;
    }

    s setType(s s1)
    {
        t = s1;
        return this;
    }

    ()
    {
        s = VenueProximityCache.getState();
        t = date;
    }
}
