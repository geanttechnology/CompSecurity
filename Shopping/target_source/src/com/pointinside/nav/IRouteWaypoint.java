// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import android.os.Parcelable;

// Referenced classes of package com.pointinside.nav:
//            RouteException, BaseRouteWaypoint

public interface IRouteWaypoint
    extends Parcelable
{

    public abstract BaseRouteWaypoint getWaypoint()
        throws RouteException;
}
