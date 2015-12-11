// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil
{

    public DateTimeUtil()
    {
    }

    public static Calendar clearTime(Calendar calendar)
    {
        calendar.set(11, 0);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar getStartOfDay()
    {
        return clearTime(Calendar.getInstance());
    }

    public static long getTimeInMsFromString(String s, String s1)
    {
        s1 = new SimpleDateFormat(s1, Locale.US);
        long l = 0L;
        int i;
        long l1;
        try
        {
            l1 = s1.parse(s).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        l = l1;
        i = TimeZone.getDefault().getOffset((new Date()).getTime());
        return l1 + (long)i;
    }

    public static String getTimeInStringFromMs(long l, String s)
    {
        return (new SimpleDateFormat(s, Locale.US)).format(new Date(l));
    }
}
