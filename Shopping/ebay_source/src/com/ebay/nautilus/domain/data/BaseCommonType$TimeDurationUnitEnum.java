// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class  extends Enum
{

    private static final MILLISECOND $VALUES[];
    public static final MILLISECOND BUSINESS_DAY;
    public static final MILLISECOND CALENDAR_DAY;
    public static final MILLISECOND HOUR;
    public static final MILLISECOND MILLISECOND;
    public static final MILLISECOND MINUTE;
    public static final MILLISECOND MONTH;
    public static final MILLISECOND SECOND;
    public static final MILLISECOND YEAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/BaseCommonType$TimeDurationUnitEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        YEAR = new <init>("YEAR", 0);
        MONTH = new <init>("MONTH", 1);
        CALENDAR_DAY = new <init>("CALENDAR_DAY", 2);
        BUSINESS_DAY = new <init>("BUSINESS_DAY", 3);
        HOUR = new <init>("HOUR", 4);
        MINUTE = new <init>("MINUTE", 5);
        SECOND = new <init>("SECOND", 6);
        MILLISECOND = new <init>("MILLISECOND", 7);
        $VALUES = (new .VALUES[] {
            YEAR, MONTH, CALENDAR_DAY, BUSINESS_DAY, HOUR, MINUTE, SECOND, MILLISECOND
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
