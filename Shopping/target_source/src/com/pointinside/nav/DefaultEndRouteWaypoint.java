// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import android.os.Parcel;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteWaypoint, RouteException

public class DefaultEndRouteWaypoint extends BaseRouteWaypoint
{

    private DefaultEndRouteWaypoint()
    {
        mType = BaseRouteWaypoint.WaypointType.DefaultEnd;
    }

    private DefaultEndRouteWaypoint(Parcel parcel)
    {
    }

    public static DefaultEndRouteWaypoint getDefaultEndRouteWaypoint()
    {
        return new DefaultEndRouteWaypoint();
    }

    public int describeContents()
    {
        return 0;
    }

    public BaseRouteWaypoint getWaypoint()
        throws RouteException
    {
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
    }
}
