// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks

public class 
{

    public static void inject(com.f2prateek.dart.r r, AbstractThanks abstractthanks, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            abstractthanks.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            abstractthanks.channel = (Channel)obj1;
        }
        obj1 = r.r(obj, "orderID");
        if (obj1 != null)
        {
            abstractthanks.orderId = (String)obj1;
        }
        obj1 = r.r(obj, "multiItemOrderId");
        if (obj1 != null)
        {
            abstractthanks.multiItemOrderId = (String)obj1;
        }
        r = ((com.f2prateek.dart.rId) (r.rId(obj, "hide_purchased_deal_info")));
        if (r != null)
        {
            abstractthanks.hidePurchasedDealInfo = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
