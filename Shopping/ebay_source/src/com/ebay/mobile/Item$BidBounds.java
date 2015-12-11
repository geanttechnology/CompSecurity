// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import com.ebay.nautilus.domain.data.CurrencyAmount;

// Referenced classes of package com.ebay.mobile:
//            Item

public static class allowLowerBound
{

    public boolean allowLowerBound;
    public CurrencyAmount lowerBound;

    public urrencyAmount()
    {
        this(new CurrencyAmount(0.0D, "USD"), true);
    }

    public urrencyAmount(CurrencyAmount currencyamount, boolean flag)
    {
        lowerBound = currencyamount;
        allowLowerBound = flag;
    }
}
