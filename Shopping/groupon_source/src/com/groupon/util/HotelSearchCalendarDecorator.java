// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.hotel.HotelSearchCalendarData;
import com.squareup.timessquare.CalendarCellView;
import java.util.Date;

// Referenced classes of package com.groupon.util:
//            GetawaysCalendarCellDecorator

public class HotelSearchCalendarDecorator extends GetawaysCalendarCellDecorator
{

    public HotelSearchCalendarDecorator(HotelSearchCalendarData hotelsearchcalendardata)
    {
        super(hotelsearchcalendardata);
    }

    public void decorate(CalendarCellView calendarcellview, Date date)
    {
        if (!calendarcellview.isCurrentMonth())
        {
            calendarcellview.setText("");
        }
        super.decorate(calendarcellview, date);
    }
}
