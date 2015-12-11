// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.io.Serializable;

// Referenced classes of package com.groupon.models:
//            GenericAmountContainer

public class GenericAmount
    implements GenericAmountContainer, Serializable
{

    private int amount;
    private String currencyCode;
    private String formattedAmount;

    public GenericAmount()
    {
    }

    public GenericAmount(int i, String s, String s1)
    {
        amount = i;
        currencyCode = s;
        formattedAmount = s1;
    }

    public int getAmount()
    {
        return amount;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public String getFormattedAmount()
    {
        return formattedAmount;
    }

    public void setAmount(int i)
    {
        amount = i;
    }

    public void setCurrencyCode(String s)
    {
        currencyCode = s;
    }

    public void setFormattedAmount(String s)
    {
        formattedAmount = s;
    }
}
