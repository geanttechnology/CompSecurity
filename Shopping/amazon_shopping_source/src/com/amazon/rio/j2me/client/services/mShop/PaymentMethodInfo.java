// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class PaymentMethodInfo
{

    private String header;
    private String headerDetails;
    private String instructions;
    private String name;
    private String paymentMethodId;

    public PaymentMethodInfo()
    {
    }

    public void setHeader(String s)
    {
        header = s;
    }

    public void setHeaderDetails(String s)
    {
        headerDetails = s;
    }

    public void setInstructions(String s)
    {
        instructions = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPaymentMethodId(String s)
    {
        paymentMethodId = s;
    }
}
