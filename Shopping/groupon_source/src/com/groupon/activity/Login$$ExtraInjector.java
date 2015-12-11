// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            Login

public class 
{

    public static void inject(com.f2prateek.dart.r r, Login login, Object obj)
    {
        Object obj1 = r.r(obj, "next");
        if (obj1 != null)
        {
            login.next = (Intent)obj1;
        }
        obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            login.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "optionId");
        if (obj1 != null)
        {
            login.optionId = (String)obj1;
        }
        obj1 = r.r(obj, "comingFromCheckout");
        if (obj1 != null)
        {
            login.isComingFromCheckout = (Boolean)obj1;
        }
        obj1 = r.heckout(obj, "channel");
        if (obj1 != null)
        {
            login.channel = (Channel)obj1;
        }
        obj1 = r.heckout(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            login.itemsCount = (Integer)obj1;
        }
        obj1 = r.heckout(obj, "max_cart_discount");
        if (obj1 != null)
        {
            login.maxCartDiscount = (String)obj1;
        }
        obj1 = r.nt(obj, "cart_deal_image_url");
        if (obj1 != null)
        {
            login.cartDealImageUrl = (String)obj1;
        }
        obj1 = r.Url(obj, "goToCarouselOnUpOrBackPress");
        if (obj1 != null)
        {
            login.shouldGoToCarousel = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.ousel) (r.ousel(obj, "FROM_ONBOARDING")));
        if (r != null)
        {
            login.fromOnboarding = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
