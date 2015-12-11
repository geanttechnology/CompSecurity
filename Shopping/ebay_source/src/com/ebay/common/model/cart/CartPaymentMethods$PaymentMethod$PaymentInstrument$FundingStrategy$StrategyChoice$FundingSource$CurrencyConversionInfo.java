// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.ebay.common.model.cart:
//            CartPaymentMethods

public static class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public CurrencyAmount basis;
    public Date conversionDate;
    public CurrencyAmount converted;
    private String exchangeRateProvider;

    public ()
    {
    }
}
