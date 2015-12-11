// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


// Referenced classes of package com.groupon.models:
//            GetawaysCalendarData

public static final class  extends Enum
{

    private static final CONTAIN_BLACKOUT_DAYS $VALUES[];
    public static final CONTAIN_BLACKOUT_DAYS CONTAIN_BLACKOUT_DAYS;
    public static final CONTAIN_BLACKOUT_DAYS INVALID_DATE;
    public static final CONTAIN_BLACKOUT_DAYS MAXIMUM_NIGHTS;
    public static final CONTAIN_BLACKOUT_DAYS MINIMUM_NIGHTS;
    public static final CONTAIN_BLACKOUT_DAYS NO_ERROR;
    public static final CONTAIN_BLACKOUT_DAYS OUT_RANGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/models/GetawaysCalendarData$CalendarError, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_ERROR = new <init>("NO_ERROR", 0);
        OUT_RANGE = new <init>("OUT_RANGE", 1);
        INVALID_DATE = new <init>("INVALID_DATE", 2);
        MINIMUM_NIGHTS = new <init>("MINIMUM_NIGHTS", 3);
        MAXIMUM_NIGHTS = new <init>("MAXIMUM_NIGHTS", 4);
        CONTAIN_BLACKOUT_DAYS = new <init>("CONTAIN_BLACKOUT_DAYS", 5);
        $VALUES = (new .VALUES[] {
            NO_ERROR, OUT_RANGE, INVALID_DATE, MINIMUM_NIGHTS, MAXIMUM_NIGHTS, CONTAIN_BLACKOUT_DAYS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
