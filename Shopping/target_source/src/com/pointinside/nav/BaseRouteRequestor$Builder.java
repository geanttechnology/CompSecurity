// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteRequestor, IRouteWaypoint

public static abstract class mWaypoints
{

    private IRouteWaypoint mEndPoint;
    private IRouteWaypoint mStartPoint;
    private String mStoreId;
    private String mVenueUuid;
    private List mWaypoints;
    private String mWeighting;

    public mWaypoints setEndPoint(IRouteWaypoint iroutewaypoint)
    {
        mEndPoint = iroutewaypoint;
        return this;
    }

    public mEndPoint setStartPoint(IRouteWaypoint iroutewaypoint)
    {
        mStartPoint = iroutewaypoint;
        return this;
    }

    public mStartPoint setStoreId(String s)
    {
        mStoreId = s;
        return this;
    }

    public mStoreId setVenueUuid(String s)
    {
        mVenueUuid = s;
        return this;
    }

    public mVenueUuid setWaypoints(List list)
    {
        mWaypoints = list;
        return this;
    }

    public mWaypoints setWeightingAlgorithm(String s)
    {
        mWeighting = s;
        return this;
    }







    public ()
    {
        mWeighting = null;
        mVenueUuid = null;
        mStoreId = null;
        mStartPoint = null;
        mEndPoint = null;
        mWaypoints = new ArrayList();
    }
}
