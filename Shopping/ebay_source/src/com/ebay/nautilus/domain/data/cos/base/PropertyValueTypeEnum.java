// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class PropertyValueTypeEnum extends Enum
{

    private static final PropertyValueTypeEnum $VALUES[];
    public static final PropertyValueTypeEnum AMOUNT;
    public static final PropertyValueTypeEnum BOOLEAN;
    public static final PropertyValueTypeEnum DATE_TIME;
    public static final PropertyValueTypeEnum DOUBLE;
    public static final PropertyValueTypeEnum INTEGER;
    public static final PropertyValueTypeEnum LONG;
    public static final PropertyValueTypeEnum STRING;
    public static final PropertyValueTypeEnum TEXT;
    public static final PropertyValueTypeEnum UNKNOWN;

    private PropertyValueTypeEnum(String s, int i)
    {
        super(s, i);
    }

    public static PropertyValueTypeEnum valueOf(String s)
    {
        return (PropertyValueTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/PropertyValueTypeEnum, s);
    }

    public static PropertyValueTypeEnum[] values()
    {
        return (PropertyValueTypeEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new PropertyValueTypeEnum("UNKNOWN", 0);
        STRING = new PropertyValueTypeEnum("STRING", 1);
        INTEGER = new PropertyValueTypeEnum("INTEGER", 2);
        LONG = new PropertyValueTypeEnum("LONG", 3);
        DOUBLE = new PropertyValueTypeEnum("DOUBLE", 4);
        BOOLEAN = new PropertyValueTypeEnum("BOOLEAN", 5);
        DATE_TIME = new PropertyValueTypeEnum("DATE_TIME", 6);
        TEXT = new PropertyValueTypeEnum("TEXT", 7);
        AMOUNT = new PropertyValueTypeEnum("AMOUNT", 8);
        $VALUES = (new PropertyValueTypeEnum[] {
            UNKNOWN, STRING, INTEGER, LONG, DOUBLE, BOOLEAN, DATE_TIME, TEXT, AMOUNT
        });
    }
}
