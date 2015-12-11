// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            FreeRentalLineModel

public static class 
{

    public FreeRentalLineModel build(Prices prices, Shipping shipping)
    {
        prices = ProductUtil.getShipping(prices, shipping);
        if (prices == null || prices.getPrime() == null || !prices.getPrime().getHasFreeRental() || TextUtils.isEmpty(prices.getPrime().getFreeRentalLabel()))
        {
            return null;
        } else
        {
            shipping = new FreeRentalLineModel();
            FreeRentalLineModel.access$000(shipping, prices.getPrime().getFreeRentalLabel());
            return shipping;
        }
    }

    public ()
    {
    }
}
