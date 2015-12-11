// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            RecommendedShippingService, ShippingZonalCost, CurrencyAmount

public class ShippingEstimate
    implements Serializable
{

    public final ArrayList costs = new ArrayList();
    public final RecommendedShippingService shippingService = new RecommendedShippingService();
    private boolean sorted;

    public ShippingEstimate()
    {
        sorted = false;
    }

    ShippingZonalCost getMaximumShippingCost()
    {
        if (!sorted)
        {
            Collections.sort(costs);
            sorted = true;
        }
        if (costs.size() > 0)
        {
            return (ShippingZonalCost)costs.get(costs.size() - 1);
        } else
        {
            return new ShippingZonalCost();
        }
    }

    ShippingZonalCost getMinimumShippingCost()
    {
        if (!sorted)
        {
            Collections.sort(costs);
            sorted = true;
        }
        if (costs.size() > 0)
        {
            return (ShippingZonalCost)costs.get(0);
        } else
        {
            return new ShippingZonalCost();
        }
    }

    public String getValueDisplay(String s)
    {
        String s1 = "";
        double d = getMinimumShippingCost().cost;
        double d1 = getMaximumShippingCost().cost;
        CurrencyAmount currencyamount = new CurrencyAmount(Double.toString(d), s);
        s = new CurrencyAmount(Double.toString(d1), s);
        if (d != d1)
        {
            s = (new StringBuilder()).append(currencyamount).append(" - ").append(s).toString();
        } else
        {
            s = s1;
            if (d > 0.0D)
            {
                return currencyamount.toString();
            }
        }
        return s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = costs.iterator(); iterator.hasNext(); stringbuilder.append(((ShippingZonalCost)iterator.next()).toString()).append("\n")) { }
        stringbuilder.append(shippingService);
        return stringbuilder.toString();
    }
}
