// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class this._cls0
    implements android.view.tener
{

    final HotelDetails this$0;

    public void onClick(View view)
    {
        HotelDetails.access$900(HotelDetails.this);
        logger.logClick("", "guest_selection_click", "market_rate", hotelId);
    }

    er()
    {
        this$0 = HotelDetails.this;
        super();
    }
}
