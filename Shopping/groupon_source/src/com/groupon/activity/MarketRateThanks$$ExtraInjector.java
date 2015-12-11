// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            MarketRateThanks

public class 
{

    public static void inject(com.f2prateek.dart.r r, MarketRateThanks marketratethanks, Object obj)
    {
        Object obj1 = r.r(obj, "hotel_name");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_name' for field 'hotelName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratethanks.hotelName = (String)obj1;
        obj1 = r.r(obj, "order_still_processing");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'order_still_processing' for field 'orderStillProcessing' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratethanks.orderStillProcessing = ((Boolean)obj1).booleanValue();
        obj1 = r.cessing(obj, "dealId");
        if (obj1 != null)
        {
            marketratethanks.dealId = (String)obj1;
        }
        r = ((com.f2prateek.dart.cessing) (r.cessing(obj, "channel")));
        if (r != null)
        {
            marketratethanks.channel = (Channel)r;
        }
    }

    public ()
    {
    }
}
