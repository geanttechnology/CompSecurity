// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.feeds.VenueEntity;

public class VenueProximityState
{
    private static class Builder
    {

        private Direction mDirection;
        private float mDistance;
        private Type mType;
        private VenueEntity mVenue;
        private VenueLocation mVenueLocation;

        private Builder updateDirection(Location location)
        {
            if (mVenueLocation.distanceTo(location) < mDistance)
            {
                location = Direction.approaching;
            } else
            {
                location = Direction.leaving;
            }
            mDirection = location;
            return this;
        }

        private Builder updateDistance(Location location)
        {
            mDistance = mVenueLocation.distanceTo(location);
            return this;
        }

        private Builder updateProximityState(Location location)
        {
            if ((float)mVenueLocation.venue.geofence + location.getAccuracy() > mDistance)
            {
                mType = Type.NEAR_VENUE;
                return this;
            } else
            {
                mType = Type.OUT_OF_VENUE;
                return this;
            }
        }

        public final VenueProximityState build()
        {
            return new VenueProximityState(mDistance, mVenueLocation, mType, mDirection);
        }

        public final Builder setDirection(Direction direction1)
        {
            mDirection = direction1;
            return this;
        }

        public Builder setDistance(float f)
        {
            mDistance = f;
            return this;
        }

        public final Builder setProximityState(Type type1)
        {
            mType = type1;
            return this;
        }

        public final Builder setVenueLocation(VenueEntity venueentity)
        {
            mVenueLocation = new VenueLocation(venueentity);
            return this;
        }

        public final Builder setVenueLocation(VenueLocation venuelocation)
        {
            if (!mVenueLocation.venue.equals(venuelocation))
            {
                mDirection = Direction.approaching;
                mVenueLocation = venuelocation;
            }
            return this;
        }




        private Builder()
        {
            mDistance = 3.402823E+38F;
            mVenue = (new com.pointinside.feeds.VenueEntity.Builder()).build();
            mVenueLocation = new VenueLocation(mVenue);
            mType = Type.UNKNOWN;
            mDirection = Direction.leaving;
        }


        private Builder(VenueProximityState venueproximitystate)
        {
            mDistance = 3.402823E+38F;
            mVenue = (new com.pointinside.feeds.VenueEntity.Builder()).build();
            mVenueLocation = new VenueLocation(mVenue);
            mType = Type.UNKNOWN;
            mDirection = Direction.leaving;
            setDirection(venueproximitystate.direction);
            setDistance(venueproximitystate.distance);
            setVenueLocation(venueproximitystate.venueLocation.venue);
            setProximityState(venueproximitystate.type);
        }

    }

    public static final class Direction extends Enum
    {

        private static final Direction $VALUES[];
        public static final Direction approaching;
        public static final Direction leaving;

        public static Direction valueOf(String s)
        {
            return (Direction)Enum.valueOf(com/pointinside/location/geofence/VenueProximityState$Direction, s);
        }

        public static Direction[] values()
        {
            return (Direction[])$VALUES.clone();
        }

        static 
        {
            approaching = new Direction("approaching", 0);
            leaving = new Direction("leaving", 1);
            $VALUES = (new Direction[] {
                approaching, leaving
            });
        }

        private Direction(String s, int i)
        {
            super(s, i);
        }
    }

    static class Factory
    {

        public static VenueProximityState buildOn(VenueProximityState venueproximitystate, VenueEntity venueentity, Location location)
        {
            if (venueentity == null)
            {
                return venueproximitystate;
            } else
            {
                return (new Builder(venueproximitystate)).updateDirection(location).setVenueLocation(venueentity).super.updateDistance(location).super.updateProximityState(location).build();
            }
        }

        public static VenueProximityState disable(VenueProximityState venueproximitystate)
        {
            return (new Builder(venueproximitystate)).setVenueLocation(venueproximitystate.venueLocation).setDistance(venueproximitystate.distance).setDirection(venueproximitystate.direction).setProximityState(Type.DISABLED).build();
        }

        public static VenueProximityState zeroState()
        {
            return (new Builder()).build();
        }

        Factory()
        {
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type DISABLED;
        public static final Type IN_VENUE_CONFIRMED;
        public static final Type NEAR_VENUE;
        public static final Type OUT_OF_VENUE;
        public static final Type UNKNOWN;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/pointinside/location/geofence/VenueProximityState$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            DISABLED = new Type("DISABLED", 0);
            UNKNOWN = new Type("UNKNOWN", 1);
            OUT_OF_VENUE = new Type("OUT_OF_VENUE", 2);
            NEAR_VENUE = new Type("NEAR_VENUE", 3);
            IN_VENUE_CONFIRMED = new Type("IN_VENUE_CONFIRMED", 4);
            $VALUES = (new Type[] {
                DISABLED, UNKNOWN, OUT_OF_VENUE, NEAR_VENUE, IN_VENUE_CONFIRMED
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

    public static class VenueLocation extends Location
    {

        public final VenueEntity venue;

        public VenueLocation(VenueEntity venueentity)
        {
            super(new Location("com.pointinside.feeds.client.model.maps.Venue"));
            if (venueentity != null)
            {
                venue = venueentity;
                setLatitude(venueentity.latitude);
                setLongitude(venueentity.longitude);
                return;
            } else
            {
                venue = null;
                return;
            }
        }
    }


    private static final String VENUE_PROVIDED_LOCATION = "com.pointinside.feeds.client.model.maps.Venue";
    public final Direction direction;
    public final float distance;
    public final Type type;
    public final VenueLocation venueLocation;

    private VenueProximityState(float f, VenueLocation venuelocation, Type type1, Direction direction1)
    {
        distance = f;
        venueLocation = venuelocation;
        type = type1;
        direction = direction1;
    }

}
