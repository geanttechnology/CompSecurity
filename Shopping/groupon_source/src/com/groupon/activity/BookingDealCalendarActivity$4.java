// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.GetawaysCalendarData;
import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity

class this._cls0
    implements com.squareup.timessquare.terceptor
{

    final BookingDealCalendarActivity this$0;

    public boolean onCellClicked(Date date)
    {
        if (selectedCheckInDate == null || selectedCheckOutDate != null)
        {
            date = calendarData.isValidCheckInDate(date);
        } else
        {
            date = calendarData.isValidCheckOutDate(selectedCheckInDate, date);
        }
        if (date != com.groupon.models.rror.NO_ERROR)
        {
            showErrorMessage(date);
            return true;
        } else
        {
            return false;
        }
    }

    or()
    {
        this$0 = BookingDealCalendarActivity.this;
        super();
    }
}
