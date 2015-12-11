// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class ClientLogInfo
{

    private List features;
    private String pageAssemblyType;
    private String pageType;
    private String relatedRequestId;
    private String sessionId;

    public ClientLogInfo()
    {
    }

    public List getFeatures()
    {
        return features;
    }

    public String getPageAssemblyType()
    {
        return pageAssemblyType;
    }

    public String getPageType()
    {
        return pageType;
    }

    public String getRelatedRequestId()
    {
        return relatedRequestId;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public void setFeatures(List list)
    {
        features = list;
    }

    public void setPageAssemblyType(String s)
    {
        pageAssemblyType = s;
    }

    public void setPageType(String s)
    {
        pageType = s;
    }

    public void setRelatedRequestId(String s)
    {
        relatedRequestId = s;
    }
}
