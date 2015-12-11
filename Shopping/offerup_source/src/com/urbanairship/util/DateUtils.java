// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils
{

    private static final SimpleDateFormat ALT_ISO_DATE_FORMAT;
    private static final SimpleDateFormat ISO_DATE_FORMAT;

    private DateUtils()
    {
    }

    public static String createIso8601TimeStamp(long l)
    {
        return ISO_DATE_FORMAT.format(new Date(l));
    }

    public static long parseIso8601(String s)
    {
        if (s == null)
        {
            throw new ParseException("Unable to parse null timestamp", -1);
        }
        long l;
        try
        {
            l = ISO_DATE_FORMAT.parse(s).getTime();
        }
        catch (ParseException parseexception)
        {
            return ALT_ISO_DATE_FORMAT.parse(s).getTime();
        }
        return l;
    }

    public static long parseIso8601(String s, long l)
    {
        long l1;
        try
        {
            l1 = parseIso8601(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }

    static 
    {
        ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        ALT_ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        ISO_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
        ALT_ISO_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
