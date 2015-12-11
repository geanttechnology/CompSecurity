// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            ExternalPurchase

public class 
{

    public static void inject(com.f2prateek.dart.r r, ExternalPurchase externalpurchase, Object obj)
    {
        .inject(r, externalpurchase, obj);
        Object obj1 = r.inject(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        externalpurchase.dealId = (String)obj1;
        obj1 = r.inject(obj, "optionId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'optionId' for field 'dealOptionId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        externalpurchase.dealOptionId = (String)obj1;
        r = ((com.f2prateek.dart.or.inject) (r.inject(obj, "quantity")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'quantity' for field 'quantity' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            externalpurchase.quantity = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
