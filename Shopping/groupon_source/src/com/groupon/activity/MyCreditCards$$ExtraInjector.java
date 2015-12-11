// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.os.Bundle;
import com.groupon.Channel;
import java.util.HashMap;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards

public class 
{

    public static void inject(com.f2prateek.dart.r r, MyCreditCards mycreditcards, Object obj)
    {
        Object obj1 = r.r(obj, "next");
        if (obj1 != null)
        {
            mycreditcards.next = (Intent)obj1;
        }
        obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            mycreditcards.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "optionId");
        if (obj1 != null)
        {
            mycreditcards.optionId = (String)obj1;
        }
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            mycreditcards.channel = (Channel)obj1;
        }
        obj1 = r.r(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            mycreditcards.itemsCount = (Integer)obj1;
        }
        obj1 = r.r(obj, "max_cart_discount");
        if (obj1 != null)
        {
            mycreditcards.maxCartDiscount = (String)obj1;
        }
        obj1 = r.nt(obj, "cart_deal_image_url");
        if (obj1 != null)
        {
            mycreditcards.cartDealImageUrl = (String)obj1;
        }
        obj1 = r.Url(obj, "cart_uuid");
        if (obj1 != null)
        {
            mycreditcards.cartUUID = (String)obj1;
        }
        obj1 = r.Url(obj, "available_payment_methods_for_deal");
        if (obj1 != null)
        {
            mycreditcards.dealPaymentMethodsNameTypePairs = (HashMap)obj1;
        }
        obj1 = r.thodsNameTypePairs(obj, "is_gdt");
        if (obj1 != null)
        {
            mycreditcards.isGdtDeal = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.thodsNameTypePairs(obj, "is_market_rate_deal");
        if (obj1 != null)
        {
            mycreditcards.isMarketRateDeal = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.eal(obj, "is_shopping_cart_flow");
        if (obj1 != null)
        {
            mycreditcards.isShoppingCartFlow = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.tFlow(obj, "is_currency_code_usd");
        if (obj1 != null)
        {
            mycreditcards.isCurrencyCodeUSD = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.eUSD) (r.eUSD(obj, "creditCardConsentRequirements")));
        if (r != null)
        {
            mycreditcards.storageConsentRequirements = (Bundle)r;
        }
    }

    public ()
    {
    }
}
