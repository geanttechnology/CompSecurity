// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Refinements;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RefinementsEntity extends RetailSearchEntity
    implements Refinements
{

    private Link clearAllLink;
    private List customFilters;
    private Department departments;
    private List filters;
    private List prioritizedFilterIds;

    public RefinementsEntity()
    {
    }

    public Link getClearAllLink()
    {
        return clearAllLink;
    }

    public List getCustomFilters()
    {
        return customFilters;
    }

    public Department getDepartments()
    {
        return departments;
    }

    public List getFilters()
    {
        return filters;
    }

    public List getPrioritizedFilterIds()
    {
        return prioritizedFilterIds;
    }

    public void setClearAllLink(Link link)
    {
        clearAllLink = link;
    }

    public void setCustomFilters(List list)
    {
        customFilters = list;
    }

    public void setDepartments(Department department)
    {
        departments = department;
    }

    public void setFilters(List list)
    {
        filters = list;
    }

    public void setPrioritizedFilterIds(List list)
    {
        prioritizedFilterIds = list;
    }
}
