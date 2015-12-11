// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.util.Calendar;
import java.util.TimeZone;

public class Date
{

    private static final String MONTH_STRING[] = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", 
        "Nov", "Dec"
    };
    private static final String WEEK_STRING[] = {
        "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
    };
    private Calendar cal;

    public Date(Calendar calendar)
    {
        cal = calendar;
    }

    public static final Date getInstance()
    {
        return new Date(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
    }

    public static final Date getLocalInstance()
    {
        return new Date(Calendar.getInstance());
    }

    public static final String toDateString(int i)
    {
        if (i < 10)
        {
            return (new StringBuilder("0")).append(Integer.toString(i)).toString();
        } else
        {
            return Integer.toString(i);
        }
    }

    public static final String toMonthString(int i)
    {
        i += 0;
        if (i >= 0 && i < 12)
        {
            return MONTH_STRING[i];
        } else
        {
            return "";
        }
    }

    public static final String toTimeString(int i)
    {
        String s = "";
        if (i < 10)
        {
            s = (new StringBuilder(String.valueOf(""))).append("0").toString();
        }
        return (new StringBuilder(String.valueOf(s))).append(Integer.toString(i)).toString();
    }

    public static final String toWeekString(int i)
    {
        i--;
        if (i >= 0 && i < 7)
        {
            return WEEK_STRING[i];
        } else
        {
            return "";
        }
    }

    public Calendar getCalendar()
    {
        return cal;
    }

    public String getDateString()
    {
        Calendar calendar = getCalendar();
        return (new StringBuilder(String.valueOf(toWeekString(calendar.get(7))))).append(", ").append(toTimeString(calendar.get(5))).append(" ").append(toMonthString(calendar.get(2))).append(" ").append(Integer.toString(calendar.get(1))).append(" ").append(toTimeString(calendar.get(11))).append(":").append(toTimeString(calendar.get(12))).append(":").append(toTimeString(calendar.get(13))).append(" GMT").toString();
    }

    public int getHour()
    {
        return getCalendar().get(11);
    }

    public int getMinute()
    {
        return getCalendar().get(12);
    }

    public int getSecond()
    {
        return getCalendar().get(13);
    }

    public String getTimeString()
    {
        Calendar calendar = getCalendar();
        StringBuilder stringbuilder = new StringBuilder(String.valueOf(toDateString(calendar.get(11))));
        String s;
        if (calendar.get(13) % 2 == 0)
        {
            s = ":";
        } else
        {
            s = " ";
        }
        return stringbuilder.append(s).append(toDateString(calendar.get(12))).toString();
    }

}
