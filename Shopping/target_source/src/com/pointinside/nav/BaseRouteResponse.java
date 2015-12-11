// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.nav:
//            IRouteWaypoint, RouteWaypoint

abstract class BaseRouteResponse
{

    Map mWaypointToIWaypoint;

    BaseRouteResponse(Map map)
    {
        mWaypointToIWaypoint = map;
    }

    public abstract IRouteWaypoint getEndWaypoint();

    IRouteWaypoint getIRouteWaypoint(RouteWaypoint routewaypoint)
    {
        routewaypoint = (IRouteWaypoint)mWaypointToIWaypoint.get(routewaypoint);
        if (routewaypoint == null)
        {
            throw new IllegalStateException("Specified RouteWaypoint not found in Waypoint List.The underlying waypoint list has been changed. Cannot proceed");
        } else
        {
            return routewaypoint;
        }
    }

    public abstract IRouteWaypoint getStartWaypoint();

    public abstract String getStatus();

    public abstract List getUnknownWaypoints();
}
