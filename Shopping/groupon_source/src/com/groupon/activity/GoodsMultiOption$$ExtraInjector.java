// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            GoodsMultiOption

public class 
{

    public static void inject(com.f2prateek.dart.r r, GoodsMultiOption goodsmultioption, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        goodsmultioption.dealId = (String)obj1;
        obj1 = r.r(obj, "traitCount");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'traitCount' for field 'traitCount' was not found. If this extra is optional add '@Optional' annotation.");
        }
        goodsmultioption.traitCount = (Integer)obj1;
        obj1 = r.r(obj, "num_deal_activities_on_stack");
        if (obj1 != null)
        {
            goodsmultioption.numDealActivitiesInStack = ((Integer)obj1).intValue();
        }
        obj1 = r.tiesInStack(obj, "goods_category_extra_info");
        if (obj1 != null)
        {
            goodsmultioption.goodsExtraInfo = (String)obj1;
        }
        r = ((com.f2prateek.dart.o) (r.o(obj, "channel")));
        if (r != null)
        {
            goodsmultioption.channel = (Channel)r;
        }
    }

    public ()
    {
    }
}
