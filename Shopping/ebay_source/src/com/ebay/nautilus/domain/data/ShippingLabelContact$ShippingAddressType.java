// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelContact

public static final class  extends Enum
{

    private static final SHIP_FROM $VALUES[];
    public static final SHIP_FROM SHIP_FROM;
    public static final SHIP_FROM SHIP_TO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelContact$ShippingAddressType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHIP_TO = new <init>("SHIP_TO", 0);
        SHIP_FROM = new <init>("SHIP_FROM", 1);
        $VALUES = (new .VALUES[] {
            SHIP_TO, SHIP_FROM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
