// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            AverageRating

public class CustomerRatings
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList averageFeatureRating;
    private AverageRating averageRating;
    private String mdotUrl;
    private ArrayList starRatingBreakdown;
    private int totalCount;

    public CustomerRatings()
    {
    }

    public ArrayList getAverageFeatureRating()
    {
        return averageFeatureRating;
    }

    public AverageRating getAverageRating()
    {
        return averageRating;
    }

    public String getMdotUrl()
    {
        return mdotUrl;
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

    public void setAverageRating(AverageRating averagerating)
    {
        averageRating = averagerating;
    }

    public void setMdotUrl(String s)
    {
        mdotUrl = s;
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
