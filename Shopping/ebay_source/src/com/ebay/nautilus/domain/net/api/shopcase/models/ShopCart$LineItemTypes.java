// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class  extends Enum
{

    private static final TRANSACTION_ITEM $VALUES[];
    public static final TRANSACTION_ITEM BUYABLE_LISTING_ITEM;
    public static final TRANSACTION_ITEM SELLER_CREATED_ORDER;
    public static final TRANSACTION_ITEM TRANSACTION_ITEM;
    public static final TRANSACTION_ITEM UNKNOWN_LINE_ITEM_TYPE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$LineItemTypes, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN_LINE_ITEM_TYPE = new <init>("UNKNOWN_LINE_ITEM_TYPE", 0);
        BUYABLE_LISTING_ITEM = new <init>("BUYABLE_LISTING_ITEM", 1);
        SELLER_CREATED_ORDER = new <init>("SELLER_CREATED_ORDER", 2);
        TRANSACTION_ITEM = new <init>("TRANSACTION_ITEM", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN_LINE_ITEM_TYPE, BUYABLE_LISTING_ITEM, SELLER_CREATED_ORDER, TRANSACTION_ITEM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
