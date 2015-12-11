// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

public class 
{

    public static void inject(com.f2prateek.dart.r r, DeliveryAddresses deliveryaddresses, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            deliveryaddresses.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "optionId");
        if (obj1 != null)
        {
            deliveryaddresses.optionId = (String)obj1;
        }
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            deliveryaddresses.channel = (Channel)obj1;
        }
        obj1 = r.r(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            deliveryaddresses.itemsCount = (Integer)obj1;
        }
        obj1 = r.r(obj, "max_cart_discount");
        if (obj1 != null)
        {
            deliveryaddresses.maxCartDiscount = (String)obj1;
        }
        obj1 = r.nt(obj, "cart_deal_image_url");
        if (obj1 != null)
        {
            deliveryaddresses.cartDealImageUrl = (String)obj1;
        }
        obj1 = r.Url(obj, "firstShippingAddress");
        if (obj1 != null)
        {
            deliveryaddresses.defaultAddress = (DealBreakdownAddress)obj1;
        }
        r = ((com.f2prateek.dart.s) (r.s(obj, "isShippingAddress")));
        if (r != null)
        {
            deliveryaddresses.isShippingAddress = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
