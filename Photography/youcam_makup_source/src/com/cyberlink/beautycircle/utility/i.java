// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.util.Pair;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class i
{

    public static Pair a(Date date, Date date1)
    {
        int j = 0;
        long l1 = date.getTime() - date1.getTime();
        byte byte0;
        int k;
        int l;
        long l2;
        if (l1 < 0L)
        {
            l1 = -l1;
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        if (l1 > 0x5265c00L)
        {
            k = (int)(l1 / 0x5265c00L);
            l1 -= (long)k * 0x5265c00L;
        } else
        {
            k = 0;
        }
        l2 = l1;
        if (l1 > 0x36ee80L)
        {
            j = (int)(l1 / 0x36ee80L);
            l2 = l1 - (long)j * 0x36ee80L;
        }
        l = j;
        if (l2 > 0L)
        {
            l = j + 1;
        }
        return new Pair(Integer.valueOf(k * byte0), Integer.valueOf(l));
    }

    public static String a(String s, String s1, String s2)
    {
        s1 = new SimpleDateFormat(s1, Locale.US);
        try
        {
            s = s1.parse(s);
            s = (new SimpleDateFormat(s2, Locale.US)).format(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static String a(Date date)
    {
        if (date == null)
        {
            return "";
        }
        long l1 = System.currentTimeMillis() - date.getTime();
        if (l1 > 0x240c8400L)
        {
            int j = (int)(l1 / 0x240c8400L);
            return String.format(Locale.getDefault(), Globals.n().getApplicationContext().getString(m.bc_short_time_week), new Object[] {
                Integer.valueOf(j)
            });
        }
        if (l1 > 0x5265c00L)
        {
            int k = (int)(l1 / 0x5265c00L);
            return String.format(Locale.getDefault(), Globals.n().getApplicationContext().getString(m.bc_short_time_day), new Object[] {
                Integer.valueOf(k)
            });
        }
        if (l1 > 0x36ee80L)
        {
            int l = (int)(l1 / 0x36ee80L);
            return String.format(Locale.getDefault(), Globals.n().getApplicationContext().getString(m.bc_short_time_hour), new Object[] {
                Integer.valueOf(l)
            });
        }
        int j1 = (int)(l1 / 60000L);
        int i1 = j1;
        if (j1 < 1)
        {
            i1 = 1;
        }
        return String.format(Locale.getDefault(), Globals.n().getApplicationContext().getString(m.bc_short_time_min), new Object[] {
            Integer.valueOf(i1)
        });
    }

    public static Date a(String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static int b(Date date, Date date1)
    {
        long l1 = date.getTime() - date1.getTime();
        byte byte0 = 1;
        int j = 0;
        long l = l1;
        if (l1 < 0L)
        {
            l = -l1;
            byte0 = -1;
        }
        l1 = l;
        if (l > 0x5265c00L)
        {
            j = (int)(l / 0x5265c00L);
            l1 = l - (long)j * 0x5265c00L;
        }
        int k = j;
        if (l1 > 0L)
        {
            k = j + 1;
        }
        return k * byte0;
    }

    public static String b(String s)
    {
        String s1 = (new Locale("", s.substring(3))).getDisplayCountry();
        s = s1;
        if (s1.equals(Globals.n().getApplicationContext().getString(m.bc_friendly_country_name_zh_china_src)))
        {
            s = Globals.n().getApplicationContext().getString(m.bc_friendly_country_name_zh_china_des);
        }
        return s;
    }

    public static String b(Date date)
    {
        return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US)).format(date);
    }

    public static String c(Date date)
    {
        return DateFormat.getDateInstance(2).format(date);
    }

    public static String d(Date date)
    {
        return (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(date);
    }
}
