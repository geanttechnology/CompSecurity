// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;


// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PaymentMethodActivity

static class n
{

    static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

    static 
    {
        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.ration.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.ration.SET_PAYMENT_INSTRUMENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.ration.REFRESH_CART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
