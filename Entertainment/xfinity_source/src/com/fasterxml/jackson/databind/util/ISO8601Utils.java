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
        date = new StringBuilder(k + i + j);
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
        int l3;
        l3 = 0 + 4;
        int i = l3;
        i = l3;
        i = l3;
        int j4 = parseInt(s, 0, l3);
        int j = l3;
        j = l3;
        j = l3;
        checkOffset(s, l3, '-');
        int i4;
        i4 = l3 + 1;
        l3 = i4 + 2;
        int k = l3;
        k = l3;
        k = l3;
        int k4 = parseInt(s, i4, l3);
        int l = l3;
        l = l3;
        l = l3;
        checkOffset(s, l3, '-');
        i4 = l3 + 1;
        l3 = i4 + 2;
        int i1 = l3;
        i1 = l3;
        i1 = l3;
        int l4 = parseInt(s, i4, l3);
        int j1 = l3;
        j1 = l3;
        j1 = l3;
        checkOffset(s, l3, 'T');
        i4 = l3 + 1;
        l3 = i4 + 2;
        int k1 = l3;
        k1 = l3;
        k1 = l3;
        int i5 = parseInt(s, i4, l3);
        int l1 = l3;
        l1 = l3;
        l1 = l3;
        checkOffset(s, l3, ':');
        i4 = l3 + 1;
        l3 = i4 + 2;
        int i2 = l3;
        i2 = l3;
        i2 = l3;
        int j5 = parseInt(s, i4, l3);
        int j2 = l3;
        j2 = l3;
        j2 = l3;
        checkOffset(s, l3, ':');
        i4 = l3 + 1;
        l3 = i4 + 2;
        int k2 = l3;
        k2 = l3;
        k2 = l3;
        int k5 = parseInt(s, i4, l3);
        i4 = 0;
        int l2 = l3;
        l2 = l3;
        l2 = l3;
        if (s.charAt(l3) != '.') goto _L2; else goto _L1
_L1:
        int i3 = l3;
        i3 = l3;
        i3 = l3;
        checkOffset(s, l3, '.');
        i4 = l3 + 1;
        l3 = i4 + 3;
        int j3 = l3;
        j3 = l3;
        j3 = l3;
        int k3 = parseInt(s, i4, l3);
_L13:
        char c = s.charAt(l3);
        if (c != '+' && c != '-') goto _L4; else goto _L3
_L3:
        Object obj = (new StringBuilder()).append("GMT").append(s.substring(l3)).toString();
_L6:
        TimeZone timezone;
        timezone = TimeZone.getTimeZone(((String) (obj)));
        if (!timezone.getID().equals(obj))
        {
            throw new IndexOutOfBoundsException();
        }
          goto _L5
        obj;
_L11:
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to parse date ").append(s).toString(), ((Throwable) (obj)));
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
        obj;
_L10:
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to parse date ").append(s).toString(), ((Throwable) (obj)));
_L5:
        obj = new GregorianCalendar(timezone);
        ((Calendar) (obj)).setLenient(false);
        ((Calendar) (obj)).set(1, j4);
        ((Calendar) (obj)).set(2, k4 - 1);
        ((Calendar) (obj)).set(5, l4);
        ((Calendar) (obj)).set(11, i5);
        ((Calendar) (obj)).set(12, j5);
        ((Calendar) (obj)).set(13, k5);
        ((Calendar) (obj)).set(14, k3);
        obj = ((Calendar) (obj)).getTime();
        return ((Date) (obj));
        obj;
_L8:
        throw new IllegalArgumentException((new StringBuilder()).append("Failed to parse date ").append(s).toString(), ((Throwable) (obj)));
        obj;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        if (true) goto _L10; else goto _L9
_L9:
        obj;
          goto _L11
_L2:
        k3 = i4;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private static int parseInt(String s, int i, int j)
        throws NumberFormatException
    {
        if (i < 0 || j > s.length() || i > j)
        {
            throw new NumberFormatException(s);
        }
        int k = 0;
        if (i < j)
        {
            int l = i + 1;
            i = Character.digit(s.charAt(i), 10);
            if (i < 0)
            {
                throw new NumberFormatException((new StringBuilder()).append("Invalid number: ").append(s).toString());
            }
            k = -i;
            i = l;
        }
        for (; i < j; i++)
        {
            int i1 = Character.digit(s.charAt(i), 10);
            if (i1 < 0)
            {
                throw new NumberFormatException((new StringBuilder()).append("Invalid number: ").append(s).toString());
            }
            k = k * 10 - i1;
        }

        return -k;
    }

    public static TimeZone timeZoneGMT()
    {
        return TIMEZONE_GMT;
    }

}
