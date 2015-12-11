// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            CreateCheckoutSessionRequest

private static final class  extends Enum
{

    private static final ITEMS $VALUES[];
    public static final ITEMS FULL_CART;
    public static final ITEMS ITEMS;
    public static final ITEMS SELLER_GROUP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/CreateCheckoutSessionRequest$CheckoutLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FULL_CART = new <init>("FULL_CART", 0);
        SELLER_GROUP = new <init>("SELLER_GROUP", 1);
        ITEMS = new <init>("ITEMS", 2);
        $VALUES = (new .VALUES[] {
            FULL_CART, SELLER_GROUP, ITEMS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
