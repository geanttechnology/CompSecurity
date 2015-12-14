// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTimeUtils
{

    static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
    static final TimeZone LOCAL_TIME_ZONE = TimeZone.getDefault();
    private static final String LOG_TAG = "DateTimeUtils";
    public static final long ONE_DAY = 0x5265c00L;
    public static final long ONE_HOUR = 0x36ee80L;
    public static final long ONE_MINUTE = 60000L;
    public static final long ONE_SECOND = 1000L;
    public static final long ONE_WEEK = 0x240c8400L;
    static final SimpleDateFormat S_SQLDATE_FORMAT;

    private DateTimeUtils()
    {
    }

    public static Date fromSqlDateTime(String s, boolean flag)
        throws ParseException
    {
        if (flag)
        {
            S_SQLDATE_FORMAT.setTimeZone(LOCAL_TIME_ZONE);
        } else
        {
            S_SQLDATE_FORMAT.setTimeZone(GMT_TIME_ZONE);
        }
        return S_SQLDATE_FORMAT.parse(s);
    }

    public static long tick()
    {
        return System.nanoTime();
    }

    public static long tick(long l, String s)
    {
        long l1 = System.nanoTime();
        Log.d("DateTimeUtils", (new StringBuilder()).append(s).append(", time: ").append((double)(l1 - l) / 1000000D).toString());
        return l1;
    }

    public static String toSqlDateTime(long l)
    {
        return toSqlDateTime(new Date(l));
    }

    public static String toSqlDateTime(Date date)
    {
        S_SQLDATE_FORMAT.setTimeZone(GMT_TIME_ZONE);
        return S_SQLDATE_FORMAT.format(date);
    }

    static 
    {
        S_SQLDATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        S_SQLDATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
}
