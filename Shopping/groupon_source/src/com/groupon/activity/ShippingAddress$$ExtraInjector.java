// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.Channel;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress

public class s
{

    public static void inject(com.f2prateek.dart.r r, ShippingAddress shippingaddress, Object obj)
    {
        Object obj1 = r.r(obj, "secondShippingAddress");
        if (obj1 != null)
        {
            shippingaddress.otherAddress = (DealBreakdownAddress)obj1;
        }
        obj1 = r.ess(obj, "dealId");
        if (obj1 != null)
        {
            shippingaddress.dealId = (String)obj1;
        }
        obj1 = r.ess(obj, "cart_uuid");
        if (obj1 != null)
        {
            shippingaddress.cartUUID = (String)obj1;
        }
        obj1 = r.ess(obj, "firstShippingAddress");
        if (obj1 != null)
        {
            shippingaddress.defaultAddress = (DealBreakdownAddress)obj1;
        }
        obj1 = r.ess(obj, "next");
        if (obj1 != null)
        {
            shippingaddress.next = (Intent)obj1;
        }
        obj1 = r.ess(obj, "optionId");
        if (obj1 != null)
        {
            shippingaddress.optionId = (String)obj1;
        }
        obj1 = r.ess(obj, "channel");
        if (obj1 != null)
        {
            shippingaddress.channel = (Channel)obj1;
        }
        obj1 = r.ess(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            shippingaddress.itemsCount = (Integer)obj1;
        }
        obj1 = r.ess(obj, "max_cart_discount");
        if (obj1 != null)
        {
            shippingaddress.maxCartDiscount = (String)obj1;
        }
        obj1 = r.nt(obj, "cart_deal_image_url");
        if (obj1 != null)
        {
            shippingaddress.cartDealImageUrl = (String)obj1;
        }
        r = ((com.f2prateek.dart.Url) (r.Url(obj, "is_master_address")));
        if (r != null)
        {
            shippingaddress.isMasterAddress = ((Boolean)r).booleanValue();
        }
    }

    public s()
    {
    }
}
