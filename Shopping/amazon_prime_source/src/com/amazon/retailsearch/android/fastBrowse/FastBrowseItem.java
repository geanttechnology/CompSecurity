// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;


public class FastBrowseItem
{

    private String browseUrl;
    private String title;
    private String url;

    public FastBrowseItem(String s, String s1, String s2)
    {
        title = s;
        url = s1;
        browseUrl = s2;
    }

    public String getBrowseUrl()
    {
        return browseUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setBrowseUrl(String s)
    {
        browseUrl = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
