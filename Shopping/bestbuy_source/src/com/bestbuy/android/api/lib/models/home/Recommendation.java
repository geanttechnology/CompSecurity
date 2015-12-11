// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class Recommendation
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x6578cae1d418716aL;
    private String recommendationsCount;
    private String recommendationsId;
    private String recommendationsType;
    private String size;
    private String url;
    private String widgetType;

    public Recommendation()
    {
    }

    public String getRecommendationsCount()
    {
        return recommendationsCount;
    }

    public String getRecommendationsId()
    {
        return recommendationsId;
    }

    public String getRecommendationsType()
    {
        return recommendationsType;
    }

    public String getSize()
    {
        return size;
    }

    public String getUrl()
    {
        return url;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public void setRecommendationsCount(String s)
    {
        recommendationsCount = s;
    }

    public void setRecommendationsId(String s)
    {
        recommendationsId = s;
    }

    public void setRecommendationsType(String s)
    {
        recommendationsType = s;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidgetType(String s)
    {
        widgetType = s;
    }
}
