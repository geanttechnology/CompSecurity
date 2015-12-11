// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil
{

    private static final int DAYS_IN_WEEK = 7;
    private static final int HOURS_IN_DAY = 24;
    private static final int MINUTES_IN_HOUR = 60;
    public static final int MS_IN_SECOND = 1000;
    private static final int SECONDS_IN_DAY = 0x15180;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_WEEK = 0x93a80;

    private TimeUtil()
    {
    }

    private void checkOrder(Date date, Date date1)
    {
        if (date.after(date1))
        {
            throw new InvalidParameterException("Old date should be before recent date.");
        } else
        {
            return;
        }
    }

    public Date createDateFromTimeAndDate(long l, int i, int j, int k)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        calendar.set(i, j, k);
        return calendar.getTime();
    }

    public int diffDays(Date date, Date date1)
    {
        checkOrder(date, date1);
        return (int)((date1.getTime() - date.getTime()) / 0x5265c00L);
    }

    public int diffHours(Date date, Date date1)
    {
        checkOrder(date, date1);
        return diffHoursTotal(date, date1) % 24;
    }

    public int diffHoursTotal(Date date, Date date1)
    {
        checkOrder(date, date1);
        return (int)((date1.getTime() - date.getTime()) / 0x36ee80L);
    }

    public int diffMinutes(Date date, Date date1)
    {
        checkOrder(date, date1);
        return (int)(((date1.getTime() - date.getTime()) / 60000L) % 60L);
    }

    public int diffMonths(Date date, Date date1)
    {
        checkOrder(date, date1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = Calendar.getInstance();
        date.setTime(date1);
        int i = date.get(1);
        int j = calendar.get(1);
        j = (date.get(2) - calendar.get(2)) + (i - j) * 12;
        i = j;
        if (calendar.get(5) >= date.get(5))
        {
            i = j;
            if (j != 0)
            {
                i = j - 1;
            }
        }
        return i;
    }

    public int diffSeconds(Date date, Date date1)
    {
        checkOrder(date, date1);
        return (int)(((date1.getTime() - date.getTime()) / 1000L) % 60L);
    }

    public int diffWeeks(Date date, Date date1)
    {
        checkOrder(date, date1);
        return (int)((date1.getTime() - date.getTime()) / 0x240c8400L);
    }

    public int diffYears(Date date, Date date1)
    {
        checkOrder(date, date1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = Calendar.getInstance();
        date.setTime(date1);
        int i = 0;
        int j;
        do
        {
            calendar.add(1, 1);
            j = i + 1;
            i = j;
        } while (calendar.before(date));
        return j - 1;
    }
}
