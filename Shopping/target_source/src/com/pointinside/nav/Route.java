// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteResponse, RouteTimeDistance, WaypointRouteModel, RouteWaypoint, 
//            RouteLegModel, RouteDestinationModel, RouteLeg, IRouteWaypoint

public final class Route extends BaseRouteResponse
    implements RouteTimeDistance
{

    WaypointRouteModel mModel;
    List mRouteLegs;

    Route(WaypointRouteModel waypointroutemodel, Map map)
    {
        super(map);
        mModel = waypointroutemodel;
    }

    public double getDistance()
    {
        return mModel.distance;
    }

    public IRouteWaypoint getEndWaypoint()
    {
        RouteWaypoint routewaypoint = mModel.end;
        if (routewaypoint != null)
        {
            if (BaseRouteWaypoint.WaypointType.DefaultEnd == routewaypoint.getType())
            {
                return routewaypoint;
            } else
            {
                return getIRouteWaypoint(routewaypoint);
            }
        } else
        {
            return null;
        }
    }

    public List getLegs()
    {
        if (mRouteLegs == null)
        {
            mRouteLegs = new ArrayList();
            for (Iterator iterator = mModel.legs.iterator(); iterator.hasNext();)
            {
                RouteLegModel routelegmodel = (RouteLegModel)iterator.next();
                RouteWaypoint routewaypoint = routelegmodel.destination.waypoint;
                if (BaseRouteWaypoint.WaypointType.DefaultEnd == routewaypoint.getType() || BaseRouteWaypoint.WaypointType.DefaultStart == routewaypoint.getType())
                {
                    mRouteLegs.add(new RouteLeg(routelegmodel, routewaypoint));
                } else
                {
                    IRouteWaypoint iroutewaypoint = getIRouteWaypoint(routelegmodel.destination.waypoint);
                    mRouteLegs.add(new RouteLeg(routelegmodel, iroutewaypoint));
                }
            }

        }
        return Collections.unmodifiableList(mRouteLegs);
    }

    public IRouteWaypoint getStartWaypoint()
    {
        if (mModel.start != null && BaseRouteWaypoint.WaypointType.DefaultStart == mModel.start.getType())
        {
            return mModel.start;
        } else
        {
            return getIRouteWaypoint(mModel.start);
        }
    }

    public String getStatus()
    {
        return mModel.status;
    }

    public int getTime()
    {
        return mModel.time;
    }

    public List getUnknownWaypoints()
    {
        Object obj = mModel.unknownWaypoints;
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(getIRouteWaypoint((RouteWaypoint)((Iterator) (obj)).next()))) { }
        }
        return arraylist;
    }
}
