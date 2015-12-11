// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.j.b:
//            d

public class f
{

    private static final int ORDER_INDEX = 0;
    private List mOrderDetailsList;

    public f()
    {
    }

    public d a()
    {
        if (mOrderDetailsList == null || mOrderDetailsList.isEmpty())
        {
            return null;
        } else
        {
            return (d)mOrderDetailsList.get(0);
        }
    }
}
