// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            CouponDetailsDealImageCarousel

public class 
{

    public static void inject(com.f2prateek.dart.r r, CouponDetailsDealImageCarousel coupondetailsdealimagecarousel, Object obj)
    {
        (r, coupondetailsdealimagecarousel, obj);
        r = ((com.f2prateek.dart.r) (r.r(obj, "coupon_toast_message")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'coupon_toast_message' for field 'toastMessage' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            coupondetailsdealimagecarousel.toastMessage = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
