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
//            BaseRouteResponse, WaypointOrderModel, RouteDestinationModel, RouteDestination, 
//            RouteWaypoint, IRouteWaypoint

public class OrderedWaypoints extends BaseRouteResponse
{

    private WaypointOrderModel mModel;

    OrderedWaypoints(WaypointOrderModel waypointordermodel, Map map)
    {
        super(map);
        mModel = waypointordermodel;
    }

    public List getDestinations()
    {
        ArrayList arraylist = new ArrayList();
        RouteDestinationModel routedestinationmodel;
        for (Iterator iterator = mModel.destinations.iterator(); iterator.hasNext(); arraylist.add(new RouteDestination(routedestinationmodel, getIRouteWaypoint(routedestinationmodel.waypoint))))
        {
            routedestinationmodel = (RouteDestinationModel)iterator.next();
        }

        return Collections.unmodifiableList(arraylist);
    }

    public IRouteWaypoint getEndWaypoint()
    {
        RouteWaypoint routewaypoint = mModel.end;
        if (routewaypoint != null)
        {
            return getIRouteWaypoint(routewaypoint);
        } else
        {
            return null;
        }
    }

    public IRouteWaypoint getStartWaypoint()
    {
        return getIRouteWaypoint(mModel.start);
    }

    public String getStatus()
    {
        return mModel.status;
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
