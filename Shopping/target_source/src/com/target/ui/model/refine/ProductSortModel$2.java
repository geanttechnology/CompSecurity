// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import com.target.mothership.common.product.p;

// Referenced classes of package com.target.ui.model.refine:
//            ProductSortModel

static class 
{

    static final int $SwitchMap$com$target$mothership$common$product$ProductSortType[];

    static 
    {
        $SwitchMap$com$target$mothership$common$product$ProductSortType = new int[p.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.RELEVANCE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.BEST_SELLING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.NEWEST.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.PRICE_HIGH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.PRICE_LOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductSortType[p.RATING_HIGH.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
