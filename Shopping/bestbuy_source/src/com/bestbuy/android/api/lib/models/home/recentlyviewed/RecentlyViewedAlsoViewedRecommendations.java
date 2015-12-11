// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import gu;
import java.io.Serializable;
import java.util.List;

public class RecentlyViewedAlsoViewedRecommendations
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xdaa66787161ed2caL;
    private List skus;
    private String type;

    public RecentlyViewedAlsoViewedRecommendations()
    {
    }

    public List getSkus()
    {
        return skus;
    }

    public String getType()
    {
        return type;
    }

    public void setSkus(List list)
    {
        skus = list;
    }

    public void setType(String s)
    {
        type = s;
    }
}
