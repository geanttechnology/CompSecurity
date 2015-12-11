// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import java.io.Serializable;

public class CategoryFacet
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String categoryName;
    private String categoryPath;

    public CategoryFacet()
    {
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public String getCategoryPath()
    {
        return categoryPath;
    }

    public void setCategoryName(String s)
    {
        categoryName = s;
    }

    public void setCategoryPath(String s)
    {
        categoryPath = s;
    }
}
