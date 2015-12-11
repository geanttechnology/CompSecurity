// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;


// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryActivity

public class 
{

    public static void inject(com.f2prateek.dart.traInjector trainjector, CartSummaryActivity cartsummaryactivity, Object obj)
    {
        Object obj1 = trainjector.traInjector(obj, "coming_from_deal_details");
        if (obj1 != null)
        {
            cartsummaryactivity.comingFromDealDetails = ((Boolean)obj1).booleanValue();
        }
        trainjector = ((com.f2prateek.dart.ingFromDealDetails) (trainjector.getExtra(obj, "isDeepLinked")));
        if (trainjector != null)
        {
            cartsummaryactivity.isDeepLinked = ((Boolean)trainjector).booleanValue();
        }
    }

    public ()
    {
    }
}
