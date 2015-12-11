// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.browse;

import java.io.Serializable;

public class UberCategory
    implements Serializable
{

    private String categoryId;
    private String categoryName;
    private String categoryValue;

    public UberCategory()
    {
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public String getCategoryValue()
    {
        return categoryValue;
    }

    public void setCategoryId(String s)
    {
        categoryId = s;
    }

    public void setCategoryName(String s)
    {
        categoryName = s;
    }

    public void setCategoryValue(String s)
    {
        categoryValue = s;
    }
}
