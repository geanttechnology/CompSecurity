// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;

import gu;
import java.io.Serializable;
import java.util.List;

public class ConditionalFeature
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List columns;
    private String description;
    private String title;

    public ConditionalFeature()
    {
    }

    public List getColumns()
    {
        return columns;
    }

    public String getDescription()
    {
        return description;
    }

    public String getTitle()
    {
        return title;
    }

    public void setColumns(List list)
    {
        columns = list;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
