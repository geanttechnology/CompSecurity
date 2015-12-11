// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType, ItemCurrency

public static class _cls9
{

    public String convertedFromCurrency;
    public Double convertedFromValue;
    public String currency;
    public double value;

    public final ItemCurrency getAmount()
    {
        if (hasConvertedAmount())
        {
            return new ItemCurrency(convertedFromCurrency, convertedFromValue.toString());
        } else
        {
            return new ItemCurrency(currency, Double.toString(value));
        }
    }

    public final ItemCurrency getConvertedAmount()
    {
        ItemCurrency itemcurrency = null;
        if (hasConvertedAmount())
        {
            itemcurrency = new ItemCurrency(currency, Double.toString(value));
        }
        return itemcurrency;
    }

    boolean hasConvertedAmount()
    {
        return convertedFromValue != null && convertedFromCurrency != null;
    }

    public _cls9()
    {
    }
}
