// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


public final class TimeDurationUnitEnum extends Enum
{

    private static final TimeDurationUnitEnum $VALUES[];
    public static final TimeDurationUnitEnum BUSINESS_DAY;
    public static final TimeDurationUnitEnum CALENDAR_DAY;
    public static final TimeDurationUnitEnum DAY;
    public static final TimeDurationUnitEnum HOUR;
    public static final TimeDurationUnitEnum MILLISECOND;
    public static final TimeDurationUnitEnum MINUTE;
    public static final TimeDurationUnitEnum MONTH;
    public static final TimeDurationUnitEnum SECOND;
    public static final TimeDurationUnitEnum UNKNOWN;
    public static final TimeDurationUnitEnum YEAR;

    private TimeDurationUnitEnum(String s, int i)
    {
        super(s, i);
    }

    public static TimeDurationUnitEnum valueOf(String s)
    {
        return (TimeDurationUnitEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/base/TimeDurationUnitEnum, s);
    }

    public static TimeDurationUnitEnum[] values()
    {
        return (TimeDurationUnitEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new TimeDurationUnitEnum("UNKNOWN", 0);
        YEAR = new TimeDurationUnitEnum("YEAR", 1);
        MONTH = new TimeDurationUnitEnum("MONTH", 2);
        DAY = new TimeDurationUnitEnum("DAY", 3);
        CALENDAR_DAY = new TimeDurationUnitEnum("CALENDAR_DAY", 4);
        BUSINESS_DAY = new TimeDurationUnitEnum("BUSINESS_DAY", 5);
        HOUR = new TimeDurationUnitEnum("HOUR", 6);
        MINUTE = new TimeDurationUnitEnum("MINUTE", 7);
        SECOND = new TimeDurationUnitEnum("SECOND", 8);
        MILLISECOND = new TimeDurationUnitEnum("MILLISECOND", 9);
        $VALUES = (new TimeDurationUnitEnum[] {
            UNKNOWN, YEAR, MONTH, DAY, CALENDAR_DAY, BUSINESS_DAY, HOUR, MINUTE, SECOND, MILLISECOND
        });
    }
}
