// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class  extends Enum
{

    private static final METER $VALUES[];
    public static final METER CENTIMETER;
    public static final METER FEET;
    public static final METER INCH;
    public static final METER METER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$DimensionUnitOfMeasureEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INCH = new <init>("INCH", 0);
        FEET = new <init>("FEET", 1);
        CENTIMETER = new <init>("CENTIMETER", 2);
        METER = new <init>("METER", 3);
        $VALUES = (new .VALUES[] {
            INCH, FEET, CENTIMETER, METER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
