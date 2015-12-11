// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;
import java.util.List;

public class Widget
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean addTimer;
    private String analyticsContext;
    private String colorTheme;
    private List offers;
    private int offersWide;
    private String size;
    private String textAlignment;
    private String widgetType;

    public Widget()
    {
    }

    public String getAnalyticsContext()
    {
        return analyticsContext;
    }

    public String getColorTheme()
    {
        return colorTheme;
    }

    public List getOffers()
    {
        return offers;
    }

    public int getOffersWide()
    {
        return offersWide;
    }

    public String getSize()
    {
        return size;
    }

    public String getTextAlignment()
    {
        return textAlignment;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public boolean isAddTimer()
    {
        return addTimer;
    }

    public void setAddTimer(boolean flag)
    {
        addTimer = flag;
    }

    public void setAnalyticsContext(String s)
    {
        analyticsContext = s;
    }

    public void setColorTheme(String s)
    {
        colorTheme = s;
    }

    public void setOffers(List list)
    {
        offers = list;
    }

    public void setOffersWide(int i)
    {
        offersWide = i;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public void setTextAlignment(String s)
    {
        textAlignment = s;
    }

    public void setWidgetType(String s)
    {
        widgetType = s;
    }
}
