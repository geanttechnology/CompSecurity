// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.deals;


// Referenced classes of package com.ebay.nautilus.domain.data.experience.deals:
//            DealsListingSummary

public static final class  extends Enum
{

    private static final FREE_SHIPPING $VALUES[];
    public static final FREE_SHIPPING EBAY_NOW;
    public static final FREE_SHIPPING FREE_SHIPPING;
    public static final FREE_SHIPPING PICKUP_IN_STORE;
    public static final FREE_SHIPPING UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/experience/deals/DealsListingSummary$DeliveryOption, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        PICKUP_IN_STORE = new <init>("PICKUP_IN_STORE", 1);
        EBAY_NOW = new <init>("EBAY_NOW", 2);
        FREE_SHIPPING = new <init>("FREE_SHIPPING", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, PICKUP_IN_STORE, EBAY_NOW, FREE_SHIPPING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
