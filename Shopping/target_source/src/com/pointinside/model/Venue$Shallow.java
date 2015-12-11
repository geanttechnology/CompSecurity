// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import com.pointinside.feeds.VenueEntity;
import com.pointinside.net.VenueCacheIOException;

// Referenced classes of package com.pointinside.model:
//            Venue, VenueFactory, Zone

private static class mFactory extends mFactory
{

    VenueFactory mFactory;

    private Venue getFullVenue(String s)
    {
        Object obj = null;
        try
        {
            s = mFactory.getVenueById(s, new com.pointinside.feeds.y.ImageType[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = obj;
        }
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid venue identifier: ").append(getUUID()).toString());
        } else
        {
            return s;
        }
    }

    public Zone getCurrentZone()
    {
        return updateDelegate(getFullVenue(getUUID())).getCurrentZone();
    }

    public Zone nextZone()
    {
        return updateDelegate(getFullVenue(getUUID())).nextZone();
    }

    public Zone previousZone()
    {
        return updateDelegate(getFullVenue(getUUID())).previousZone();
    }

    public Zone setZoneByUUID(String s)
    {
        return updateDelegate(getFullVenue(getUUID())).setZoneByUUID(s);
    }

    protected y.ImageType(VenueFactory venuefactory, VenueEntity venueentity)
    {
        super(venueentity, new com.pointinside.feeds.y.ImageType[0]);
        mFactory = venuefactory;
    }
}
