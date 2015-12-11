// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.feeds.VenueEntity;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

private static class <init>
{

    private n mDirection;
    private float mDistance;
    private n mType;
    private VenueEntity mVenue;
    private ation mVenueLocation;

    private <init> updateDirection(Location location)
    {
        if (mVenueLocation.distanceTo(location) < mDistance)
        {
            location = n.approaching;
        } else
        {
            location = n.leaving;
        }
        mDirection = location;
        return this;
    }

    private mDirection updateDistance(Location location)
    {
        mDistance = mVenueLocation.distanceTo(location);
        return this;
    }

    private ation.distanceTo updateProximityState(Location location)
    {
        if ((float)mVenueLocation.venue.geofence + location.getAccuracy() > mDistance)
        {
            mType = R_VENUE;
            return this;
        } else
        {
            mType = _OF_VENUE;
            return this;
        }
    }

    public final VenueProximityState build()
    {
        return new VenueProximityState(mDistance, mVenueLocation, mType, mDirection, null);
    }

    public final n setDirection(n n)
    {
        mDirection = n;
        return this;
    }

    public mDirection setDistance(float f)
    {
        mDistance = f;
        return this;
    }

    public final mDistance setProximityState(mDistance mdistance)
    {
        mType = mdistance;
        return this;
    }

    public final mType setVenueLocation(VenueEntity venueentity)
    {
        mVenueLocation = new ation(venueentity);
        return this;
    }

    public final ation setVenueLocation(ation ation)
    {
        if (!mVenueLocation.venue.equals(ation))
        {
            mDirection = n.approaching;
            mVenueLocation = ation;
        }
        return this;
    }




    private ation()
    {
        mDistance = 3.402823E+38F;
        mVenue = (new com.pointinside.feeds.ate.Builder.mVenue()).mVenue();
        mVenueLocation = new ation(mVenue);
        mType = NOWN;
        mDirection = n.leaving;
    }

    n.leaving(n.leaving leaving)
    {
        this();
    }

    private n(VenueProximityState venueproximitystate)
    {
        mDistance = 3.402823E+38F;
        mVenue = (new com.pointinside.feeds.ate.Builder.mVenue()).mVenue();
        mVenueLocation = new ation(mVenue);
        mType = NOWN;
        mDirection = n.leaving;
        setDirection(venueproximitystate.direction);
        setDistance(venueproximitystate.distance);
        setVenueLocation(venueproximitystate.venueLocation.venue);
        setProximityState(venueproximitystate.type);
    }

    setProximityState(VenueProximityState venueproximitystate, setProximityState setproximitystate)
    {
        this(venueproximitystate);
    }
}
