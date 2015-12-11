// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class Amount
{

    public String convertedFromCurrency;
    public Double convertedFromValue;
    public String currency;
    public double value;

    public Amount()
    {
    }

    public String getCurrency(boolean flag)
    {
        if (!flag && hasConvertedAmount())
        {
            return convertedFromCurrency;
        } else
        {
            return currency;
        }
    }

    public double getValue(boolean flag)
    {
        if (!flag && hasConvertedAmount())
        {
            return convertedFromValue.doubleValue();
        } else
        {
            return value;
        }
    }

    boolean hasConvertedAmount()
    {
        return convertedFromValue != null && convertedFromCurrency != null;
    }
}
