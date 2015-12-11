// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.mothership.common.product.i;
import com.target.ui.helper.product.b;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductShipItDialogFragment

static class I
{

    static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];
    static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

    static 
    {
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
        $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.EXPRESS_CHECKOUT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SHIP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SMS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.EMAIL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.MAIL.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
