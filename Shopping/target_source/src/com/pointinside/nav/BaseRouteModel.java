// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.json.JSONResponse;
import java.util.List;

// Referenced classes of package com.pointinside.nav:
//            RouteWaypoint

abstract class BaseRouteModel extends JSONResponse
{

    RouteWaypoint end;
    RouteWaypoint start;
    List unknownWaypoints;
    String venue;

    BaseRouteModel()
    {
    }

    public Object getData()
    {
        return this;
    }
}
