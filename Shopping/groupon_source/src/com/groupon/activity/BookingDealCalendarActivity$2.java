// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.GetawaysCalendarData;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity, BookingMetaData, IntentFactory

class this._cls0
    implements android.view.ivity._cls2
{

    final BookingDealCalendarActivity this$0;

    public void onClick(View view)
    {
        if (selectedCheckInDate != null)
        {
            if (selectedCheckOutDate == null)
            {
                selectedCheckOutDate = new Date(selectedCheckInDate.getTime() + (long)calendarData.minimumNights * 0x5265c00L);
            }
            BookingDealCalendarActivity.access$100(BookingDealCalendarActivity.this);
            view = Calendar.getInstance();
            view.setTime(selectedCheckInDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedCheckOutDate);
            booking.setStartDate(view);
            booking.setEndDate(calendar);
            startActivity(intentFactory.newConfirmGetawaysPurchaseIntent(dealId, channel, optionId, booking, redirectToEnterCode));
        }
    }

    ()
    {
        this$0 = BookingDealCalendarActivity.this;
        super();
    }
}
