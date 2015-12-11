// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class RecommendedItemsRequest
{

    private String category;
    private String context;
    private int count;
    private int maxImageDimension;
    private int startOffset;

    public RecommendedItemsRequest()
    {
    }

    public String getCategory()
    {
        return category;
    }

    public String getContext()
    {
        return context;
    }

    public int getCount()
    {
        return count;
    }

    public int getMaxImageDimension()
    {
        return maxImageDimension;
    }

    public int getStartOffset()
    {
        return startOffset;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setMaxImageDimension(int i)
    {
        maxImageDimension = i;
    }

    public void setStartOffset(int i)
    {
        startOffset = i;
    }
}
