// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;

public class TravelReviewsAbTestHelper
{

    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private boolean isTripAdvisorReviewsINTLEnabled;
    private boolean isTripAdvisorReviewsUSCAEnabled;
    private boolean isUGCReviewsINTLEnabled;
    private boolean isUGCReviewsUSCAEnabled;

    public TravelReviewsAbTestHelper()
    {
    }

    private void init()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (abTestService.isVariantEnabled("travelShowTravelReviews1507USCA", "TAonly") || abTestService.isVariantEnabled("travelShowTravelReviews1507USCA", "TAUGC"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isTripAdvisorReviewsUSCAEnabled = flag;
            if (abTestService.isVariantEnabled("travelShowTravelReviews1507USCA", "UGConly") || abTestService.isVariantEnabled("travelShowTravelReviews1507USCA", "TAUGC"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isUGCReviewsUSCAEnabled = flag;
            if (abTestService.isVariantEnabled("travelShowTravelReviews1507INTL", "TAonly") || abTestService.isVariantEnabled("travelShowTravelReviews1507INTL", "TAUGC"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isTripAdvisorReviewsINTLEnabled = flag;
            if (!abTestService.isVariantEnabled("travelShowTravelReviews1507INTL", "UGConly"))
            {
                flag = flag1;
                if (!abTestService.isVariantEnabled("travelShowTravelReviews1507INTL", "TAUGC"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        isUGCReviewsINTLEnabled = flag;
    }

    public boolean isTravelTripAdvisorReviewsEnabled()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return isTripAdvisorReviewsUSCAEnabled;
        } else
        {
            return isTripAdvisorReviewsINTLEnabled;
        }
    }

    public boolean isTravelUGCReviewsEnabled()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return isUGCReviewsUSCAEnabled;
        } else
        {
            return isUGCReviewsINTLEnabled;
        }
    }
}
