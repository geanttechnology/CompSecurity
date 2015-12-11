// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.Date;

public class UserProfile
{
    public static class AverageRatingDetails
    {

        public double rating;
        public long ratingCount;

        public AverageRatingDetails()
        {
            rating = -1D;
            ratingCount = -1L;
        }
    }


    public boolean bIsTopRatedSeller;
    public int feedbackScore;
    public String myWorldLargeImage;
    public String myWorldSmallImage;
    public final long negativeFeedbackCount[] = {
        0L, 0L, 0L
    };
    public final long neutralFeedbackCount[] = {
        0L, 0L, 0L
    };
    public final long positiveFeedbackCount[] = {
        0L, 0L, 0L
    };
    public double positiveFeedbackPercent;
    public AverageRatingDetails ratingCommunication;
    public AverageRatingDetails ratingItemAsDescribed;
    public AverageRatingDetails ratingShippingAndHandlingCharges;
    public AverageRatingDetails ratingShippingTime;
    public String ratingStar;
    public Date registrationDate;
    public String sellerBusinessType;
    public long uniqueNegativeFeedbackCount;
    public long uniqueNeutralFeedbackCount;
    public long uniquePositiveFeedbackCount;
    public String userId;

    public UserProfile()
    {
        userId = null;
        uniqueNegativeFeedbackCount = 0L;
        uniqueNeutralFeedbackCount = 0L;
        uniquePositiveFeedbackCount = 0L;
        positiveFeedbackPercent = 0.0D;
        feedbackScore = -1;
        registrationDate = null;
        ratingCommunication = null;
        ratingItemAsDescribed = null;
        ratingShippingAndHandlingCharges = null;
        ratingShippingTime = null;
        myWorldSmallImage = null;
        myWorldLargeImage = null;
        bIsTopRatedSeller = false;
        ratingStar = null;
        sellerBusinessType = null;
    }
}
