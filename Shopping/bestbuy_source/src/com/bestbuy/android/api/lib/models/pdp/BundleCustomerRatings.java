// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            BundleAverageRating

public class BundleCustomerRatings
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList averageFeatureRating;
    private BundleAverageRating averageRating;
    private ArrayList starRatingBreakdown;
    private int totalCount;

    public BundleCustomerRatings()
    {
    }

    public ArrayList getAverageFeatureRating()
    {
        return averageFeatureRating;
    }

    public BundleAverageRating getAverageRating()
    {
        return averageRating;
    }

    public ArrayList getStarRatingBreakdown()
    {
        return starRatingBreakdown;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setAverageFeatureRating(ArrayList arraylist)
    {
        averageFeatureRating = arraylist;
    }

    public void setAverageRating(BundleAverageRating bundleaveragerating)
    {
        averageRating = bundleaveragerating;
    }

    public void setStarRatingBreakdown(ArrayList arraylist)
    {
        starRatingBreakdown = arraylist;
    }

    public void setTotalCount(int i)
    {
        totalCount = i;
    }
}
