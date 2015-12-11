// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class reakdown
{

    public ItemCurrency adjustmentsSubtotal;
    public ItemCurrency handlingSubtotal;
    public ItemCurrency importChargesSubtotal;
    public ItemCurrency incentiveTotal;
    public ItemCurrency insuranceSubtotal;
    public ItemCurrency otherFeesSubtotal;
    public ItemCurrency priceSubtotal;
    public ItemCurrency promotionSavingsTotal;
    public ItemCurrency savingsAmount;
    public ItemCurrency shippingSubtotal;
    public reakdown shippingSubtotalBreakdown;
    public ItemCurrency taxSubtotal;
    public ItemCurrency total;

    public reakdown()
    {
    }
}
