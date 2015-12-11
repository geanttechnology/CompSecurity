// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.models.Hotel;
import com.groupon.loader.HotelLoaderCallbacks;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.view.DealImageView;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class cks extends HotelLoaderCallbacks
{

    final HotelDetails this$0;

    public void onHotelLoaded(Hotel hotel)
    {
        HotelDetails.access$102(HotelDetails.this, true);
        HotelDetails.access$200(HotelDetails.this, hotel);
        HotelDetails.access$300(HotelDetails.this);
        HotelDetails.access$500(HotelDetails.this, HotelDetails.access$400(HotelDetails.this));
        logger.logDealView("", channel.toString(), hotel.remoteId, hotel.uuid, loggingUtils.getMarketRateExtraInfoString(productType, hasRaO));
        dealImageView.doStartImageRotation();
    }

    er(Context context, String s, boolean flag, String s1)
    {
        this$0 = HotelDetails.this;
        super(context, s, flag, s1);
    }
}
