// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.c;

import com.target.mothership.common.product.f;
import com.target.mothership.common.product.n;

// Referenced classes of package com.target.ui.i.c:
//            c

static class rror
{

    static final int $SwitchMap$com$target$mothership$common$product$EyebrowType[];
    static final int $SwitchMap$com$target$mothership$common$product$PriceType[];
    static final int $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[];

    static 
    {
        $SwitchMap$com$target$mothership$common$product$EyebrowType = new int[f.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$EyebrowType[f.TEMPORARY_PRICE_CUT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$EyebrowType[f.PRICE_CUT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$EyebrowType[f.SALE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$EyebrowType[f.CLEARANCE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength = new int[values().length];
        try
        {
            $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[SHORT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$ui$rules$product$ProductPriceRules$PriceDisplayLength[REGULAR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$target$mothership$common$product$PriceType = new int[n.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$PriceType[n.SINGLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$PriceType[n.RANGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$PriceType[n.UNKNOWN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
