// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.fragment.checkout:
//            SecurityCodeDialogFragment

static class 
{

    static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
    static final int $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[];

    static 
    {
        $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType = new int[values().length];
        try
        {
            $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[TargetDebitCardPin.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[Cvv.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SwitchMap$com$target$mothership$common$tender$CardType = new int[a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_DEBIT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
