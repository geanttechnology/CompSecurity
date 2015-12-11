// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            CancelOrder

public class 
{

    public static void inject(com.f2prateek.dart.r r, CancelOrder cancelorder, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        cancelorder.dealId = (String)obj1;
        obj1 = r.r(obj, "orderID");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'orderID' for field 'orderId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        cancelorder.orderId = (String)obj1;
        obj1 = r.r(obj, "optionId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'optionId' for field 'optionId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        cancelorder.optionId = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "cancel_order_from_thank_you")));
        if (r != null)
        {
            cancelorder.fromThankYouScreen = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
