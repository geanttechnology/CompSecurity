// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;


// Referenced classes of package com.braintreepayments.api.models:
//            PaymentMethodOptions

public class CoinbasePaymentMethodOptions extends PaymentMethodOptions
{

    private boolean mStoreInVault;

    public CoinbasePaymentMethodOptions()
    {
    }

    public void setStoreInVault(boolean flag)
    {
        mStoreInVault = flag;
    }
}
