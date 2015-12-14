// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ISO8601
{
    private static class ThreadLocalSimpleDateFormat extends ThreadLocal
    {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected SimpleDateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpledateformat;
        }

        private ThreadLocalSimpleDateFormat()
        {
        }

    }


    private static final ThreadLocal UTC_DATE_FORMAT = new ThreadLocalSimpleDateFormat();

    public static Date getDateFromString(String s)
        throws ParseException
    {
        return ((SimpleDateFormat)UTC_DATE_FORMAT.get()).parse(s.replace("Z", "+0000"));
    }

    public static String getUTCString(Date date)
    {
        return ((SimpleDateFormat)UTC_DATE_FORMAT.get()).format(date).replace("+0000", "Z");
    }

    public static long getUnixTimestampFromString(String s)
        throws ParseException
    {
        return ((SimpleDateFormat)UTC_DATE_FORMAT.get()).parse(s.replace("Z", "+0000")).getTime();
    }

}
