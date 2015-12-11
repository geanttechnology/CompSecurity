// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import com.pointinside.maps.PIMapError;
import com.pointinside.nav.Route;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pointinside.maps.model:
//            MapRouteStyle

public class RouteOverlayOptions
{

    Route mRoute;
    List mRouteLegsStyle;
    MapRouteStyle mRouteStyle;

    public RouteOverlayOptions(Route route)
        throws PIMapError
    {
        if (route == null)
        {
            throw PIMapError.generateError(com.pointinside.maps.PIMapError.Kind.ROUTE, "Route cannot be null", new IllegalArgumentException());
        } else
        {
            mRoute = route;
            mRouteStyle = new MapRouteStyle();
            mRouteLegsStyle = new ArrayList(route.getLegs().size());
            return;
        }
    }

    public MapRouteStyle getLegStyle(int i)
    {
        MapRouteStyle maproutestyle;
        try
        {
            maproutestyle = (MapRouteStyle)mRouteLegsStyle.get(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return null;
        }
        return maproutestyle;
    }

    public MapRouteStyle getMapRouteStyle()
    {
        return mRouteStyle;
    }

    public Route getRoute()
    {
        return mRoute;
    }

    public RouteOverlayOptions setMapRouteStyle(MapRouteStyle maproutestyle)
    {
        mRouteStyle = MapRouteStyle.copy(maproutestyle);
        return this;
    }

    public void setRouteLegStyleForRange(MapRouteStyle maproutestyle, int i, int j)
    {
        if (maproutestyle == null) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        l = mRoute.getLegs().size();
        k = i;
_L5:
        if (k < i + j && k <= l - 1) goto _L3; else goto _L2
_L2:
        return;
_L3:
        mRouteLegsStyle.add(k, MapRouteStyle.copy(maproutestyle));
        k++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
