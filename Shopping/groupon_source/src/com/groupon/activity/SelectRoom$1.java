// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import com.groupon.adapter.RoomsAdapter;
import com.groupon.models.RoomCustomField;
import com.groupon.models.hotel.HotelRoom;
import com.groupon.util.LoginUtil;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            SelectRoom

class this._cls0
    implements android.widget.nItemClickListener
{

    final SelectRoom this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = SelectRoom.access$000(SelectRoom.this).getItem(i);
        SelectRoom.access$100(SelectRoom.this).startMarketRateReservationFlow(((RoomCustomField)((HotelRoom) (adapterview)).customFields.get(0)).roomToken, hotelName, hotelLocation, hotelImageUrl, gBucksDisclaimer, channel, hotelId, bookingMetaData, productType);
    }

    ()
    {
        this$0 = SelectRoom.this;
        super();
    }
}
