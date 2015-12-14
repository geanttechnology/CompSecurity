// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils
{

    private static final long MILLIS_IN_A_DAY;

    public static long applyCurrentTimeZone(long l)
    {
        return (long)TimeZone.getDefault().getOffset(l) + l;
    }

    public static String getDateFormat(long l)
    {
        Date date = new Date(l - (long)TimeZone.getDefault().getOffset(l));
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat.format(date);
    }

    public static String getDateFormatWithoutTimeZone(long l)
    {
        Date date = new Date(l - (long)TimeZone.getDefault().getOffset(l));
        return (new SimpleDateFormat("yyyy:MM:dd HH:mm:ss")).format(date);
    }

    public static boolean isAtStartOfDay(long l)
    {
        return l % MILLIS_IN_A_DAY == 0L;
    }

    public static boolean isSameDay(long l, long l1)
    {
        Object obj = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(((TimeZone) (obj)));
        obj = Calendar.getInstance(((TimeZone) (obj)));
        calendar.setTimeInMillis(l);
        ((Calendar) (obj)).setTimeInMillis(l1);
        return calendar.get(1) == ((Calendar) (obj)).get(1) && calendar.get(2) == ((Calendar) (obj)).get(2) && calendar.get(5) == ((Calendar) (obj)).get(5);
    }

    static 
    {
        MILLIS_IN_A_DAY = TimeUnit.DAYS.toMillis(1L);
    }
}
