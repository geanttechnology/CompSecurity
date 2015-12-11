// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.o;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
{

    private static final Pattern a = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})(?:\\.(\\d{3}))?(?:([+-])(\\d{2}):(\\d{2}))?");

    public static long a(Date date, TimeUnit timeunit)
    {
        Date date1 = new Date();
        if (date == null)
        {
            throw new IllegalArgumentException("You can't check time difference of a null Date");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("You can't use null as a time unit");
        }
        if (date1.equals(date))
        {
            return 0L;
        } else
        {
            return timeunit.convert(Math.abs(date.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
        }
    }

    public static String a(Date date)
    {
        String s = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.UK)).format(date);
        date = s.substring(0, s.length() - 2);
        s = s.substring(s.length() - 2);
        return (new StringBuilder()).append(date).append(":").append(s).toString();
    }

    public static Date a(String s)
    {
        Object obj;
        boolean flag = false;
        obj = null;
        Calendar calendar;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (s != null)
        {
            flag = a.matcher(s).matches();
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = a.matcher(s);
        ((Matcher) (obj)).matches();
        i = Integer.parseInt(((Matcher) (obj)).group(1));
        j = Integer.parseInt(((Matcher) (obj)).group(2));
        k = Integer.parseInt(((Matcher) (obj)).group(3));
        l = Integer.parseInt(((Matcher) (obj)).group(4));
        i1 = Integer.parseInt(((Matcher) (obj)).group(5));
        j1 = Integer.parseInt(((Matcher) (obj)).group(6));
        if (((Matcher) (obj)).group(7) == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        s = Integer.valueOf(Integer.parseInt(((Matcher) (obj)).group(7)));
_L6:
        if (((Matcher) (obj)).group(8) == null || ((Matcher) (obj)).group(9) == null || ((Matcher) (obj)).group(10) == null) goto _L4; else goto _L3
_L3:
        flag = "+".equals(((Matcher) (obj)).group(8));
        k1 = Integer.parseInt(((Matcher) (obj)).group(9));
        obj = Integer.valueOf(Integer.parseInt(((Matcher) (obj)).group(10)) * 60 * 1000 + k1 * 60 * 60 * 1000);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = Integer.valueOf(-((Integer) (obj)).intValue());
_L5:
        calendar = Calendar.getInstance();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        calendar = Calendar.getInstance(new SimpleTimeZone(((Integer) (obj)).intValue(), ""));
        calendar.set(1, i);
        calendar.set(2, j - 1);
        calendar.set(5, k);
        calendar.set(11, l);
        calendar.set(12, i1);
        calendar.set(13, j1);
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        obj = Integer.valueOf(0);
        calendar.set(14, ((Integer) (obj)).intValue());
        obj = calendar.getTime();
_L2:
        return ((Date) (obj));
        s;
        return null;
_L4:
        obj = null;
          goto _L5
        s = null;
          goto _L6
    }

    public static String b(Date date)
    {
        return (new SimpleDateFormat("d MMM yyyy HH:mm", Locale.UK)).format(date);
    }

}
