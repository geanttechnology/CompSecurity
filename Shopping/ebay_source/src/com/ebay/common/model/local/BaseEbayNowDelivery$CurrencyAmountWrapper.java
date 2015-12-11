// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;

// Referenced classes of package com.ebay.common.model.local:
//            BaseEbayNowDelivery

public static class currency
{

    protected final String amt;
    protected final String currency;

    public CurrencyAmount asCurrencyAmount()
    {
        if (!TextUtils.isEmpty(amt) && !TextUtils.isEmpty(currency))
        {
            return new CurrencyAmount(amt, currency);
        } else
        {
            return null;
        }
    }

    public String getAmt()
    {
        return amt;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String toString()
    {
        return (new StringBuilder()).append("CurrencyAmountWrapper [amount=").append(asCurrencyAmount()).append("]").toString();
    }

    public (CurrencyAmount currencyamount)
    {
        this(String.valueOf(currencyamount.getValueAsDouble()), currencyamount.getCurrencyCode());
    }

    public <init>(String s, String s1)
    {
        amt = s;
        currency = s1;
    }
}
