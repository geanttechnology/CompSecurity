// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.dealbreakdown.DealBreakdownAddress;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu

public class 
{

    public static void inject(com.f2prateek.dart.r r, ShippingAddressEu shippingaddresseu, Object obj)
    {
        ject(r, shippingaddresseu, obj);
        Object obj1 = r.inject(obj, "shippingAddress");
        if (obj1 != null)
        {
            shippingaddresseu.existingAddress = (DealBreakdownAddress)obj1;
        }
        r = ((com.f2prateek.dart.s) (r.s(obj, "isShippingAddress")));
        if (r != null)
        {
            shippingaddresseu.isShippingAddress = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
