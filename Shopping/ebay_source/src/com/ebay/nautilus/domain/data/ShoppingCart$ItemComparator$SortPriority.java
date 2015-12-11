// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

private static final class  extends Enum
{

    private static final BUYER_CREATED $VALUES[];
    public static final BUYER_CREATED BUYER_CREATED;
    public static final BUYER_CREATED LOWEST;
    public static final BUYER_CREATED SELLER_CREATED;
    public static final BUYER_CREATED UN_BUYABLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$ItemComparator$SortPriority, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOWEST = new <init>("LOWEST", 0);
        UN_BUYABLE = new <init>("UN_BUYABLE", 1);
        SELLER_CREATED = new <init>("SELLER_CREATED", 2);
        BUYER_CREATED = new <init>("BUYER_CREATED", 3);
        $VALUES = (new .VALUES[] {
            LOWEST, UN_BUYABLE, SELLER_CREATED, BUYER_CREATED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
