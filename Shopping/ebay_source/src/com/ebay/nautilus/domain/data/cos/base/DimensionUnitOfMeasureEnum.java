// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class DimensionUnitOfMeasureEnum extends Enum
{

    private static final DimensionUnitOfMeasureEnum $VALUES[];
    public static final DimensionUnitOfMeasureEnum CENTIMETER;
    public static final DimensionUnitOfMeasureEnum FEET;
    public static final DimensionUnitOfMeasureEnum INCH;
    public static final DimensionUnitOfMeasureEnum METER;
    public static final DimensionUnitOfMeasureEnum UNKNOWN;

    private DimensionUnitOfMeasureEnum(String s, int i)
    {
        super(s, i);
    }

    public static DimensionUnitOfMeasureEnum valueOf(String s)
    {
        return (DimensionUnitOfMeasureEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/DimensionUnitOfMeasureEnum, s);
    }

    public static DimensionUnitOfMeasureEnum[] values()
    {
        return (DimensionUnitOfMeasureEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new DimensionUnitOfMeasureEnum("UNKNOWN", 0);
        INCH = new DimensionUnitOfMeasureEnum("INCH", 1);
        FEET = new DimensionUnitOfMeasureEnum("FEET", 2);
        CENTIMETER = new DimensionUnitOfMeasureEnum("CENTIMETER", 3);
        METER = new DimensionUnitOfMeasureEnum("METER", 4);
        $VALUES = (new DimensionUnitOfMeasureEnum[] {
            UNKNOWN, INCH, FEET, CENTIMETER, METER
        });
    }
}
