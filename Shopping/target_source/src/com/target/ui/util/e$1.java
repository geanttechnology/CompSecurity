// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.util:
//            e

static class ror
{

    static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
    static final int $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[];

    static 
    {
        $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason = new int[com.target.mothership.model.cart.interfaces.a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_GIFT_CARD_DETAILS_INVALID.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$target$mothership$model$cart$interfaces$error$ApplyGiftCardFailure$ApplyGiftCardFailureReason[com.target.mothership.model.cart.interfaces.a.ERR_GIFT_CARD_ALREADY_USED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        $SwitchMap$com$target$mothership$common$tender$CardType = new int[a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.AMEX.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.VISA.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_DEBIT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_MASTERCARD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_RED_CARD.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_CARD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_VISA.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_BUSINESS.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.DISCOVER.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.MASTER_CARD.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_GIFT_CARD.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.PAYPAL.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
