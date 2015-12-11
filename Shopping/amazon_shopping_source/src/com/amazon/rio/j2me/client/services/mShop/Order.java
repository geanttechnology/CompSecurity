// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            RichMessage

public class Order
{

    private List item;
    private String merchantName;
    private String orderId;
    private RichMessage shippingMessage;
    private List shippingOption;
    private List shippingSpeed;
    private List status;

    public Order()
    {
    }

    public void setItem(List list)
    {
        item = list;
    }

    public void setMerchantName(String s)
    {
        merchantName = s;
    }

    public void setOrderId(String s)
    {
        orderId = s;
    }

    public void setShippingMessage(RichMessage richmessage)
    {
        shippingMessage = richmessage;
    }

    public void setShippingOption(List list)
    {
        shippingOption = list;
    }

    public void setShippingSpeed(List list)
    {
        shippingSpeed = list;
    }

    public void setStatus(List list)
    {
        status = list;
    }
}
