// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class PaymentPlan
{

    private String creditCardId;
    private String desc;
    private String desc2;
    private String giftCardAmount;
    private String paymentMethodId;

    public PaymentPlan()
    {
    }

    public void setCreditCardId(String s)
    {
        creditCardId = s;
    }

    public void setDesc(String s)
    {
        desc = s;
    }

    public void setDesc2(String s)
    {
        desc2 = s;
    }

    public void setGiftCardAmount(String s)
    {
        giftCardAmount = s;
    }

    public void setPaymentMethodId(String s)
    {
        paymentMethodId = s;
    }
}
