// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelDetails

public static final class  extends Enum
{

    private static final NO_SIGNATURE_REQUIRED $VALUES[];
    public static final NO_SIGNATURE_REQUIRED ADULT;
    public static final NO_SIGNATURE_REQUIRED DIRECT;
    public static final NO_SIGNATURE_REQUIRED INDIRECT;
    public static final NO_SIGNATURE_REQUIRED NO_SIGNATURE_REQUIRED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelDetails$SigConValue, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DIRECT = new <init>("DIRECT", 0);
        ADULT = new <init>("ADULT", 1);
        INDIRECT = new <init>("INDIRECT", 2);
        NO_SIGNATURE_REQUIRED = new <init>("NO_SIGNATURE_REQUIRED", 3);
        $VALUES = (new .VALUES[] {
            DIRECT, ADULT, INDIRECT, NO_SIGNATURE_REQUIRED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
