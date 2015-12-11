// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PastPurchases;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PastPurchasesEntity extends RetailSearchEntity
    implements PastPurchases
{

    private List header;
    private String id;
    private List products;
    private List seeAllLinks;

    public PastPurchasesEntity()
    {
    }

    public List getHeader()
    {
        return header;
    }

    public String getId()
    {
        return id;
    }

    public List getProducts()
    {
        return products;
    }

    public List getSeeAllLinks()
    {
        return seeAllLinks;
    }

    public void setHeader(List list)
    {
        header = list;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setProducts(List list)
    {
        products = list;
    }

    public void setSeeAllLinks(List list)
    {
        seeAllLinks = list;
    }
}
