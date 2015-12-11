// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.Location;

// Referenced classes of package com.groupon.activity:
//            HotelDetails, IntentFactory

class val.lng
    implements android.view.tener
{

    final HotelDetails this$0;
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
        startActivity(intentFactory.newShowOnMapIntent(view, HotelDetails.access$1500(HotelDetails.this).name, 0));
    }

    ()
    {
        this$0 = final_hoteldetails;
        val$lat = double1;
        val$lng = Double.this;
        super();
    }
}
