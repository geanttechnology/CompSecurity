// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;
import java.util.List;

public class PageConfiguation
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String analyticsPageType;
    private String krakenNodeConfigVersion;
    private String layoutName;
    private String pageTitle;
    private boolean rowContainer;
    private String shortName;
    private List widgets;

    public PageConfiguation()
    {
    }

    public String getAnalyticsPageType()
    {
        return analyticsPageType;
    }

    public String getKrakenNodeConfigVersion()
    {
        return krakenNodeConfigVersion;
    }

    public String getLayoutName()
    {
        return layoutName;
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public String getShortName()
    {
        return shortName;
    }

    public List getWidgets()
    {
        return widgets;
    }

    public boolean isRowContainer()
    {
        return rowContainer;
    }

    public void setAnalyticsPageType(String s)
    {
        analyticsPageType = s;
    }

    public void setKrakenNodeConfigVersion(String s)
    {
        krakenNodeConfigVersion = s;
    }

    public void setLayoutName(String s)
    {
        layoutName = s;
    }

    public void setPageTitle(String s)
    {
        pageTitle = s;
    }

    public void setRowContainer(boolean flag)
    {
        rowContainer = flag;
    }

    public void setShortName(String s)
    {
        shortName = s;
    }

    public void setWidgets(List list)
    {
        widgets = list;
    }
}
