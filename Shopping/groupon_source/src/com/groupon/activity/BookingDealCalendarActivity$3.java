// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.travelinventory.TravelInventoryResponse;
import com.groupon.service.travelinventory.GetTravelInventoryCallBack;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity

class this._cls0
    implements GetTravelInventoryCallBack
{

    final BookingDealCalendarActivity this$0;

    public void onSuccess(TravelInventoryResponse travelinventoryresponse)
        throws Exception
    {
        if (travelinventoryresponse.bookableDateList == null || travelinventoryresponse.bookableDateList.isEmpty())
        {
            BookingDealCalendarActivity.access$200(BookingDealCalendarActivity.this);
        }
        BookingDealCalendarActivity.access$300(BookingDealCalendarActivity.this, travelinventoryresponse.minNights, travelinventoryresponse.maxNights, travelinventoryresponse.bookableDateList);
        BookingDealCalendarActivity.access$400(BookingDealCalendarActivity.this);
        BookingDealCalendarActivity.access$500(BookingDealCalendarActivity.this);
    }

    esponse()
    {
        this$0 = BookingDealCalendarActivity.this;
        super();
    }
}
