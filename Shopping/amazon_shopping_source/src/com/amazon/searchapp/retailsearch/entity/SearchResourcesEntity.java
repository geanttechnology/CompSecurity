// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.SearchResources;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SearchResourcesEntity extends RetailSearchEntity
    implements SearchResources
{

    private List items;

    public SearchResourcesEntity()
    {
    }

    public List getItems()
    {
        return items;
    }

    public void setItems(List list)
    {
        items = list;
    }
}
