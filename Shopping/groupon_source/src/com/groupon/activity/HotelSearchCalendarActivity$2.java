// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import java.util.Calendar;

// Referenced classes of package com.groupon.activity:
//            HotelSearchCalendarActivity

class this._cls0
    implements android.view.ivity._cls2
{

    final HotelSearchCalendarActivity this$0;

    public void onClick(View view)
    {
        if (selectedCheckInDate != null)
        {
            if (selectedCheckOutDate == null)
            {
                view = Calendar.getInstance();
                view.setTime(selectedCheckInDate);
                view.add(5, 1);
                selectedCheckOutDate = view.getTime();
            }
            HotelSearchCalendarActivity.access$000(HotelSearchCalendarActivity.this);
            setResult(1, HotelSearchCalendarActivity.access$100(selectedCheckInDate, selectedCheckOutDate));
        }
        finish();
    }

    ()
    {
        this$0 = HotelSearchCalendarActivity.this;
        super();
    }
}
