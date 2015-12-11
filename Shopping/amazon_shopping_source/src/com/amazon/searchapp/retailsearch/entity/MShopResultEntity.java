// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.MShopResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class MShopResultEntity extends RetailSearchEntity
    implements MShopResult
{

    private String browserUrl;
    private String notice;
    private boolean showResultSummary;
    private String viewType;
    private String webViewUrl;

    public MShopResultEntity()
    {
    }

    public String getBrowserUrl()
    {
        return browserUrl;
    }

    public String getNotice()
    {
        return notice;
    }

    public boolean getShowResultSummary()
    {
        return showResultSummary;
    }

    public String getViewType()
    {
        return viewType;
    }

    public String getWebViewUrl()
    {
        return webViewUrl;
    }

    public void setBrowserUrl(String s)
    {
        browserUrl = s;
    }

    public void setNotice(String s)
    {
        notice = s;
    }

    public void setShowResultSummary(boolean flag)
    {
        showResultSummary = flag;
    }

    public void setViewType(String s)
    {
        viewType = s;
    }

    public void setWebViewUrl(String s)
    {
        webViewUrl = s;
    }
}
