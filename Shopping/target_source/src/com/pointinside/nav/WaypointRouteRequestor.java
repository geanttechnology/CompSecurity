// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.EndpointType;
import java.util.HashMap;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteRequestor, RouteException, WaypointRouteModel, Route, 
//            BaseRouteURLBuilder

public class WaypointRouteRequestor extends BaseRouteRequestor
{
    public static final class Builder extends BaseRouteRequestor.Builder
    {

        private boolean mPreserveOrder;

        public WaypointRouteRequestor build()
            throws RouteException
        {
            return new WaypointRouteRequestor(this);
        }

        public Builder setPreserveOrder(boolean flag)
        {
            mPreserveOrder = flag;
            return this;
        }


        public Builder()
        {
        }
    }

    static class WaypointRouteURLBuilder extends BaseRouteURLBuilder
    {

        private static final String KEY_PRESERVE_ORDER = "preserveOrder";
        Boolean preserveOrder;

        public void onPrepareURL()
        {
            super.onPrepareURL();
            if (preserveOrder.booleanValue())
            {
                parameters.put("preserveOrder", String.valueOf(preserveOrder));
            }
        }

        WaypointRouteURLBuilder()
        {
            super(EndpointType.ROUTE, null);
        }
    }


    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/nav/WaypointRouteRequestor);
    private final boolean mPreserveOrder;

    private WaypointRouteRequestor(Builder builder)
        throws RouteException
    {
        super(new WaypointRouteURLBuilder(), new WaypointRouteModel(), builder);
        mPreserveOrder = builder.mPreserveOrder;
    }


    public Route fetchRoute()
        throws RouteException
    {
        WaypointRouteModel waypointroutemodel = (WaypointRouteModel)fetch();
        if (waypointroutemodel.legs == null)
        {
            throw new RouteException("Route legs are null. Something is wrong with fetched route. A route must have legs. Try to fetch route again or contact PointInside if you think there is an error in the upstream data");
        } else
        {
            return new Route(waypointroutemodel, mMap);
        }
    }

    void updateUrl()
    {
        super.updateUrl();
        ((WaypointRouteURLBuilder)URL).preserveOrder = Boolean.valueOf(mPreserveOrder);
    }

}
