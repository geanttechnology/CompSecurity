// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            HumanReadableTimerFormat, HumanReadableTimerFormatExtension

public class Dates
{

    public static final long MILLIS_PER_DAY = 0x5265c00L;

    public Dates()
    {
    }

    public static String getTimeStampString(Context context, long l)
    {
        return ((HumanReadableTimerFormat)RoboGuice.getInjector(context).getInstance(com/groupon/util/HumanReadableTimerFormat)).getReadableTimer(new Date(l));
    }

    public static String getTimeStampStringExtended(Context context, long l)
    {
        return ((HumanReadableTimerFormatExtension)RoboGuice.getInjector(context).getInstance(com/groupon/util/HumanReadableTimerFormatExtension)).getReadableTimer(new Date(l));
    }

    public static boolean isDateAfterLimit(Date date, int i)
    {
        return date == null || date.getTime() / 0x5265c00L > System.currentTimeMillis() / 0x5265c00L + (long)i;
    }

    public static boolean isOlderThanADay(long l)
    {
        return System.currentTimeMillis() - l > 0x5265c00L;
    }

    public static boolean isSameDay(Date date, Date date1)
    {
        boolean flag = true;
        if (date == null || date1 == null)
        {
            flag = false;
        } else
        {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar.setTime(date);
            calendar1.setTime(date1);
            if (calendar.get(1) != calendar1.get(1) || calendar.get(6) != calendar1.get(6))
            {
                return false;
            }
        }
        return flag;
    }

    public static boolean isTimeInPast(Date date, Date date1)
    {
        return date != null && (new Date()).after(date) || date1 != null && (new Date()).after(date1);
    }

    public static boolean isToday(long l)
    {
        if (l > 0L)
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            GregorianCalendar gregoriancalendar1 = new GregorianCalendar();
            gregoriancalendar1.setTimeInMillis(l);
            if (gregoriancalendar.get(5) == gregoriancalendar1.get(5))
            {
                return true;
            }
        }
        return false;
    }

    public static Calendar midnightThisMorning()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(11, 0);
        gregoriancalendar.set(12, 0);
        gregoriancalendar.set(13, 0);
        return gregoriancalendar;
    }

    public static Calendar midnightTonight()
    {
        Calendar calendar = midnightThisMorning();
        calendar.add(5, 1);
        return calendar;
    }
}
