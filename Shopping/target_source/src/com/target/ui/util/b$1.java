// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;


// Referenced classes of package com.target.ui.util:
//            b

static class ror
{

    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[];
    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[];
    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason[];

    static 
    {
        $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason = new int[com.target.mothership.model.guest.interfaces.a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason[com.target.mothership.model.guest.interfaces.a.ERR_CARD_INFORMATION_INVALID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason = new int[com.target.mothership.model.guest.interfaces.a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[com.target.mothership.model.guest.interfaces.a.ERR_INVALID_ADDRESS_TYPE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[com.target.mothership.model.guest.interfaces.a.UNKNOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason = new int[com.target.mothership.model.guest.interfaces.a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[com.target.mothership.model.guest.interfaces.a.ERR_GIFT_CARD_ACCESS_NUMBER_INVALID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[com.target.mothership.model.guest.interfaces.a.ERR_GIFT_CARD_ALREADY_ADDED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
