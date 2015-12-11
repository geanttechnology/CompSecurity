// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import com.target.mothership.common.tender.a;
import com.target.mothership.common.tender.b;

// Referenced classes of package com.target.ui.util.validation:
//            d

static class r.a
{

    static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
    static final int $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[];

    static 
    {
        $SwitchMap$com$target$mothership$common$tender$ExpiryMonth = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.January.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.February.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.March.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.April.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.May.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.June.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.July.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.August.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.September.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.October.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.November.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.December.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        $SwitchMap$com$target$mothership$common$tender$CardType = new int[a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_DEBIT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.AMEX.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.DISCOVER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.MASTER_CARD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_VISA.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_MASTERCARD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.VISA.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_CARD.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_BUSINESS.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
