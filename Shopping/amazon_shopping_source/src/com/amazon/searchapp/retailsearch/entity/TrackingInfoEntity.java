// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class TrackingInfoEntity extends RetailSearchEntity
    implements TrackingInfo
{

    private String baseRH;
    private String browseLadder;
    private String csrfToken;
    private boolean isApplicationFailure;
    private boolean isUnsupportedRequest;
    private String node;
    private String pageApp;
    private String pageStructure;
    private String pageType;
    private String qid;
    private String redirectUrl;
    private String rid;
    private String searchAlias;
    private String searchAliasDisplayName;
    private String searchKeywords;
    private String searchSkeletonKey;
    private String store;
    private String subPageType;

    public TrackingInfoEntity()
    {
    }

    public String getBaseRH()
    {
        return baseRH;
    }

    public String getBrowseLadder()
    {
        return browseLadder;
    }

    public String getCsrfToken()
    {
        return csrfToken;
    }

    public boolean getIsApplicationFailure()
    {
        return isApplicationFailure;
    }

    public boolean getIsUnsupportedRequest()
    {
        return isUnsupportedRequest;
    }

    public String getNode()
    {
        return node;
    }

    public String getPageApp()
    {
        return pageApp;
    }

    public String getPageStructure()
    {
        return pageStructure;
    }

    public String getPageType()
    {
        return pageType;
    }

    public String getQid()
    {
        return qid;
    }

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public String getRid()
    {
        return rid;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public String getSearchAliasDisplayName()
    {
        return searchAliasDisplayName;
    }

    public String getSearchKeywords()
    {
        return searchKeywords;
    }

    public String getSearchSkeletonKey()
    {
        return searchSkeletonKey;
    }

    public String getStore()
    {
        return store;
    }

    public String getSubPageType()
    {
        return subPageType;
    }

    public void setBaseRH(String s)
    {
        baseRH = s;
    }

    public void setBrowseLadder(String s)
    {
        browseLadder = s;
    }

    public void setCsrfToken(String s)
    {
        csrfToken = s;
    }

    public void setIsApplicationFailure(boolean flag)
    {
        isApplicationFailure = flag;
    }

    public void setIsUnsupportedRequest(boolean flag)
    {
        isUnsupportedRequest = flag;
    }

    public void setNode(String s)
    {
        node = s;
    }

    public void setPageApp(String s)
    {
        pageApp = s;
    }

    public void setPageStructure(String s)
    {
        pageStructure = s;
    }

    public void setPageType(String s)
    {
        pageType = s;
    }

    public void setQid(String s)
    {
        qid = s;
    }

    public void setRedirectUrl(String s)
    {
        redirectUrl = s;
    }

    public void setRid(String s)
    {
        rid = s;
    }

    public void setSearchAlias(String s)
    {
        searchAlias = s;
    }

    public void setSearchAliasDisplayName(String s)
    {
        searchAliasDisplayName = s;
    }

    public void setSearchKeywords(String s)
    {
        searchKeywords = s;
    }

    public void setSearchSkeletonKey(String s)
    {
        searchSkeletonKey = s;
    }

    public void setStore(String s)
    {
        store = s;
    }

    public void setSubPageType(String s)
    {
        subPageType = s;
    }
}
