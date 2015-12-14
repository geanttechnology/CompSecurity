// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;


// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayAlarmManager

public static final class  extends Enum
{

    private static final PREFETCH_ALARM $VALUES[];
    public static final PREFETCH_ALARM NOTIFICATION_ALARM;
    public static final PREFETCH_ALARM PREFETCH_ALARM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/thisday/ThisDayAlarmManager$AlarmType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOTIFICATION_ALARM = new <init>("NOTIFICATION_ALARM", 0);
        PREFETCH_ALARM = new <init>("PREFETCH_ALARM", 1);
        $VALUES = (new .VALUES[] {
            NOTIFICATION_ALARM, PREFETCH_ALARM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
