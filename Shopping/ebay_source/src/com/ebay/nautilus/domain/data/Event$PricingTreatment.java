// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            Event

public static final class  extends Enum
{

    private static final MAP $VALUES[];
    public static final MAP MAP;
    public static final MAP None;
    public static final MAP STP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/Event$PricingTreatment, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        STP = new <init>("STP", 1);
        MAP = new <init>("MAP", 2);
        $VALUES = (new .VALUES[] {
            None, STP, MAP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
