// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.res.Resources;
import java.util.Calendar;
import java.util.Date;

public class EventTimeLeftHelper
{
    public static class TimeSpan
    {

        public final int days;
        public final int hours;
        public final int minutes;
        public final int seconds;
        private final int years;

        public TimeSpan(long l)
        {
            if (l <= 0L)
            {
                seconds = 0;
                minutes = 0;
                hours = 0;
                days = 0;
                years = 0;
                return;
            } else
            {
                days = (int)(l / 1000L / 60L / 60L / 24L);
                hours = (int)(l / 1000L / 60L / 60L) - days * 24;
                minutes = (int)(l / 1000L / 60L) - days * 24 - hours * 60;
                seconds = (int)(l / 1000L) - days * 24 - hours * 60 - minutes * 60;
                years = days / 365;
                return;
            }
        }
    }


    public EventTimeLeftHelper()
    {
    }

    public static String getEndsInTimeMaxUnitString(Resources resources, TimeSpan timespan, boolean flag)
    {
        if (timespan.days > 0)
        {
            if (timespan.hours > 0 && flag)
            {
                return String.format(resources.getString(0x7f07004a), new Object[] {
                    Integer.valueOf(timespan.days), Integer.valueOf(timespan.hours)
                });
            } else
            {
                return String.format(resources.getString(0x7f07004b), new Object[] {
                    Integer.valueOf(timespan.days)
                });
            }
        }
        if (timespan.hours > 0)
        {
            if (timespan.minutes > 0 && flag)
            {
                return String.format(resources.getString(0x7f07004d), new Object[] {
                    Integer.valueOf(timespan.hours), Integer.valueOf(timespan.minutes)
                });
            } else
            {
                return String.format(resources.getString(0x7f07004e), new Object[] {
                    Integer.valueOf(timespan.hours)
                });
            }
        }
        if (timespan.minutes > 0)
        {
            if (timespan.seconds > 0 && flag)
            {
                return String.format(resources.getString(0x7f070050), new Object[] {
                    Integer.valueOf(timespan.minutes), Integer.valueOf(timespan.seconds)
                });
            } else
            {
                return String.format(resources.getString(0x7f070051), new Object[] {
                    Integer.valueOf(timespan.minutes)
                });
            }
        } else
        {
            return String.format(resources.getString(0x7f070053), new Object[] {
                Integer.valueOf(timespan.seconds)
            });
        }
    }

    public static TimeSpan getRemainingDuration(Date date)
    {
        return new TimeSpan(date.getTime() - Calendar.getInstance().getTimeInMillis());
    }
}
