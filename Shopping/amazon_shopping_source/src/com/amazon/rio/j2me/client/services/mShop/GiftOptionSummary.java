// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class GiftOptionSummary
{

    private List giftOptionItem;
    private String orderId;
    private Boolean printPrice;

    public GiftOptionSummary()
    {
    }

    public void setGiftOptionItem(List list)
    {
        giftOptionItem = list;
    }

    public void setOrderId(String s)
    {
        orderId = s;
    }

    public void setPrintPrice(Boolean boolean1)
    {
        printPrice = boolean1;
    }
}
