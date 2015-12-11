// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;


// Referenced classes of package com.target.ui.helper.product:
//            ProductVariationModelHelper, b

static class 
{

    static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];
    static final int $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[];

    static 
    {
        $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SMS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.EMAIL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SHIP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.MAIL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType = new int[com.target.ui.model.product.().length];
        try
        {
            $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product._DIMENSION_LIST.l()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product._DIMENSION_GRID.l()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.MENSION.l()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
