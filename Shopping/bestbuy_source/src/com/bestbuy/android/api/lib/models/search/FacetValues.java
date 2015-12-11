// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;

public class FacetValues
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String categoryPath;
    private int count;
    private String value;

    public FacetValues()
    {
    }

    public String getCategoryPath()
    {
        return categoryPath;
    }

    public int getCount()
    {
        return count;
    }

    public String getValue()
    {
        return value;
    }

    public void setCategoryPath(String s)
    {
        categoryPath = s;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
