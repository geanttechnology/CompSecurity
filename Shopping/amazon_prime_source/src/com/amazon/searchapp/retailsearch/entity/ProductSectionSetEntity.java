// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ProductSectionSet;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ProductSectionSetEntity extends RetailSearchEntity
    implements ProductSectionSet
{

    private List sections;

    public ProductSectionSetEntity()
    {
    }

    public List getSections()
    {
        return sections;
    }

    public void setSections(List list)
    {
        sections = list;
    }
}
