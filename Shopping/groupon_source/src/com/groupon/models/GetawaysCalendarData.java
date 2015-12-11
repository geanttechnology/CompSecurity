// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.util.CalendarUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public abstract class GetawaysCalendarData
{
    public static final class CalendarError extends Enum
    {

        private static final CalendarError $VALUES[];
        public static final CalendarError CONTAIN_BLACKOUT_DAYS;
        public static final CalendarError INVALID_DATE;
        public static final CalendarError MAXIMUM_NIGHTS;
        public static final CalendarError MINIMUM_NIGHTS;
        public static final CalendarError NO_ERROR;
        public static final CalendarError OUT_RANGE;

        public static CalendarError valueOf(String s)
        {
            return (CalendarError)Enum.valueOf(com/groupon/models/GetawaysCalendarData$CalendarError, s);
        }

        public static CalendarError[] values()
        {
            return (CalendarError[])$VALUES.clone();
        }

        static 
        {
            NO_ERROR = new CalendarError("NO_ERROR", 0);
            OUT_RANGE = new CalendarError("OUT_RANGE", 1);
            INVALID_DATE = new CalendarError("INVALID_DATE", 2);
            MINIMUM_NIGHTS = new CalendarError("MINIMUM_NIGHTS", 3);
            MAXIMUM_NIGHTS = new CalendarError("MAXIMUM_NIGHTS", 4);
            CONTAIN_BLACKOUT_DAYS = new CalendarError("CONTAIN_BLACKOUT_DAYS", 5);
            $VALUES = (new CalendarError[] {
                NO_ERROR, OUT_RANGE, INVALID_DATE, MINIMUM_NIGHTS, MAXIMUM_NIGHTS, CONTAIN_BLACKOUT_DAYS
            });
        }

        private CalendarError(String s, int i)
        {
            super(s, i);
        }
    }


    public HashMap bookableDateMap;
    public Calendar calendarEndDate;
    public Calendar calendarStartDate;
    public int maximumNights;
    public int minimumNights;

    public GetawaysCalendarData()
    {
    }

    public CalendarError isValidCheckInDate(Date date)
    {
        if (date == null)
        {
            return CalendarError.INVALID_DATE;
        }
        if (!isWithinValidRange(date))
        {
            return CalendarError.INVALID_DATE;
        } else
        {
            return CalendarError.NO_ERROR;
        }
    }

    public CalendarError isValidCheckOutDate(Date date, Date date1)
    {
        if (date == null || date1 == null)
        {
            return CalendarError.INVALID_DATE;
        }
        if (!isWithinValidRange(date1))
        {
            return CalendarError.OUT_RANGE;
        } else
        {
            return CalendarError.NO_ERROR;
        }
    }

    protected CalendarError isValidNumberOfNights(Date date, Date date1)
    {
        Date date2 = date;
        Date date3 = date1;
        if (date1.before(date))
        {
            date2 = date1;
            date3 = date;
        }
        int i = CalendarUtil.nightsBetweenDates(date2, date3);
        if (i < minimumNights)
        {
            return CalendarError.MINIMUM_NIGHTS;
        }
        if (i > maximumNights)
        {
            return CalendarError.MAXIMUM_NIGHTS;
        } else
        {
            return CalendarError.NO_ERROR;
        }
    }

    protected boolean isWithinValidRange(Date date)
    {
        return date.compareTo(calendarStartDate.getTime()) >= 0 && date.compareTo(calendarEndDate.getTime()) <= 0;
    }
}
