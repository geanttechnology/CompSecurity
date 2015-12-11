// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.hotel;

import com.groupon.models.GetawaysCalendarData;
import com.groupon.util.CalendarUtil;
import java.util.Calendar;
import java.util.Date;

public class HotelSearchCalendarData extends GetawaysCalendarData
{

    private Date actualEndDate;

    public HotelSearchCalendarData()
    {
        calendarStartDate = Calendar.getInstance();
        CalendarUtil.setCalendarHourToZero(calendarStartDate);
        calendarEndDate = Calendar.getInstance();
        calendarEndDate.add(1, 1);
        CalendarUtil.setCalendarHourToZero(calendarEndDate);
        actualEndDate = CalendarUtil.getDateWithoutHour(calendarEndDate);
        calendarEndDate.add(5, 1);
        minimumNights = 1;
        maximumNights = 14;
    }

    public Date getActualMaximumCheckOutDate(Date date, Date date1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (date1.after(date))
        {
            calendar.add(5, maximumNights);
            if (date1.after(calendar.getTime()))
            {
                return CalendarUtil.getDateWithoutHour(calendar.getTime());
            }
        } else
        {
            calendar.add(5, -maximumNights);
            if (date1.before(calendar.getTime()))
            {
                return CalendarUtil.getDateWithoutHour(calendar.getTime());
            }
        }
        return null;
    }

    public com.groupon.models.GetawaysCalendarData.CalendarError isValidCheckInDate(Date date)
    {
        com.groupon.models.GetawaysCalendarData.CalendarError calendarerror = super.isValidCheckInDate(date);
        if (calendarerror != com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            return calendarerror;
        }
        if (actualEndDate.compareTo(date) == 0 || date.after(actualEndDate))
        {
            return com.groupon.models.GetawaysCalendarData.CalendarError.INVALID_DATE;
        } else
        {
            return com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR;
        }
    }

    public com.groupon.models.GetawaysCalendarData.CalendarError isValidCheckOutDate(Date date, Date date1)
    {
        com.groupon.models.GetawaysCalendarData.CalendarError calendarerror = super.isValidCheckOutDate(date, date1);
        if (calendarerror != com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            return calendarerror;
        }
        if (date1.after(actualEndDate))
        {
            return com.groupon.models.GetawaysCalendarData.CalendarError.OUT_RANGE;
        } else
        {
            return isValidNumberOfNights(date, date1);
        }
    }
}
