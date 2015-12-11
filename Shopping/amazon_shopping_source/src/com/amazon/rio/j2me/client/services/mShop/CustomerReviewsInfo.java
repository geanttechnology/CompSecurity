// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class CustomerReviewsInfo
{

    private int fiveStarCount;
    private int fourStarCount;
    private int oneStarCount;
    private List reviews;
    private String selectedSortType;
    private Integer selectedStarFilter;
    private List sortTypes;
    private int threeStarCount;
    private int twoStarCount;

    public CustomerReviewsInfo()
    {
    }

    public void setFiveStarCount(int i)
    {
        fiveStarCount = i;
    }

    public void setFourStarCount(int i)
    {
        fourStarCount = i;
    }

    public void setOneStarCount(int i)
    {
        oneStarCount = i;
    }

    public void setReviews(List list)
    {
        reviews = list;
    }

    public void setSelectedSortType(String s)
    {
        selectedSortType = s;
    }

    public void setSelectedStarFilter(Integer integer)
    {
        selectedStarFilter = integer;
    }

    public void setSortTypes(List list)
    {
        sortTypes = list;
    }

    public void setThreeStarCount(int i)
    {
        threeStarCount = i;
    }

    public void setTwoStarCount(int i)
    {
        twoStarCount = i;
    }
}
