// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Sort;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SortEntity extends RetailSearchEntity
    implements Sort
{

    private List options;

    public SortEntity()
    {
    }

    public List getOptions()
    {
        return options;
    }

    public void setOptions(List list)
    {
        options = list;
    }
}
