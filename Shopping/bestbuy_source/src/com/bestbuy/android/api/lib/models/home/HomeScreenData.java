// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;
import java.util.List;

public class HomeScreenData
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xe8de90bb48c2894aL;
    private List dealsOfTheDay;
    private List primaryMessages;
    private List recommendations;

    public HomeScreenData()
    {
    }

    public List getDealsOfTheDay()
    {
        return dealsOfTheDay;
    }

    public List getPrimaryMessages()
    {
        return primaryMessages;
    }

    public List getRecommendations()
    {
        return recommendations;
    }

    public void setDealsOfTheDay(List list)
    {
        dealsOfTheDay = list;
    }

    public void setPrimaryMessages(List list)
    {
        primaryMessages = list;
    }

    public void setRecommendations(List list)
    {
        recommendations = list;
    }
}
