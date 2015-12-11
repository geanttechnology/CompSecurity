// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

static class skId
{

    static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[];
    static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action = new int[com.ebay.nautilus.domain.content.dm.rBase.Action.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.rBase.Action.ADD_TO_CART.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.rBase.Action.GET_CART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.rBase.Action.GET_AND_VALIDATE_CART.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId = new int[skId.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[skId.GET_ITEM_FLAGS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[skId.GET_SHIPPING_COSTS_SINGLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$TaskId[skId.GET_VIEW_LISTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
