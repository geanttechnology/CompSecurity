// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils
{

    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone("GMT");

    public ISO8601Utils()
    {
    }

    private static void checkOffset(String s, int i, char c)
        throws IndexOutOfBoundsException
    {
        char c1 = s.charAt(i);
        if (c1 != c)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Expected '").append(c).append("' character but found '").append(c1).append("'").toString());
        } else
        {
            return;
        }
    }

    public static String format(Date date)
    {
        return format(date, false, TIMEZONE_GMT);
    }

    public static String format(Date date, boolean flag)
    {
        return format(date, flag, TIMEZONE_GMT);
    }

    public static String format(Date date, boolean flag, TimeZone timezone)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar(timezone, Locale.US);
        gregoriancalendar.setTime(date);
        int k = "yyyy-MM-ddThh:mm:ss".length();
        int i;
        int j;
        if (flag)
        {
            i = ".sss".length();
        } else
        {
            i = 0;
        }
        if (timezone.getRawOffset() == 0)
        {
            j = "Z".length();
        } else
        {
            j = "+hh:mm".length();
        }
        date = new StringBuilder(j + (k + i));
        padInt(date, gregoriancalendar.get(1), "yyyy".length());
        date.append('-');
        padInt(date, gregoriancalendar.get(2) + 1, "MM".length());
        date.append('-');
        padInt(date, gregoriancalendar.get(5), "dd".length());
        date.append('T');
        padInt(date, gregoriancalendar.get(11), "hh".length());
        date.append(':');
        padInt(date, gregoriancalendar.get(12), "mm".length());
        date.append(':');
        padInt(date, gregoriancalendar.get(13), "ss".length());
        if (flag)
        {
            date.append('.');
            padInt(date, gregoriancalendar.get(14), "sss".length());
        }
        i = timezone.getOffset(gregoriancalendar.getTimeInMillis());
        if (i != 0)
        {
            j = Math.abs(i / 60000 / 60);
            int l = Math.abs((i / 60000) % 60);
            char c;
            if (i < 0)
            {
                c = '-';
            } else
            {
                c = '+';
            }
            date.append(c);
            padInt(date, j, "hh".length());
            date.append(':');
            padInt(date, l, "mm".length());
        } else
        {
            date.append('Z');
        }
        return date.toString();
    }

    private static void padInt(StringBuilder stringbuilder, int i, int j)
    {
        String s = Integer.toString(i);
        for (i = j - s.length(); i > 0; i--)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(s);
    }

    public static Date parse(String s)
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        j = parseInt(s, 0, 4);
        checkOffset(s, 4, '-');
        k = parseInt(s, 5, 7);
        checkOffset(s, 7, '-');
        l = parseInt(s, 8, 10);
        checkOffset(s, 10, 'T');
        i1 = parseInt(s, 11, 13);
        checkOffset(s, 13, ':');
        j1 = parseInt(s, 14, 16);
        checkOffset(s, 16, ':');
        k1 = parseInt(s, 17, 19);
        if (s.charAt(19) != '.') goto _L2; else goto _L1
_L1:
        int i;
        checkOffset(s, 19, '.');
        i = parseInt(s, 20, 23);
        byte byte0 = 23;
_L8:
        char c = s.charAt(byte0);
        if (c != '+' && c != '-') goto _L4; else goto _L3
_L3:
        Object obj = (new StringBuilder()).append("GMT").append(s.substring(byte0)).toString();
_L6:
        TimeZone timezone;
        timezone = TimeZone.getTimeZone(((String) (obj)));
        if (!timezone.getID().equals(obj))
        {
            throw new IndexOutOfBoundsException();
        }
          goto _L5
        obj;
_L7:
        if (s == null)
        {
            s = null;
        } else
        {
            s = (new StringBuilder()).append('"').append(s).append("'").toString();
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to parse date [").append(s).append("]: ").append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
_L4:
label0:
        {
            if (c != 'Z')
            {
                break label0;
            }
            obj = "GMT";
        }
          goto _L6
        throw new IndexOutOfBoundsException((new StringBuilder()).append("Invalid time zone indicator ").append(c).toString());
_L5:
        obj = new GregorianCalendar(timezone);
        ((Calendar) (obj)).setLenient(false);
        ((Calendar) (obj)).set(1, j);
        ((Calendar) (obj)).set(2, k - 1);
        ((Calendar) (obj)).set(5, l);
        ((Calendar) (obj)).set(11, i1);
        ((Calendar) (obj)).set(12, j1);
        ((Calendar) (obj)).set(13, k1);
        ((Calendar) (obj)).set(14, i);
        obj = ((Calendar) (obj)).getTime();
        return ((Date) (obj));
        obj;
          goto _L7
_L2:
        byte0 = 19;
        i = 0;
          goto _L8
        obj;
          goto _L7
    }

    private static int parseInt(String s, int i, int j)
        throws NumberFormatException
    {
        if (i < 0 || j > s.length() || i > j)
        {
            throw new NumberFormatException(s);
        }
        int l = 0;
        int k = i;
        if (i < j)
        {
            k = Character.digit(s.charAt(i), 10);
            if (k < 0)
            {
                throw new NumberFormatException((new StringBuilder()).append("Invalid number: ").append(s).toString());
            }
            l = -k;
            k = i + 1;
        }
        for (; k < j; k++)
        {
            i = Character.digit(s.charAt(k), 10);
            if (i < 0)
            {
                throw new NumberFormatException((new StringBuilder()).append("Invalid number: ").append(s).toString());
            }
            l = l * 10 - i;
        }

        return -l;
    }

    public static TimeZone timeZoneGMT()
    {
        return TIMEZONE_GMT;
    }

}
