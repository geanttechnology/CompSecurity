// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RankingWidget;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RankingWidgetEntity extends RetailSearchEntity
    implements RankingWidget
{

    private String id;
    private List productGroups;
    private String title;

    public RankingWidgetEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public List getProductGroups()
    {
        return productGroups;
    }

    public String getTitle()
    {
        return title;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setProductGroups(List list)
    {
        productGroups = list;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
