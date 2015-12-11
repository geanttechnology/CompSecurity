// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.db.models.HotelReviews;
import java.util.Collection;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class TravelReviewsDetailImpressionExtraInfo extends JsonEncodedNSTField
{

    public static final String REVIEW_TYPE_TRIPADVISOR = "TA";
    public static final String REVIEW_TYPE_UGC = "UGC";
    public static final String TRAVEL_REVIEWS_DETAILS_IMPRESSION = "travel_reviews_details";
    protected String reviewType;
    protected Integer reviewsCount;
    protected Double summaryScore;
    protected Integer summaryTotal;

    public TravelReviewsDetailImpressionExtraInfo(HotelReviews hotelreviews)
    {
        reviewType = "TA";
        summaryScore = Double.valueOf(hotelreviews.rating);
        summaryTotal = Integer.valueOf((int)hotelreviews.reviewCount);
        reviewsCount = Integer.valueOf(hotelreviews.reviews.size());
    }

    public TravelReviewsDetailImpressionExtraInfo(String s, String s1, int i)
    {
        reviewType = "UGC";
        if (Strings.notEmpty(summaryScore))
        {
            summaryScore = Double.valueOf(Double.parseDouble(s));
        }
        if (Strings.notEmpty(summaryTotal))
        {
            summaryTotal = Integer.valueOf(Integer.parseInt(s1));
        }
        reviewsCount = Integer.valueOf(i);
    }
}
