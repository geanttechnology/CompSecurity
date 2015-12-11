// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s

public class ap extends f
{

    private static final long LOAD_TIME_INSTANTANEOUS = 0L;
    private static final String ORDER_DETAILS_BROWSE_LEVEL = "order details";
    private static final String ORDER_HISTORY_BROWSE_LEVEL = "order history";

    private ap()
    {
    }

    public static ap j()
    {
        return new ap();
    }

    protected s c()
    {
        return s.OrderDetails;
    }

    protected List d()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("order history");
        arraylist.add("order details");
        return arraylist;
    }

    protected Long i()
    {
        return Long.valueOf(0L);
    }
}
