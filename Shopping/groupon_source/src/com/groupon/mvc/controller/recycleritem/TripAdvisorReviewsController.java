// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.HotelReviews;
import com.groupon.mvc.model.TripAdvisorReviews;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class TripAdvisorReviewsController extends RecyclerItemViewController
{

    private Deal deal;
    private HotelReviews hotelReviews;
    private boolean isTravelTripAdvisorReviewsEnabled;

    public TripAdvisorReviewsController(Context context)
    {
        super(context);
        isTravelTripAdvisorReviewsEnabled = false;
    }

    public void processData()
    {
        if (!isTravelTripAdvisorReviewsEnabled || hotelReviews == null)
        {
            setState(0);
            return;
        }
        model = new TripAdvisorReviews();
        ((TripAdvisorReviews)model).hotelReviews = hotelReviews;
        ((TripAdvisorReviews)model).uuid = deal.uuid;
        TripAdvisorReviews tripadvisorreviews = (TripAdvisorReviews)model;
        String s;
        if (deal.isTravelBookableDeal)
        {
            s = "bookingDeal";
        } else
        {
            s = "voucherDeal";
        }
        tripadvisorreviews.dealType = s;
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setHotelReviews(HotelReviews hotelreviews)
    {
        setState(1);
        hotelReviews = hotelreviews;
    }

    public void setTravelTripAdvisorReviewsEnabled(boolean flag)
    {
        isTravelTripAdvisorReviewsEnabled = flag;
    }
}
