// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            CouponDetails

public class ector
{

    public static void inject(com.f2prateek.dart.r r, CouponDetails coupondetails, Object obj)
    {
        ector.inject(r, coupondetails, obj);
        r = ((com.f2prateek.dart.njector.inject) (r.inject(obj, "couponId")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'couponId' for field 'couponId' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            coupondetails.couponId = (String)r;
            return;
        }
    }

    public ector()
    {
    }
}
