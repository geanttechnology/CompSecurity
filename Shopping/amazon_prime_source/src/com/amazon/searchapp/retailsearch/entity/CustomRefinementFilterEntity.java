// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.CustomRefinementFilter;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class CustomRefinementFilterEntity extends RetailSearchEntity
    implements CustomRefinementFilter
{

    private String detail;
    private String id;
    private String label;
    private int priority;

    public CustomRefinementFilterEntity()
    {
    }

    public String getDetail()
    {
        return detail;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setDetail(String s)
    {
        detail = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setPriority(int i)
    {
        priority = i;
    }
}
