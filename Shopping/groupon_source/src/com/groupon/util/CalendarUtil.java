// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalendarUtil
{

    public CalendarUtil()
    {
    }

    public static Date getDateWithoutHour(Calendar calendar)
    {
        if (calendar == null)
        {
            return null;
        } else
        {
            calendar.set(10, 0);
            calendar.set(9, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTime();
        }
    }

    public static Date getDateWithoutHour(Date date)
    {
        if (date == null)
        {
            return null;
        } else
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return getDateWithoutHour(calendar);
        }
    }

    public static int nightsBetweenDates(Date date, Date date1)
    {
        if (date != null && date1 != null)
        {
            long l = date1.getTime();
            long l1 = date.getTime();
            if (l > l1)
            {
                return (int)TimeUnit.MILLISECONDS.toDays(Math.abs(l - l1));
            }
        }
        return 0;
    }

    public static void setCalendarHourToZero(Calendar calendar)
    {
        if (calendar == null)
        {
            return;
        } else
        {
            calendar.set(10, 0);
            calendar.set(9, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return;
        }
    }
}
