// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.BookingDealCalendarDecorator;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity

class this._cls0
    implements com.squareup.timessquare.tedListener
{

    final BookingDealCalendarActivity this$0;

    public void onDateSelected(Date date)
    {
        if (selectedCheckInDate == null)
        {
            setCheckInDate(date);
        } else
        if (selectedCheckOutDate == null)
        {
            setCheckOutDate(date);
            return;
        }
    }

    public void onDateUnselected(Date date)
    {
        if (selectedCheckOutDate != null)
        {
            selectedCheckInDate = null;
            selectedCheckOutDate = null;
        }
        BookingDealCalendarActivity.access$600(BookingDealCalendarActivity.this, null);
        ((BookingDealCalendarDecorator)calendarDecorator).setPotentialCheckoutDate(null);
    }

    electedListener()
    {
        this$0 = BookingDealCalendarActivity.this;
        super();
    }
}
