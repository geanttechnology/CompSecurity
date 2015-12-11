// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import com.target.ui.helper.product.b;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductDetailsPageFragment

static class 
{

    static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];

    static 
    {
        $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SMS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.EMAIL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.MAIL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SHIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.PICK_UP.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
