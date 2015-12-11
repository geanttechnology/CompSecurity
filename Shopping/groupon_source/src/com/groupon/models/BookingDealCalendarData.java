// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.models.travelinventory.BookableDate;
import com.groupon.util.CalendarUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models:
//            GetawaysCalendarData, GenericAmount

public class BookingDealCalendarData extends GetawaysCalendarData
{

    private HashMap availableCheckInDateMap;

    public BookingDealCalendarData(int i, int j, List list)
    {
        minimumNights = i;
        maximumNights = j;
        if (minimumNights < 1)
        {
            minimumNights = 1;
        }
        createBookableDatesMap(list);
        createAvailableCheckInDateMap();
    }

    private void createAvailableCheckInDateMap()
    {
        Calendar calendar;
        availableCheckInDateMap = new HashMap();
        calendar = (Calendar)calendarStartDate.clone();
_L11:
        if (!calendar.before(calendarEndDate)) goto _L2; else goto _L1
_L1:
        if (!bookableDateMap.containsKey(Long.valueOf(calendar.getTimeInMillis()))) goto _L4; else goto _L3
_L3:
        Calendar calendar1;
        Calendar calendar2;
        boolean flag1;
        flag1 = true;
        calendar1 = (Calendar)calendar.clone();
        calendar2 = (Calendar)calendar.clone();
        calendar2.add(5, minimumNights);
_L9:
        boolean flag = flag1;
        if (!calendar1.before(calendar2)) goto _L6; else goto _L5
_L5:
        if (bookableDateMap.containsKey(Long.valueOf(calendar1.getTimeInMillis()))) goto _L8; else goto _L7
_L7:
        flag = false;
_L6:
        if (flag)
        {
            availableCheckInDateMap.put(Long.valueOf(calendar.getTimeInMillis()), bookableDateMap.get(Long.valueOf(calendar.getTimeInMillis())));
        }
_L4:
        calendar.add(5, 1);
        continue; /* Loop/switch isn't completed */
_L8:
        calendar1.add(5, 1);
        if (true) goto _L9; else goto _L2
_L2:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void createBookableDatesMap(List list)
    {
        if (bookableDateMap == null)
        {
            bookableDateMap = new HashMap();
        }
        bookableDateMap.clear();
        calendarStartDate = null;
        calendarEndDate = null;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            BookableDate bookabledate = (BookableDate)list.next();
            Calendar calendar = bookabledate.date;
            CalendarUtil.setCalendarHourToZero(calendar);
            bookableDateMap.put(Long.valueOf(calendar.getTimeInMillis()), bookabledate);
            if (calendarStartDate == null || calendarStartDate.after(calendar))
            {
                calendarStartDate = (Calendar)calendar.clone();
            }
            if (calendarEndDate == null || calendarEndDate.before(calendar))
            {
                calendarEndDate = (Calendar)calendar.clone();
            }
        } while (true);
        if (calendarEndDate != null)
        {
            calendarEndDate.add(5, 2);
        }
    }

    private boolean isBookableDate(Calendar calendar)
    {
        return calendar != null && bookableDateMap.containsKey(Long.valueOf(calendar.getTimeInMillis()));
    }

    public BookableDate calculateTotalPrice(Date date, Date date1)
    {
        if (date != null && date1 != null)
        {
            int j = 0;
            int i = 0;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date1);
            while (calendar.before(calendar1)) 
            {
                long l1 = calendar.getTimeInMillis();
                int l = i;
                int k = j;
                if (bookableDateMap.containsKey(Long.valueOf(l1)))
                {
                    k = j + ((BookableDate)bookableDateMap.get(Long.valueOf(l1))).price.getAmount();
                    l = i + ((BookableDate)bookableDateMap.get(Long.valueOf(l1))).marketPrice.getAmount();
                }
                calendar.add(6, 1);
                i = l;
                j = k;
            }
            date = ((BookableDate)bookableDateMap.get(Long.valueOf(date.getTime()))).price.getCurrencyCode();
            if (Strings.notEmpty(date))
            {
                date1 = new BookableDate();
                date1.price = new GenericAmount(j, date, Integer.toString(j));
                date1.marketPrice = new GenericAmount(i, date, Integer.toString(i));
                return date1;
            }
        }
        return null;
    }

    public GetawaysCalendarData.CalendarError isValidCheckInDate(Date date)
    {
        GetawaysCalendarData.CalendarError calendarerror = super.isValidCheckInDate(date);
        if (calendarerror != GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            return calendarerror;
        }
        if (!availableCheckInDateMap.containsKey(Long.valueOf(date.getTime())))
        {
            return GetawaysCalendarData.CalendarError.INVALID_DATE;
        } else
        {
            return GetawaysCalendarData.CalendarError.NO_ERROR;
        }
    }

    public GetawaysCalendarData.CalendarError isValidCheckOutDate(Date date, Date date1)
    {
        Object obj = super.isValidCheckOutDate(date, date1);
        if (obj != GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            return ((GetawaysCalendarData.CalendarError) (obj));
        }
        Date date2 = date;
        obj = date1;
        if (date1.before(date))
        {
            date2 = date1;
            obj = date;
        }
        date = isValidNumberOfNights(date2, ((Date) (obj)));
        if (date != GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            return date;
        }
        date = Calendar.getInstance();
        date.setTime(date2);
        date1 = Calendar.getInstance();
        date1.setTime(((Date) (obj)));
        for (; date.before(date1); date.add(6, 1))
        {
            if (!isBookableDate(date))
            {
                return GetawaysCalendarData.CalendarError.CONTAIN_BLACKOUT_DAYS;
            }
        }

        return GetawaysCalendarData.CalendarError.NO_ERROR;
    }
}
