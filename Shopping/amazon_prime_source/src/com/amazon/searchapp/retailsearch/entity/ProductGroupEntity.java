// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.ProductGroup;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ProductGroupEntity extends RetailSearchEntity
    implements ProductGroup
{

    private boolean defaultGroup;
    private Link detailLink;
    private String name;
    private List products;
    private String type;

    public ProductGroupEntity()
    {
    }

    public boolean getDefaultGroup()
    {
        return defaultGroup;
    }

    public Link getDetailLink()
    {
        return detailLink;
    }

    public String getName()
    {
        return name;
    }

    public List getProducts()
    {
        return products;
    }

    public String getType()
    {
        return type;
    }

    public void setDefaultGroup(boolean flag)
    {
        defaultGroup = flag;
    }

    public void setDetailLink(Link link)
    {
        detailLink = link;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setProducts(List list)
    {
        products = list;
    }

    public void setType(String s)
    {
        type = s;
    }
}
