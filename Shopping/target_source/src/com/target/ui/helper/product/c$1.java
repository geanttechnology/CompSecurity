// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.target.mothership.common.product.i;

// Referenced classes of package com.target.ui.helper.product:
//            c, b

static class uct.i
{

    static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];
    static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

    static 
    {
        $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.PICK_UP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UNKNOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.LimitedStock.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.UnAvailable.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.CurrentlyNotOnSale.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotAvailable.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
