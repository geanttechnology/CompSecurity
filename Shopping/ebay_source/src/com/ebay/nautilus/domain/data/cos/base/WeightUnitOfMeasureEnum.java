// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class WeightUnitOfMeasureEnum extends Enum
{

    private static final WeightUnitOfMeasureEnum $VALUES[];
    public static final WeightUnitOfMeasureEnum KILOGRAM;
    public static final WeightUnitOfMeasureEnum POUND;
    public static final WeightUnitOfMeasureEnum UNKNOWN;

    private WeightUnitOfMeasureEnum(String s, int i)
    {
        super(s, i);
    }

    public static WeightUnitOfMeasureEnum valueOf(String s)
    {
        return (WeightUnitOfMeasureEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/WeightUnitOfMeasureEnum, s);
    }

    public static WeightUnitOfMeasureEnum[] values()
    {
        return (WeightUnitOfMeasureEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new WeightUnitOfMeasureEnum("UNKNOWN", 0);
        POUND = new WeightUnitOfMeasureEnum("POUND", 1);
        KILOGRAM = new WeightUnitOfMeasureEnum("KILOGRAM", 2);
        $VALUES = (new WeightUnitOfMeasureEnum[] {
            UNKNOWN, POUND, KILOGRAM
        });
    }
}
