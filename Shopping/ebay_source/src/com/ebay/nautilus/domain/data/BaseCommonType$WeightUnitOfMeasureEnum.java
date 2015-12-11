// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class  extends Enum
{

    private static final KILOGRAM $VALUES[];
    public static final KILOGRAM KILOGRAM;
    public static final KILOGRAM POUND;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$WeightUnitOfMeasureEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        POUND = new <init>("POUND", 0);
        KILOGRAM = new <init>("KILOGRAM", 1);
        $VALUES = (new .VALUES[] {
            POUND, KILOGRAM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
