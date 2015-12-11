// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            DateUtils

public static final class  extends Enum
{

    private static final YEARS $VALUES[];
    public static final YEARS DAYS;
    public static final YEARS HOURS;
    public static final YEARS MINUTES;
    public static final YEARS MONTHS;
    public static final YEARS SECONDS;
    public static final YEARS WEEKS;
    public static final YEARS YEARS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/DateUtils$TIME_UNIT, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SECONDS = new <init>("SECONDS", 0);
        MINUTES = new <init>("MINUTES", 1);
        HOURS = new <init>("HOURS", 2);
        DAYS = new <init>("DAYS", 3);
        WEEKS = new <init>("WEEKS", 4);
        MONTHS = new <init>("MONTHS", 5);
        YEARS = new <init>("YEARS", 6);
        $VALUES = (new .VALUES[] {
            SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
