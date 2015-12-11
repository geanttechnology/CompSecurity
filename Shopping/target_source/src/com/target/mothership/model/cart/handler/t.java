// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.z;
import java.util.Iterator;
import java.util.List;

public class t
    implements aa
{

    public t()
    {
    }

    public z a(List list)
    {
        if (list == null)
        {
            return null;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            z z1 = (z)list.next();
            if (z1.i().c() != a.TARGET_GIFT_CARD && z1.c() != a.PAYPAL)
            {
                return z1;
            }
        }

        return null;
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }
}
