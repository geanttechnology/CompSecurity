// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class GiftOptionItem
{

    private String desc;
    private String giftMessage;
    private List giftOption;
    private String lineItemId;

    public GiftOptionItem()
    {
    }

    public void setDesc(String s)
    {
        desc = s;
    }

    public void setGiftMessage(String s)
    {
        giftMessage = s;
    }

    public void setGiftOption(List list)
    {
        giftOption = list;
    }

    public void setLineItemId(String s)
    {
        lineItemId = s;
    }
}
