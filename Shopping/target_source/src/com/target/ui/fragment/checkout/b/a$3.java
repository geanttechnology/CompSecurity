// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.b;

import com.target.ui.fragment.checkout.d.c;

// Referenced classes of package com.target.ui.fragment.checkout.b:
//            a

static class faces.a.h.a
{

    static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[];
    static final int $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[];

    static 
    {
        $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason = new int[com.target.mothership.model.cart.interfaces.a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_TOKEN_EXPIRED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_ACCOUNT_IN_USE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_REAUTH_REQUIRED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_TC_PIN_REQUIRED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_DECLINE_TC_PIN_INVALID.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_CVV_REQUIRED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_DECLINE_CVV_INVALID.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_DECLINE_MAX_RETRIES.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_INVALID_PAYMENT.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_DECLINE_TARGET_DEBIT_CARD.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_VALIDATE_PAYMENT_INSTRUCTION.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_NO_ADDRESS.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_TOO_MANY_REQUESTS.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_CART_EMPTY.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$CheckoutFailure$CheckoutFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_CART_UNKNOWN.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType = new int[c.values().length];
        try
        {
            $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[c.GIFT_CARD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[c.PROMO_CODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$fragment$checkout$view$CheckoutProgressType[c.DEFAULT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
