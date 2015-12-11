// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import java.util.List;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteModel

class WaypointRouteModel extends BaseRouteModel
{

    double distance;
    List legs;
    int time;

    WaypointRouteModel()
    {
    }

    public Object getData()
    {
        return this;
    }
}
