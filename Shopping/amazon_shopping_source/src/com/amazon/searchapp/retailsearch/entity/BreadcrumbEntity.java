// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class BreadcrumbEntity extends RetailSearchEntity
    implements Breadcrumb
{

    private List crumbs;

    public BreadcrumbEntity()
    {
    }

    public List getCrumbs()
    {
        return crumbs;
    }

    public void setCrumbs(List list)
    {
        crumbs = list;
    }
}
