// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class PaymentMethod
{

    private String brand;
    private String cardId;
    private String gcAmount;
    private String gcCurrency;
    private String gcDisplay;
    private String issuer;
    private String method;
    private String month;
    private String name;
    private String number;
    private String year;

    public PaymentMethod()
    {
    }

    public String getCardId()
    {
        return cardId;
    }

    public String getIssuer()
    {
        return issuer;
    }

    public String getMethod()
    {
        return method;
    }

    public String getMonth()
    {
        return month;
    }

    public String getNumber()
    {
        return number;
    }

    public String getYear()
    {
        return year;
    }

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setCardId(String s)
    {
        cardId = s;
    }

    public void setGcAmount(String s)
    {
        gcAmount = s;
    }

    public void setGcCurrency(String s)
    {
        gcCurrency = s;
    }

    public void setGcDisplay(String s)
    {
        gcDisplay = s;
    }

    public void setIssuer(String s)
    {
        issuer = s;
    }

    public void setMethod(String s)
    {
        method = s;
    }

    public void setMonth(String s)
    {
        month = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setNumber(String s)
    {
        number = s;
    }

    public void setYear(String s)
    {
        year = s;
    }
}
