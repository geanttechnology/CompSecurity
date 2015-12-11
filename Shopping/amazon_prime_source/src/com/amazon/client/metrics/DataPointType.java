// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


public final class DataPointType extends Enum
{

    private static final DataPointType $VALUES[];
    public static final DataPointType CK;
    public static final DataPointType CT;
    public static final DataPointType DV;
    public static final DataPointType TI;

    private DataPointType(String s, int i)
    {
        super(s, i);
    }

    public static DataPointType fromInt(int i)
    {
        if (i < 0 || i > values().length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid datapoint ").append(i).toString());
        } else
        {
            return values()[i];
        }
    }

    public static DataPointType getCounterType()
    {
        return CT;
    }

    public static DataPointType getDiscreteValueType()
    {
        return DV;
    }

    public static DataPointType getTimerType()
    {
        return TI;
    }

    public static DataPointType valueOf(String s)
    {
        return (DataPointType)Enum.valueOf(com/amazon/client/metrics/DataPointType, s);
    }

    public static DataPointType[] values()
    {
        return (DataPointType[])$VALUES.clone();
    }

    static 
    {
        CT = new DataPointType("CT", 0);
        TI = new DataPointType("TI", 1);
        DV = new DataPointType("DV", 2);
        CK = new DataPointType("CK", 3);
        $VALUES = (new DataPointType[] {
            CT, TI, DV, CK
        });
    }
}
