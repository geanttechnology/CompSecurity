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

    public abstract String getNode();

    public abstract String getPageApp();

    public abstract String getPageStructure();

    public abstract String getPageType();

    public abstract String getQid();

    public abstract String getRedirectUrl();

    public abstract String getRid();

    public abstract String getSearchAlias();

    public abstract String getSearchAliasDisplayName();

    public abstract String getSearchKeywords();

    public abstract String getSearchSkeletonKey();

    public abstract String getStore();

    public abstract String getSubPageType();
}
