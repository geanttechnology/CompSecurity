// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import android.os.Parcel;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteWaypoint, RouteException

public class DefaultStartRouteWaypoint extends BaseRouteWaypoint
{

    private DefaultStartRouteWaypoint()
    {
        mType = BaseRouteWaypoint.WaypointType.DefaultStart;
    }

    private DefaultStartRouteWaypoint(Parcel parcel)
    {
    }

    public static DefaultStartRouteWaypoint getDefaultStartRouteWaypoint()
    {
        return new DefaultStartRouteWaypoint();
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
        parcel.writeSerializable(mType);
    }
}
