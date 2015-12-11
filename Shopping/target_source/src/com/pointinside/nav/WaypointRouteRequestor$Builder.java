// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;


// Referenced classes of package com.pointinside.nav:
//            WaypointRouteRequestor, RouteException

public static final class  extends 
{

    private boolean mPreserveOrder;

    public WaypointRouteRequestor build()
        throws RouteException
    {
        return new WaypointRouteRequestor(this, null);
    }

    public  setPreserveOrder(boolean flag)
    {
        mPreserveOrder = flag;
        return this;
    }


    public ()
    {
    }
}
