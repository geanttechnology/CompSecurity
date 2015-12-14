// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil
{

    private static final DateFormat ISO_DATE_FORMATTER_UTC;

    public static DateFormat createLocaleIndependentDateFormatter(String s)
    {
        return new SimpleDateFormat(s, Locale.US);
    }

    private static DateFormat getDateFormat()
    {
        com/amazon/insights/core/util/DateUtil;
        JVM INSTR monitorenter ;
        DateFormat dateformat = ISO_DATE_FORMATTER_UTC;
        com/amazon/insights/core/util/DateUtil;
        JVM INSTR monitorexit ;
        return dateformat;
        Exception exception;
        exception;
        throw exception;
    }

    public static String isoDateFromMillis(long l)
    {
        com/amazon/insights/core/util/DateUtil;
        JVM INSTR monitorenter ;
        String s = getDateFormat().format(new Date(l));
        com/amazon/insights/core/util/DateUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        ISO_DATE_FORMATTER_UTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        ISO_DATE_FORMATTER_UTC.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
