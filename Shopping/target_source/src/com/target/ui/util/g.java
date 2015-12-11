// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class g
{

    public static final int MAX_DAY_IN_MONTH_VALUE = 31;
    public static final long ONE_DAY_IN_MS = 0x5265c00L;
    public static final long ONE_HOUR_IN_MS = 0x36ee80L;

    public static long a(long l)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(l);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String a(Date date)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        switch (calendar.get(2))
        {
        default:
            return null;

        case 0: // '\0'
            return "01";

        case 1: // '\001'
            return "02";

        case 2: // '\002'
            return "03";

        case 3: // '\003'
            return "04";

        case 4: // '\004'
            return "05";

        case 5: // '\005'
            return "06";

        case 6: // '\006'
            return "07";

        case 7: // '\007'
            return "08";

        case 8: // '\b'
            return "09";

        case 9: // '\t'
            return "10";

        case 10: // '\n'
            return "11";

        case 11: // '\013'
            return "12";
        }
    }

    public static Date a()
    {
        return new Date();
    }

    public static boolean a(Date date, Date date1, Date date2)
    {
        if (date1 != null || date2 != null)
        {
            if (date1 == null)
            {
                return date.before(date2);
            }
            if (date2 == null)
            {
                return date.after(date1);
            }
            if (!date.after(date1) || !date.before(date2))
            {
                return false;
            }
        }
        return true;
    }

    public static String b(Date date)
    {
        int i;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        i = calendar.get(5);
        i;
        JVM INSTR tableswitch 1 9: default 68
    //                   1 91
    //                   2 91
    //                   3 91
    //                   4 91
    //                   5 91
    //                   6 91
    //                   7 91
    //                   8 91
    //                   9 91;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        date = String.valueOf(i);
_L4:
        Date date1 = date;
        if (Integer.valueOf(date).intValue() > 31)
        {
            date1 = null;
        }
        return date1;
_L2:
        date = (new StringBuilder()).append("0").append(String.valueOf(i)).toString();
        if (true) goto _L4; else goto _L3
_L3:
    }
}
