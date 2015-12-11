// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.net.EndpointType;
import java.util.HashMap;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteURLBuilder, WaypointRouteRequestor

static class  extends BaseRouteURLBuilder
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

    ()
    {
        super(EndpointType.ROUTE, null);
    }
}
