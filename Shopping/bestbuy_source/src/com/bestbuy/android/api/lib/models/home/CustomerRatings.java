// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            AverageRating, AverageWouldRecommend

public class CustomerRatings
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x7882004daefe966aL;
    private AverageRating averageRating;
    private AverageWouldRecommend averageWouldRecommend;
    private String mdotUrl;
    private List starRatingBreakdown;
    private int totalCount;

    public CustomerRatings()
    {
    }

    public AverageRating getAverageRating()
    {
        return averageRating;
    }

    public AverageWouldRecommend getAverageWouldRecommend()
    {
        return averageWouldRecommend;
    }

    public String getMdotUrl()
    {
        return mdotUrl;
    }

    public List getStarRatingBreakdown()
    {
        return starRatingBreakdown;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setAverageRating(AverageRating averagerating)
    {
        averageRating = averagerating;
    }

    public void setAverageWouldRecommend(AverageWouldRecommend averagewouldrecommend)
    {
        averageWouldRecommend = averagewouldrecommend;
    }

    public void setMdotUrl(String s)
    {
        mdotUrl = s;
    }

    public void setStarRatingBreakdown(List list)
    {
        starRatingBreakdown = list;
    }

    public void setTotalCount(int i)
    {
        totalCount = i;
    }
}
