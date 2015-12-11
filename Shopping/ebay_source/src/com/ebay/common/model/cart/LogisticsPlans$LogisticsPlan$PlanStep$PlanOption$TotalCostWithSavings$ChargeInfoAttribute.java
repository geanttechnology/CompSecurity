// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static final class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public String currencyId;
    public String currencyValue;
    public String format;
    public String name;

    public CurrencyAmount getAmount()
    {
        return new CurrencyAmount(currencyValue, currencyId);
    }

    public ()
    {
    }
}
