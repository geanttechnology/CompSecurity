// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface TrackingInfo
{

    public abstract String getBaseRH();

    public abstract String getBrowseLadder();

    public abstract String getCsrfToken();

    public abstract boolean getIsApplicationFailure();

    public abstract boolean getIsUnsupportedRequest();

    public abstract String getMetaDescription();

    public abstract String getMetaKeywords();

    public abstract String getNode();

    public abstract String getPageApp();

    public abstract String getPageStructure();

    public abstract String getPageTitle();

    public abstract String getPageType();

    public abstract String getQid();

    public abstract String getRedirectUrl();

    public abstract String getRhsSuppressed();

    public abstract String getRid();

    public abstract String getSearchAlias();

    public abstract String getSearchAliasDisplayName();

    public abstract String getSearchKeywords();

    public abstract String getSearchSkeletonKey();

    public abstract String getStore();

    public abstract String getSubPageType();

    public abstract void setBaseRH(String s);

    public abstract void setBrowseLadder(String s);

    public abstract void setCsrfToken(String s);

    public abstract void setIsApplicationFailure(boolean flag);

    public abstract void setIsUnsupportedRequest(boolean flag);

    public abstract void setMetaDescription(String s);

    public abstract void setMetaKeywords(String s);

    public abstract void setNode(String s);

    public abstract void setPageApp(String s);

    public abstract void setPageStructure(String s);

    public abstract void setPageTitle(String s);

    public abstract void setPageType(String s);

    public abstract void setQid(String s);

    public abstract void setRedirectUrl(String s);

    public abstract void setRhsSuppressed(String s);

    public abstract void setRid(String s);

    public abstract void setSearchAlias(String s);

    public abstract void setSearchAliasDisplayName(String s);

    public abstract void setSearchKeywords(String s);

    public abstract void setSearchSkeletonKey(String s);

    public abstract void setStore(String s);

    public abstract void setSubPageType(String s);
}
