// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.callbacks.HotelReviewsRequestCallback;
import com.groupon.db.models.HotelReviews;
import com.groupon.models.hotel.Hotel;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.util.Function1;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected class callback
    implements Function1
{

    protected final HotelReviewsRequestCallback callback;
    private final String reviewSource;
    final HotelsService this$0;

    public void execute(HotelSearchResponse hotelsearchresponse)
        throws RuntimeException
    {
label0:
        {
            if (callback != null)
            {
                hotelsearchresponse = hotelsearchresponse.hotel.hotelReviews.iterator();
                HotelReviews hotelreviews;
                do
                {
                    if (!hotelsearchresponse.hasNext())
                    {
                        break label0;
                    }
                    hotelreviews = (HotelReviews)hotelsearchresponse.next();
                } while (!Strings.equalsIgnoreCase(hotelreviews.sourceType, reviewSource));
                callback.onHotelReviewsSuccess(hotelreviews);
            }
            return;
        }
        callback.onHotelReviewsSuccess(null);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((HotelSearchResponse)obj);
    }

    public Q(String s, HotelReviewsRequestCallback hotelreviewsrequestcallback)
    {
        this$0 = HotelsService.this;
        super();
        reviewSource = s;
        callback = hotelreviewsrequestcallback;
    }
}
