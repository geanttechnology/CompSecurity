// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;


// Referenced classes of package com.ebay.mobile.checkout.prox:
//            CreditCardActivity

static class tion
{

    static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];
    static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[com.ebay.nautilus.domain.data.s().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data..Type.al()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CANEXPRESS.al()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.VER.al()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.RCARD.al()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.Operation.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.Operation.ADD_CREDIT_CARD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.Operation.UPDATE_CREDIT_CARD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.Operation.GET_FUNDING_INSTRUMENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
