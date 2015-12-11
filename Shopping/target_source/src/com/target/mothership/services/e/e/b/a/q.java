// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.a;

import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.Currency;

public class q
{

    private String mCurrentPriceRangeMax;
    private String mCurrentPriceRangeMin;
    private String mCurrentPriceRangeText;
    private String mOriginalPriceRangeMax;
    private String mOriginalPriceRangeMin;
    private String mOriginalPriceRangeText;
    private String mPriceCurrency;
    private String mPriceQualifier;

    public BigDecimal a()
    {
        if (mOriginalPriceRangeMin != null)
        {
            return new BigDecimal(mOriginalPriceRangeMin);
        } else
        {
            return null;
        }
    }

    public BigDecimal b()
    {
        if (mOriginalPriceRangeMax != null)
        {
            return new BigDecimal(mOriginalPriceRangeMax);
        } else
        {
            return null;
        }
    }

    public String c()
    {
        return mOriginalPriceRangeText;
    }

    public BigDecimal d()
    {
        if (mCurrentPriceRangeMin != null)
        {
            return new BigDecimal(mCurrentPriceRangeMin);
        } else
        {
            return null;
        }
    }

    public BigDecimal e()
    {
        if (mCurrentPriceRangeMax != null)
        {
            return new BigDecimal(mCurrentPriceRangeMax);
        } else
        {
            return null;
        }
    }

    public String f()
    {
        return mCurrentPriceRangeText;
    }

    public Currency g()
    {
        if (mPriceCurrency != null)
        {
            return Currency.getInstance(mPriceCurrency);
        } else
        {
            return c.USD;
        }
    }

    public String h()
    {
        return mPriceQualifier;
    }
}
