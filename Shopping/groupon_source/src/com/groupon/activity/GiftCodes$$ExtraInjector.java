// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

public class 
{

    public static void inject(com.f2prateek.dart.r r, GiftCodes giftcodes, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            giftcodes.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "optionId");
        if (obj1 != null)
        {
            giftcodes.optionId = (String)obj1;
        }
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            giftcodes.channel = (Channel)obj1;
        }
        obj1 = r.r(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            giftcodes.itemsCount = (Integer)obj1;
        }
        obj1 = r.r(obj, "max_cart_discount");
        if (obj1 != null)
        {
            giftcodes.maxCartDiscount = (String)obj1;
        }
        r = ((com.f2prateek.dart.nt) (r.nt(obj, "cart_deal_image_url")));
        if (r != null)
        {
            giftcodes.cartDealImageUrl = (String)r;
        }
    }

    public ()
    {
    }
}
