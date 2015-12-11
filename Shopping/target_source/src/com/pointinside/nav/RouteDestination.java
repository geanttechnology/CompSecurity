// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.maps.Location;

// Referenced classes of package com.pointinside.nav:
//            RouteDestinationModel, IRouteWaypoint

public class RouteDestination
{
    public static final class OrientationType extends Enum
    {

        private static final OrientationType $VALUES[];
        public static final OrientationType AHEAD;
        public static final OrientationType LEFT;
        public static final OrientationType RIGHT;

        public static OrientationType valueOf(String s)
        {
            return (OrientationType)Enum.valueOf(com/pointinside/nav/RouteDestination$OrientationType, s);
        }

        public static OrientationType[] values()
        {
            return (OrientationType[])$VALUES.clone();
        }

        static 
        {
            LEFT = new OrientationType("LEFT", 0);
            RIGHT = new OrientationType("RIGHT", 1);
            AHEAD = new OrientationType("AHEAD", 2);
            $VALUES = (new OrientationType[] {
                LEFT, RIGHT, AHEAD
            });
        }

        private OrientationType(String s, int i)
        {
            super(s, i);
        }
    }


    private IRouteWaypoint mIRouteWaypoint;
    RouteDestinationModel model;

    RouteDestination(RouteDestinationModel routedestinationmodel, IRouteWaypoint iroutewaypoint)
    {
        model = routedestinationmodel;
        mIRouteWaypoint = iroutewaypoint;
    }

    public Location getLocation()
    {
        return model.location;
    }

    public OrientationType getOrientationType()
    {
        return model.orientation;
    }

    public IRouteWaypoint getWaypoint()
    {
        return mIRouteWaypoint;
    }
}
