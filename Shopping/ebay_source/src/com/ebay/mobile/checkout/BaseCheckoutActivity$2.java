// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity

static class eration
{

    static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];
    static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[com.ebay.nautilus.domain.data.ype().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.ype.()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror35) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.R.()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.NEXPRESS.()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.ARD.()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[eration.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.CREATE_CHECKOUT_SESSION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.CREATE_CART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.APPLY_INCENTIVES.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.REDEEM_INCENTIVE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.INIT_PAYMENT_FOR_PREPARE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.REQUEST_TOKEN_FOR_SERVICE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.INIT_PAYMENT_FOR_REFRESH.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.PAYPAL_CHECKOUT_FOR_REFRESH.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_SHIPPING_METHOD.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_ITEM_QUANTITY.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_SELLER_NOTE.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_PICKUP_METHOD.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_DELIVERY_RESERVATION.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.REMOVE_DONATION.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.ADD_DONATION.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.SET_PAYMENT_INSTRUMENT.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.ADD_CREDIT_CARD.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.ADD_DIRECT_DEBIT.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_CREDIT_CARD.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.UPDATE_DIRECT_DEBIT.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_FUNDING_INSTRUMENT.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.PAYPAL_CHECKOUT.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.SET_SHIPPING_ADDRESS.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.INIT_PAYMENT_RESULT.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.BUY.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.REFRESH_CART.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_CART.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_USER_INCENTIVES_VOUCHERS.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_USER_INCENTIVES_COUPONS.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_INCENTIVES_COUPONS.ordinal()] = 31;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[eration.GET_INCENTIVES_REWARDS.ordinal()] = 32;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
