// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.Location;
import com.groupon.models.ReservationHotel;
import com.groupon.models.hotel.HotelReservation;

// Referenced classes of package com.groupon.activity:
//            MarketRateReservation, IntentFactory

class val.lng
    implements android.view.ation._cls5
{

    final MarketRateReservation this$0;
    final Double val$lat;
    final Double val$lng;

    public void onClick(View view)
    {
        double d1 = 0.0D;
        view = new Location();
        double d;
        if (val$lat == null)
        {
            d = 0.0D;
        } else
        {
            d = val$lat.doubleValue();
        }
        view.lat = d;
        if (val$lng == null)
        {
            d = d1;
        } else
        {
            d = val$lng.doubleValue();
        }
        view.lng = d;
        startActivity(MarketRateReservation.access$200(MarketRateReservation.this).newShowOnMapIntent(view, MarketRateReservation.access$000(MarketRateReservation.this).hotel.name, 0));
    }

    ()
    {
        this$0 = final_marketratereservation;
        val$lat = double1;
        val$lng = Double.this;
        super();
    }
}
