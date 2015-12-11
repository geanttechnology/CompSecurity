// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.GetawaysCalendarData;
import com.groupon.models.hotel.HotelSearchCalendarData;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            HotelSearchCalendarActivity

class this._cls0
    implements com.squareup.timessquare.terceptor
{

    final HotelSearchCalendarActivity this$0;

    public boolean onCellClicked(Date date)
    {
        com.groupon.models.rror rror;
        if (selectedCheckInDate == null || selectedCheckOutDate != null)
        {
            rror = calendarData.isValidCheckInDate(date);
        } else
        {
            rror = calendarData.isValidCheckOutDate(selectedCheckInDate, date);
        }
        if (rror == com.groupon.models.rror.MAXIMUM_NIGHTS)
        {
            date = ((HotelSearchCalendarData)calendarData).getActualMaximumCheckOutDate(selectedCheckInDate, date);
            if (date != null)
            {
                calendarView.selectDate(date);
                setCheckOutDate(date);
            }
        }
        if (rror != com.groupon.models.rror.NO_ERROR)
        {
            showErrorMessage(rror);
            return true;
        } else
        {
            return false;
        }
    }

    or()
    {
        this$0 = HotelSearchCalendarActivity.this;
        super();
    }
}
