// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


public interface MShopResult
{

    public abstract String getBrowserUrl();

    public abstract String getNotice();

    public abstract boolean getShowResultSummary();

    public abstract String getViewType();

    public abstract String getWebViewUrl();

    public abstract void setBrowserUrl(String s);

    public abstract void setNotice(String s);

    public abstract void setShowResultSummary(boolean flag);

    public abstract void setViewType(String s);

    public abstract void setWebViewUrl(String s);
}
