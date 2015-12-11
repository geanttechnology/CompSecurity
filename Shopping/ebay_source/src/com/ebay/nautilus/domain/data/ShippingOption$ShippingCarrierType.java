// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingOption

public static final class  extends Enum
{

    private static final INVALID $VALUES[];
    public static final INVALID FEDEX;
    public static final INVALID INVALID;
    public static final INVALID USPS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShippingOption$ShippingCarrierType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        USPS = new <init>("USPS", 0);
        FEDEX = new <init>("FEDEX", 1);
        INVALID = new <init>("INVALID", 2);
        $VALUES = (new .VALUES[] {
            USPS, FEDEX, INVALID
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
