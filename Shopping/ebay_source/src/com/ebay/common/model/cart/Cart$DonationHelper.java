// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.text.DecimalFormat;
import java.util.List;

// Referenced classes of package com.ebay.common.model.cart:
//            Cart

public static final class 
{

    public static final String getDonationAmountAsString(Cart cart)
    {
        if (cart.donationAmount != null && cart.donationAmount.isGreaterThanZero())
        {
            return (new DecimalFormat("#.##")).format(cart.donationAmount.getValueAsDouble());
        } else
        {
            return null;
        }
    }

    public static final String getDonationCurrencyCode(Cart cart)
    {
        if (cart != null && cart.total != null)
        {
            return cart.total.getCurrencyCode();
        } else
        {
            return null;
        }
    }

    private static tCurrencyCode getDonationLineItem(Cart cart)
    {
        cart = cart.getDonationLineItems();
        if (cart != null)
        {
            return (Items)cart.get(0);
        } else
        {
            return null;
        }
    }

    public static final String getDonationLineItemId(Cart cart)
    {
        cart = getDonationLineItem(cart);
        if (cart == null)
        {
            return null;
        } else
        {
            return ((getDonationLineItem) (cart)).neItemId;
        }
    }

    public static final String getDonationName(Cart cart)
    {
        cart = getDonationLineItem(cart);
        if (cart == null)
        {
            return null;
        } else
        {
            return ((getDonationLineItem) (cart)).tle;
        }
    }

    public static final String getDonationNonprofitId(Cart cart)
    {
        cart = getDonationLineItem(cart);
        if (cart == null)
        {
            return null;
        } else
        {
            return ((getDonationLineItem) (cart)).fitId;
        }
    }

    public ()
    {
    }
}
