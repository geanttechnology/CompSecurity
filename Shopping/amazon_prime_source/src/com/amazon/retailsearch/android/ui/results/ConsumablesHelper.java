// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductViewModel

public class ConsumablesHelper
{

    private static final String CONSUMABLES = "consumables";

    private ConsumablesHelper()
    {
    }

    public static boolean isConsumablesProduct(ProductViewModel productviewmodel)
    {
        if (productviewmodel.getProduct() != null && productviewmodel.getProduct().getPrices() != null)
        {
            return "consumables".equalsIgnoreCase(productviewmodel.getProduct().getPrices().getEditionsType());
        } else
        {
            return false;
        }
    }
}
