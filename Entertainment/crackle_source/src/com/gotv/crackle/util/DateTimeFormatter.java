// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatter
{

    public DateTimeFormatter()
    {
    }

    public static String getHourMinuteString(String s)
    {
        if (s != null)
        {
            if (s.compareTo("null") != 0)
            {
                s = s.split(":");
                int k = 0;
                int j = 0;
                int i = 0;
                int l;
                if (s.length == 2)
                {
                    j = Integer.parseInt(s[0]);
                    i = Integer.parseInt(s[1]);
                } else
                if (s.length > 2)
                {
                    k = Integer.parseInt(s[0]);
                    j = Integer.parseInt(s[1]);
                    i = Integer.parseInt(s[2]);
                }
                l = i;
                if (i > 0)
                {
                    l = 1;
                }
                if (k > 0)
                {
                    return (new StringBuilder()).append(k).append(" hr ").append(j + l).append(" m ").toString();
                } else
                {
                    return (new StringBuilder()).append(j + l).append(" m ").toString();
                }
            } else
            {
                return "";
            }
        } else
        {
            return "";
        }
    }

    public static String getHourMinuteStringFromSeconds(String s)
    {
        if (s != null)
        {
            if (s.compareTo("null") != 0)
            {
                int j = Integer.parseInt(s);
                int i = Math.round(j / 3600);
                j = (j - i * 3600) / 60;
                return (new StringBuilder()).append(i).append(" hr ").append(j).append(" m ").toString();
            } else
            {
                return "";
            }
        } else
        {
            return "";
        }
    }

    public static String getPlayerTimeFromMs(int i)
    {
        i /= 1000;
        int j = i / 60;
        return String.format("%d:%02d:%02d", new Object[] {
            Integer.valueOf(i / 3600), Integer.valueOf(j % 60), Integer.valueOf(i % 60)
        });
    }

    public static String getSecondsFromDurationString(String s)
    {
        int i;
        int j;
        int k;
        s = s.split(":");
        k = 0;
        i = 0;
        j = 0;
        if (s.length != 2) goto _L2; else goto _L1
_L1:
        i = Integer.parseInt(s[0]);
        j = Integer.parseInt(s[1]);
_L4:
        return (new StringBuilder()).append("").append(k * 3600 + i * 60 + j).toString();
_L2:
        if (s.length > 2)
        {
            k = Integer.parseInt(s[0]);
            i = Integer.parseInt(s[1]);
            j = Integer.parseInt(s[2]);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Date parseJSONDateString(String s, String s1)
        throws ParseException
    {
        return (new SimpleDateFormat(s1, Locale.US)).parse(s);
    }

    public static String stringWithDateFormat(Date date, String s)
        throws ParseException
    {
        return (new SimpleDateFormat(s, Locale.US)).format(date);
    }
}
