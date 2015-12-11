// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.browse;

import gu;
import java.io.Serializable;
import java.util.List;

public class Category
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String categoryId;
    private String displayOnly;
    private List groups;
    private String name;
    private String searchPath;
    private String widgetType;

    public Category()
    {
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getDisplayOnly()
    {
        return displayOnly;
    }

    public List getGroups()
    {
        return groups;
    }

    public String getName()
    {
        return name;
    }

    public String getSearchPath()
    {
        return searchPath;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public void setCategoryId(String s)
    {
        categoryId = s;
    }

    public void setDisplayOnly(String s)
    {
        displayOnly = s;
    }

    public void setGroups(List list)
    {
        groups = list;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setSearchPath(String s)
    {
        searchPath = s;
    }

    public void setWidgetType(String s)
    {
        widgetType = s;
    }
}
