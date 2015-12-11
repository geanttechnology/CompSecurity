// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            EditOrder

public class 
{

    public static void inject(com.f2prateek.dart.r r, EditOrder editorder, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        editorder.dealId = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "orderID")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'orderID' for field 'orderId' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            editorder.orderId = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
