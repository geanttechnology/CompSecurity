// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.b;

import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.Currency;

public class d
{

    private String mCurrencyCode;
    private String mFormattedPriceValue;
    private String mPriceValue;

    public d()
    {
    }

    public Currency a()
    {
        if (mCurrencyCode != null)
        {
            return Currency.getInstance(mCurrencyCode);
        } else
        {
            return c.USD;
        }
    }

    public String b()
    {
        return mFormattedPriceValue;
    }

    public BigDecimal c()
    {
        if (mPriceValue != null)
        {
            return new BigDecimal(mPriceValue);
        } else
        {
            return null;
        }
    }
}
