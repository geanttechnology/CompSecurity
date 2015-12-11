// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;


// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

public class 
{

    public static void inject(com.f2prateek.dart.traInjector trainjector, NewPurchaseCart newpurchasecart, Object obj)
    {
        com.groupon.activity.aInjector(trainjector, newpurchasecart, obj);
        trainjector = ((com.f2prateek.dart.t) (trainjector.t(obj, "coming_from_deal_details")));
        if (trainjector != null)
        {
            newpurchasecart.comingFromDealDetails = ((Boolean)trainjector).booleanValue();
        }
    }

    public ()
    {
    }
}
