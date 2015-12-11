// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import com.poshmark.application.PMApplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils
{
    public static final class TIME_UNIT extends Enum
    {

        private static final TIME_UNIT $VALUES[];
        public static final TIME_UNIT DAYS;
        public static final TIME_UNIT HOURS;
        public static final TIME_UNIT MINUTES;
        public static final TIME_UNIT MONTHS;
        public static final TIME_UNIT SECONDS;
        public static final TIME_UNIT WEEKS;
        public static final TIME_UNIT YEARS;

        public static TIME_UNIT valueOf(String s)
        {
            return (TIME_UNIT)Enum.valueOf(com/poshmark/utils/DateUtils$TIME_UNIT, s);
        }

        public static TIME_UNIT[] values()
        {
            return (TIME_UNIT[])$VALUES.clone();
        }

        static 
        {
            SECONDS = new TIME_UNIT("SECONDS", 0);
            MINUTES = new TIME_UNIT("MINUTES", 1);
            HOURS = new TIME_UNIT("HOURS", 2);
            DAYS = new TIME_UNIT("DAYS", 3);
            WEEKS = new TIME_UNIT("WEEKS", 4);
            MONTHS = new TIME_UNIT("MONTHS", 5);
            YEARS = new TIME_UNIT("YEARS", 6);
            $VALUES = (new TIME_UNIT[] {
                SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS
            });
        }

        private TIME_UNIT(String s, int i)
        {
            super(s, i);
        }
    }


    static SimpleDateFormat displayFormat;
    static SimpleDateFormat formatter_local;
    static SimpleDateFormat formatter_utc;
    static SimpleDateFormat formatter_utc_milli;
    static String str1 = "2013-07-23T01:41:23-07:00";
    static String str2 = "2013-07-23T01:41:23";

    public DateUtils()
    {
    }

    public static long convertMilliSecondsTo(long l, TIME_UNIT time_unit)
    {
        l /= 1000L;
        long l1 = l / 60L;
        long l2 = l1 / 60L;
        long l3 = l2 / 24L;
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[];

            static 
            {
                $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT = new int[TIME_UNIT.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.SECONDS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.MINUTES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.HOURS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.DAYS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.WEEKS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[TIME_UNIT.MONTHS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.DateUtils.TIME_UNIT[time_unit.ordinal()])
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            return 0L;

        case 1: // '\001'
            return l;

        case 2: // '\002'
            return l1;

        case 3: // '\003'
            return l2;

        case 4: // '\004'
            return l3;
        }
    }

    public static String formatDateForDisplay(String s, String s1)
    {
        Object obj = getDateFromString(s);
        long l = ((new Date()).getTime() - ((Date) (obj)).getTime()) / 1000L;
        long l1 = l / 60L;
        long l2 = l1 / 60L;
        long l3 = l2 / 24L;
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        if (l3 > 7L)
        {
            obj = displayFormat.format(((Date) (obj)));
            s1 = ((String) (obj));
            if (s != null)
            {
                s1 = ((String) (obj));
                if (!s.isEmpty())
                {
                    s1 = (new StringBuilder()).append(PMApplication.getContext().getString(0x7f0601e2).toLowerCase()).append(" ").append(((String) (obj))).toString();
                }
            }
            return s1;
        }
        if (l3 == 1L)
        {
            return (new StringBuilder()).append(Long.toString(l3)).append(" ").append(PMApplication.getContext().getString(0x7f0600a1)).toString();
        }
        if (l3 > 1L)
        {
            return (new StringBuilder()).append(Long.toString(l3)).append(" ").append(PMApplication.getContext().getString(0x7f0600a2)).toString();
        }
        if (l2 == 1L)
        {
            return PMApplication.getContext().getString(0x7f060144);
        }
        if (l2 > 1L)
        {
            return (new StringBuilder()).append(Long.toString(l2)).append(" ").append(PMApplication.getContext().getString(0x7f060145)).toString();
        }
        if (l1 == 1L)
        {
            return PMApplication.getContext().getString(0x7f0601a6);
        }
        if (l1 > 1L)
        {
            return (new StringBuilder()).append(Long.toString(l1)).append(" ").append(PMApplication.getContext().getString(0x7f0601a5)).toString();
        }
        if (l <= 0L)
        {
            return PMApplication.getContext().getString(0x7f0601a8);
        } else
        {
            return (new StringBuilder()).append(Long.toString(l)).append(" ").append(PMApplication.getContext().getString(0x7f06023c)).toString();
        }
    }

    private static SimpleDateFormat getCorrectFormatter(String s)
    {
        boolean flag = s.matches("(.*)T(\\d*):(\\d*):(\\d*)(-|\\+)(.*)");
        boolean flag1 = s.matches("(.*)T(\\d*):(\\d*):(\\d*).(\\d*)(-|\\+)(.*)");
        if (flag)
        {
            formatter_utc.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter_utc;
        }
        if (flag1)
        {
            formatter_utc_milli.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter_utc_milli;
        } else
        {
            formatter_local.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter_local;
        }
    }

    public static Date getDateFromString(String s)
    {
        Date date = null;
        if (s != null)
        {
            try
            {
                date = getCorrectFormatter(s).parse(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        }
        return date;
    }

    public static long getDiffBetweenDates(Date date, Date date1, TIME_UNIT time_unit)
    {
        if (date.after(date1))
        {
            return 0L;
        } else
        {
            return convertMilliSecondsTo(getDiffInMilli(date, date1), time_unit);
        }
    }

    public static long getDiffInMilli(Date date, Date date1)
    {
        if (date.after(date1))
        {
            return date.getTime() - date1.getTime();
        } else
        {
            return date1.getTime() - date.getTime();
        }
    }

    public static String getStringFromUTCDate(Date date)
    {
        String s1 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(date);
        int j = s1.length();
        int i = s1.lastIndexOf("-");
        int k = s1.lastIndexOf("+");
        if (i < k)
        {
            i = k + 1;
        } else
        {
            i++;
        }
        date = s1.substring(0, i);
        for (; i < j; i += 2)
        {
            String s = (new StringBuilder()).append(date).append(s1.substring(i, i + 2)).toString();
            date = s;
            if (i + 2 < j)
            {
                date = (new StringBuilder()).append(s).append(":").toString();
            }
        }

        return date;
    }

    public static String getTimeStampStringFromUTCDate(Date date)
    {
        String s1 = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ", Locale.US)).format(date);
        int j = s1.length();
        int i = s1.lastIndexOf("-");
        int k = s1.lastIndexOf("+");
        if (i < k)
        {
            i = k + 1;
        } else
        {
            i++;
        }
        date = s1.substring(0, i);
        for (; i < j; i += 2)
        {
            String s = (new StringBuilder()).append(date).append(s1.substring(i, i + 2)).toString();
            date = s;
            if (i + 2 < j)
            {
                date = (new StringBuilder()).append(s).append(":").toString();
            }
        }

        return date;
    }

    public static boolean isDateWithinPastWindow(Date date, long l, TIME_UNIT time_unit)
    {
        Date date1 = new Date();
        if (!date.after(date1)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        long l4;
        long l1 = (date1.getTime() - date.getTime()) / 1000L;
        long l2 = l1 / 60L;
        long l3 = l2 / 60L;
        l4 = l3 / 24L;
        switch (_cls1..SwitchMap.com.poshmark.utils.DateUtils.TIME_UNIT[time_unit.ordinal()])
        {
        default:
            return false;

        case 4: // '\004'
            break; /* Loop/switch isn't completed */

        case 5: // '\005'
        case 6: // '\006'
            break;

        case 1: // '\001'
            return l1 <= l;

        case 2: // '\002'
            return l2 <= l;

        case 3: // '\003'
            return l3 <= l;
        }
        if (true) goto _L1; else goto _L3
_L3:
        return l4 <= l;
    }

    static 
    {
        formatter_utc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        formatter_utc_milli = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        formatter_local = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        displayFormat = new SimpleDateFormat("MMM dd", Locale.US);
    }
}
