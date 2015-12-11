// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.net.EndpointType;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteRequestor, RouteException, WaypointOrderModel, OrderedWaypoints, 
//            BaseRouteURLBuilder

public class WaypointOrderRequestor extends BaseRouteRequestor
{
    public static final class Builder extends BaseRouteRequestor.Builder
    {

        public WaypointOrderRequestor build()
            throws RouteException
        {
            return new WaypointOrderRequestor(this);
        }

        public Builder()
        {
        }
    }

    static class WaypointOrderURLBuilder extends BaseRouteURLBuilder
    {

        public WaypointOrderURLBuilder()
        {
            super(EndpointType.ROUTE_ORDER, null);
        }
    }


    private WaypointOrderRequestor(Builder builder)
        throws RouteException
    {
        super(new WaypointOrderURLBuilder(), new WaypointOrderModel(), builder);
    }


    public OrderedWaypoints execute()
        throws RouteException
    {
        return fetchOrderedWaypoints();
    }

    public OrderedWaypoints fetchOrderedWaypoints()
        throws RouteException
    {
        return new OrderedWaypoints((WaypointOrderModel)fetch(), mMap);
    }
}
