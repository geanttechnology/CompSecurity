// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b.a;

import java.math.BigDecimal;

public class p
{

    private String mAmountSaved;
    private String mCurrentPrice;
    private String mCurrentPriceText;
    private String mOriginalPrice;
    private String mOriginalPriceText;
    private int mPercentageSaved;
    private String mPriceCurrency;
    private String mPriceQualifier;

    public BigDecimal a()
    {
        if (mOriginalPrice != null)
        {
            return new BigDecimal(mOriginalPrice);
        } else
        {
            return null;
        }
    }

    public String b()
    {
        return mOriginalPriceText;
    }

    public BigDecimal c()
    {
        if (mCurrentPrice != null)
        {
            return new BigDecimal(mCurrentPrice);
        } else
        {
            return null;
        }
    }

    public String d()
    {
        return mCurrentPriceText;
    }

    public BigDecimal e()
    {
        if (mAmountSaved != null)
        {
            return new BigDecimal(mAmountSaved);
        } else
        {
            return null;
        }
    }

    public int f()
    {
        return mPercentageSaved;
    }

    public String g()
    {
        return mPriceQualifier;
    }
}
