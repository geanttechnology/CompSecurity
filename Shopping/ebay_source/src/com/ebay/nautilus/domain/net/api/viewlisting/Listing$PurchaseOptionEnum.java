// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final ADD_TO_CART $VALUES[];
    public static final ADD_TO_CART ADD_TO_CART;
    public static final ADD_TO_CART AUCTION;
    public static final ADD_TO_CART BEST_OFFER;
    public static final ADD_TO_CART BUY_IT_NOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$PurchaseOptionEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUCTION = new <init>("AUCTION", 0);
        BUY_IT_NOW = new <init>("BUY_IT_NOW", 1);
        BEST_OFFER = new <init>("BEST_OFFER", 2);
        ADD_TO_CART = new <init>("ADD_TO_CART", 3);
        $VALUES = (new .VALUES[] {
            AUCTION, BUY_IT_NOW, BEST_OFFER, ADD_TO_CART
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
