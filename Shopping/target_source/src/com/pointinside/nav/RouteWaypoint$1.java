// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import android.os.Parcel;

// Referenced classes of package com.pointinside.nav:
//            RouteWaypoint

static final class 
    implements android.os.or
{

    public RouteWaypoint createFromParcel(Parcel parcel)
    {
        return new RouteWaypoint(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RouteWaypoint[] newArray(int i)
    {
        return new RouteWaypoint[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
