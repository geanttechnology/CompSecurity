// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.maps.Location;

// Referenced classes of package com.pointinside.nav:
//            RouteTimeDistance

public class RouteDirection
    implements RouteTimeDistance
{
    public static final class TransportType extends Enum
    {

        private static final TransportType $VALUES[];
        public static final TransportType ELEVATOR;
        public static final TransportType ESCALATOR;
        public static final TransportType RAMP;
        public static final TransportType STAIRS;
        public static final TransportType WALKING;

        public static TransportType valueOf(String s)
        {
            return (TransportType)Enum.valueOf(com/pointinside/nav/RouteDirection$TransportType, s);
        }

        public static TransportType[] values()
        {
            return (TransportType[])$VALUES.clone();
        }

        static 
        {
            WALKING = new TransportType("WALKING", 0);
            ELEVATOR = new TransportType("ELEVATOR", 1);
            ESCALATOR = new TransportType("ESCALATOR", 2);
            STAIRS = new TransportType("STAIRS", 3);
            RAMP = new TransportType("RAMP", 4);
            $VALUES = (new TransportType[] {
                WALKING, ELEVATOR, ESCALATOR, STAIRS, RAMP
            });
        }

        private TransportType(String s, int i)
        {
            super(s, i);
        }
    }


    private double mDistance;
    private Location mLocation;
    private int mTime;
    private TransportType mTransportType;

    RouteDirection()
    {
    }

    public double getDistance()
    {
        return mDistance;
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public int getTime()
    {
        return mTime;
    }

    public TransportType getTransportType()
    {
        return mTransportType;
    }
}
