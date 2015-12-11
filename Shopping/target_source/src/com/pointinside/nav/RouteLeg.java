// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.pointinside.nav:
//            RouteTimeDistance, RouteDestination, RouteLegModel, IRouteWaypoint

public class RouteLeg
    implements RouteTimeDistance
{

    private IRouteWaypoint mIRouteWaypoint;
    private RouteLegModel mModel;

    RouteLeg(RouteLegModel routelegmodel, IRouteWaypoint iroutewaypoint)
    {
        mModel = routelegmodel;
        mIRouteWaypoint = iroutewaypoint;
    }

    public RouteDestination getDestination()
    {
        return new RouteDestination(mModel.destination, mIRouteWaypoint);
    }

    public List getDirections()
    {
        return Collections.unmodifiableList(mModel.directions);
    }

    public double getDistance()
    {
        return mModel.distance;
    }

    public int getTime()
    {
        return mModel.time;
    }
}
