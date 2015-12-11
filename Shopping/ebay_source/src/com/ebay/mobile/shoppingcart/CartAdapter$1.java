// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;


// Referenced classes of package com.ebay.mobile.shoppingcart:
//            CartAdapter

static class ewType
{

    static final int $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[];
    static final int $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status = new int[com.ebay.nautilus.domain.data.tem.Status.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.ENDING_SOON.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.SELLER_ON_VACATION.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.PAY_NOW.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.WON.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.ENDED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.UP_FOR_AUCTION.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.NOT_AVAILABLE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.LAST_ONE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.HAS_REVISIONS.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.tem.Status.UNKNOWN.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType = new int[ewType.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ewType.VIEW_TYPE_ITEM.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ewType.VIEW_TYPE_SELLER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ewType.VIEW_TYPE_PROMOTION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ewType.VIEW_TYPE_TOTALS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ewType.VIEW_TYPE_UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
