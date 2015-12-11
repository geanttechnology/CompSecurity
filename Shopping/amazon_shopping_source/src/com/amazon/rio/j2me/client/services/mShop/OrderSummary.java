// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class OrderSummary
{

    private Boolean giftCardPresent;
    private String giftCardPromoSubtotal;
    private List subtotalSection;

    public OrderSummary()
    {
    }

    public void setGiftCardPresent(Boolean boolean1)
    {
        giftCardPresent = boolean1;
    }

    public void setGiftCardPromoSubtotal(String s)
    {
        giftCardPromoSubtotal = s;
    }

    public void setSubtotalSection(List list)
    {
        subtotalSection = list;
    }
}
