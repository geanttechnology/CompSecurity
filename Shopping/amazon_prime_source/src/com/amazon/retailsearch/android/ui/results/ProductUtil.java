// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import com.amazon.retailsearch.data.BadgeType;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class ProductUtil
{

    public ProductUtil()
    {
    }

    public static String formatNumber(long l)
    {
        return NumberFormat.getInstance().format(l);
    }

    public static String getPrimeProgramBadgeId(Shipping shipping)
    {
label0:
        {
            if (shipping == null)
            {
                break label0;
            }
            if (shipping.getPrime() != null && shipping.getPrime().getHasBadge())
            {
                return shipping.getPrime().getBadgeAssetId();
            }
            if (shipping.getAdditionalStatus() == null || shipping.getAdditionalStatus().isEmpty())
            {
                break label0;
            }
            shipping = shipping.getAdditionalStatus().iterator();
            ShippingStatus shippingstatus;
            do
            {
                if (!shipping.hasNext())
                {
                    break label0;
                }
                shippingstatus = (ShippingStatus)shipping.next();
            } while (!shippingstatus.getHasBadge());
            return shippingstatus.getBadgeAssetId();
        }
        return null;
    }

    public static Shipping getShipping(Prices prices, Shipping shipping)
    {
        Shipping shipping1 = shipping;
        if (prices != null)
        {
            shipping1 = shipping;
            if (prices.getEditions() != null)
            {
                shipping1 = shipping;
                if (!prices.getEditions().isEmpty())
                {
                    shipping1 = ((EditionsPriceInfo)prices.getEditions().get(0)).getShipping();
                }
            }
        }
        return shipping1;
    }

    public static boolean hasAutoRipBadge(Shipping shipping)
    {
        if (shipping != null && shipping.getAdditionalStatus() != null && !shipping.getAdditionalStatus().isEmpty()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        shipping = shipping.getAdditionalStatus().iterator();
        ShippingStatus shippingstatus;
        do
        {
            if (!shipping.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            shippingstatus = (ShippingStatus)shipping.next();
        } while (!shippingstatus.getHasBadge() || !BadgeType.AUTO_RIP.getBadgeId().equals(shippingstatus.getBadgeAssetId()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
