// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.res.Resources;
import com.groupon.models.GetawaysCalendarData;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarCellView;
import java.util.Date;
import java.util.List;

public abstract class GetawaysCalendarCellDecorator
    implements CalendarCellDecorator
{

    protected GetawaysCalendarData calendarData;
    protected List minimumDates;
    protected Date selectedCheckInDate;
    protected Date selectedCheckOutDate;

    public GetawaysCalendarCellDecorator(GetawaysCalendarData getawayscalendardata)
    {
        calendarData = getawayscalendardata;
    }

    private void setAvailableCellView(CalendarCellView calendarcellview)
    {
        calendarcellview.setTextColor(calendarcellview.getResources().getColor(0x7f0e01c7));
        calendarcellview.setBackgroundResource(0x7f02008e);
    }

    private void setHighlightedCellView(CalendarCellView calendarcellview, boolean flag)
    {
        if (flag)
        {
            calendarcellview.setBackgroundResource(0x7f020090);
        } else
        {
            calendarcellview.setBackgroundResource(0x7f02008f);
        }
        calendarcellview.setTextColor(calendarcellview.getResources().getColor(0x7f0e00c2));
    }

    private void setSelectedCellView(CalendarCellView calendarcellview)
    {
        calendarcellview.setTextColor(calendarcellview.getResources().getColor(0x7f0e0054));
        calendarcellview.setBackgroundResource(0x7f02008e);
    }

    private void setUnavailableCellView(CalendarCellView calendarcellview)
    {
        calendarcellview.setTextColor(calendarcellview.getResources().getColor(0x7f0e0053));
        calendarcellview.setBackgroundResource(0x106000d);
    }

    public void decorate(CalendarCellView calendarcellview, Date date)
    {
        if (calendarData == null) goto _L2; else goto _L1
_L1:
        if (selectedCheckInDate == null)
        {
            if (calendarData.isValidCheckInDate(date) == com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
            {
                setAvailableCellView(calendarcellview);
            } else
            {
                setUnavailableCellView(calendarcellview);
            }
        } else
        if (selectedCheckOutDate == null)
        {
            if (selectedCheckInDate.compareTo(date) == 0)
            {
                setSelectedCellView(calendarcellview);
            } else
            if (calendarData.isValidCheckOutDate(selectedCheckInDate, date) == com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
            {
                setAvailableCellView(calendarcellview);
            } else
            {
                setUnavailableCellView(calendarcellview);
            }
        } else
        if (date.before(selectedCheckOutDate) && date.after(selectedCheckInDate) || selectedCheckOutDate.compareTo(date) == 0 || selectedCheckInDate.compareTo(date) == 0)
        {
            setSelectedCellView(calendarcellview);
        } else
        if (calendarData.isValidCheckInDate(date) == com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            setAvailableCellView(calendarcellview);
        } else
        {
            setUnavailableCellView(calendarcellview);
        }
_L8:
        if (minimumDates == null || !calendarcellview.isCurrentMonth()) goto _L2; else goto _L3
_L3:
        if (minimumDates.lastIndexOf(date) != minimumDates.size() - 1) goto _L5; else goto _L4
_L4:
        setHighlightedCellView(calendarcellview, true);
_L2:
        return;
_L5:
        if (!minimumDates.contains(date)) goto _L2; else goto _L6
_L6:
        setHighlightedCellView(calendarcellview, false);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void reset()
    {
        selectedCheckInDate = null;
        selectedCheckOutDate = null;
        minimumDates = null;
    }

    public void setMinimumDates(List list)
    {
        minimumDates = list;
    }

    public void setSelectedDate(Date date, Date date1)
    {
        selectedCheckInDate = date;
        selectedCheckOutDate = date1;
    }
}
