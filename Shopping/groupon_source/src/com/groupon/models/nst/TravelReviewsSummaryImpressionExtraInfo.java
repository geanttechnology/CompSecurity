// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.db.models.Deal;
import com.groupon.db.models.HotelReviews;
import com.groupon.db.models.Merchant;
import java.util.Collection;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class TravelReviewsSummaryImpressionExtraInfo extends JsonEncodedNSTField
{

    public static final String REVIEW_TYPES_TA_ONLY = "TAOnly";
    public static final String REVIEW_TYPES_TA_UGC = "TA+UGC";
    public static final String REVIEW_TYPES_UGC_ONLY = "UGCOnly";
    public static final String TRAVEL_REVIEWS_SUMMARY_IMPRESSION = "travel_reviews_summary";
    public static final String TYPE_BOOKING_DEAL = "bookingDeal";
    public static final String TYPE_LAST_MINUTE = "lastMinute";
    public static final String TYPE_MARKET_RATE = "marketRate";
    public static final String TYPE_VOUCHER_DEAL = "voucherDeal";
    protected String reviewTypes;
    protected Integer taCount;
    protected Double taScore;
    protected Integer taTotal;
    protected Integer ugcCount;
    protected Double ugcScore;
    protected Integer ugcTotal;

    public TravelReviewsSummaryImpressionExtraInfo(Deal deal)
    {
        addUgcInfo(deal);
    }

    public TravelReviewsSummaryImpressionExtraInfo(HotelReviews hotelreviews)
    {
        addTripAdvisorInfo(hotelreviews);
    }

    public TravelReviewsSummaryImpressionExtraInfo(HotelReviews hotelreviews, Deal deal)
    {
        addTripAdvisorInfo(hotelreviews);
        addUgcInfo(deal);
    }

    public void addTripAdvisorInfo(HotelReviews hotelreviews)
    {
        if (hotelreviews == null)
        {
            return;
        }
        if (!Strings.isEmpty(reviewTypes)) goto _L2; else goto _L1
_L1:
        reviewTypes = "TAOnly";
_L4:
        taScore = Double.valueOf(hotelreviews.rating);
        taTotal = Integer.valueOf((int)hotelreviews.reviewCount);
        taCount = Integer.valueOf(hotelreviews.reviews.size());
        return;
_L2:
        if (reviewTypes.equals("UGCOnly"))
        {
            reviewTypes = "TA+UGC";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void addUgcInfo(Deal deal)
    {
        String s;
        String s1;
        int i;
        boolean flag;
        s = deal.derivedMerchantRecommendationPercentMessage;
        s1 = deal.derivedMerchantRecommendationTotalMessage;
        if (deal.merchant == null || deal.merchant.tips == null)
        {
            i = 0;
        } else
        {
            i = deal.merchant.tips.size();
        }
        if (Strings.notEmpty(s) && Strings.notEmpty(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && i == 0)
        {
            return;
        }
        if (!Strings.isEmpty(reviewTypes)) goto _L2; else goto _L1
_L1:
        reviewTypes = "UGCOnly";
_L4:
        if (flag)
        {
            ugcScore = Double.valueOf(Double.parseDouble(s));
            ugcTotal = Integer.valueOf(Integer.parseInt(s1));
        }
        ugcCount = Integer.valueOf(i);
        return;
_L2:
        if (reviewTypes.equals("TAOnly"))
        {
            reviewTypes = "TA+UGC";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
