// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DepartmentEntity extends RetailSearchEntity
    implements Department
{

    private RefinementLink allLink;
    private List ancestry;
    private List categories;

    public DepartmentEntity()
    {
    }

    public RefinementLink getAllLink()
    {
        return allLink;
    }

    public List getAncestry()
    {
        return ancestry;
    }

    public List getCategories()
    {
        return categories;
    }

    public void setAllLink(RefinementLink refinementlink)
    {
        allLink = refinementlink;
    }

    public void setAncestry(List list)
    {
        ancestry = list;
    }

    public void setCategories(List list)
    {
        categories = list;
    }
}
