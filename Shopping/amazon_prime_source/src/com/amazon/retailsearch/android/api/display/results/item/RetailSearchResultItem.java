// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results.item;

import android.text.TextUtils;

public class RetailSearchResultItem
{
    public static class Builder
    {

        public RetailSearchResultItem build(String s, String s1, String s2)
        {
            return build(s, s1, s2, null);
        }

        public RetailSearchResultItem build(String s, String s1, String s2, String s3)
        {
            RetailSearchResultItem retailsearchresultitem = new RetailSearchResultItem();
            retailsearchresultitem.setAsin(s);
            if (!TextUtils.isEmpty(s1))
            {
                retailsearchresultitem.setDetailPageUrlPath(s1.replaceFirst(".*?/dp/", ""));
            }
            retailsearchresultitem.setProductGroup(s2);
            retailsearchresultitem.setEditionsType(s3);
            return retailsearchresultitem;
        }

        public Builder()
        {
        }
    }


    private String asin;
    private String detailPageUrlPath;
    private String editionsType;
    private String productGroup;

    public RetailSearchResultItem()
    {
    }

    private void setAsin(String s)
    {
        asin = s;
    }

    private void setDetailPageUrlPath(String s)
    {
        detailPageUrlPath = s;
    }

    private void setEditionsType(String s)
    {
        editionsType = s;
    }

    private void setProductGroup(String s)
    {
        productGroup = s;
    }

    public String getAsin()
    {
        return asin;
    }

    public String getDetailPageUrlPath()
    {
        return detailPageUrlPath;
    }

    public String getEditionsType()
    {
        return editionsType;
    }

    public String getProductGroup()
    {
        return productGroup;
    }




}
