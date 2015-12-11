// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class CategoryResult
{

    private String category;
    private String displayName;
    private String parent;
    private int resultCount;

    public CategoryResult()
    {
    }

    public String getCategory()
    {
        return category;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setParent(String s)
    {
        parent = s;
    }

    public void setResultCount(int i)
    {
        resultCount = i;
    }
}
