// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ProductSection;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ProductSectionEntity extends RetailSearchEntity
    implements ProductSection
{

    private List items;
    private int numSections;
    private int page;
    private int section;

    public ProductSectionEntity()
    {
    }

    public List getItems()
    {
        return items;
    }

    public int getNumSections()
    {
        return numSections;
    }

    public int getPage()
    {
        return page;
    }

    public int getSection()
    {
        return section;
    }

    public void setItems(List list)
    {
        items = list;
    }

    public void setNumSections(int i)
    {
        numSections = i;
    }

    public void setPage(int i)
    {
        page = i;
    }

    public void setSection(int i)
    {
        section = i;
    }
}
