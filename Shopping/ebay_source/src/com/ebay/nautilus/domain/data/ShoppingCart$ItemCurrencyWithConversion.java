// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart, CurrencyAmount

public static final class listedPrice
{

    public static final sitePrice ZERO = new <init>();
    public final CurrencyAmount listedPrice;
    public final CurrencyAmount sitePrice;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof listedPrice) || (((listedPrice) (obj = (listedPrice)obj)).listedPrice.isZero() || ((listedPrice) (obj)).sitePrice.isZero() || !((sitePrice) (obj)).listedPrice.equals(listedPrice) || !((listedPrice) (obj)).sitePrice.equals(sitePrice)))
            {
                return false;
            }
        }
        return true;
    }

    public boolean isZero()
    {
        return listedPrice.isZero() && sitePrice.isZero();
    }


    protected ()
    {
        this(CurrencyAmount.ZERO, CurrencyAmount.ZERO);
    }

    public <init>(CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
    {
        CurrencyAmount currencyamount2 = currencyamount;
        if (currencyamount == null)
        {
            currencyamount2 = CurrencyAmount.ZERO;
        }
        sitePrice = currencyamount2;
        currencyamount = currencyamount1;
        if (currencyamount1 == null)
        {
            currencyamount = CurrencyAmount.ZERO;
        }
        listedPrice = currencyamount;
    }
}
