// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RelatedSearchesEntity extends RetailSearchEntity
    implements RelatedSearches
{

    private List altQueries;
    private String label;
    private boolean secondaryResult;

    public RelatedSearchesEntity()
    {
    }

    public List getAltQueries()
    {
        return altQueries;
    }

    public String getLabel()
    {
        return label;
    }

    public boolean getSecondaryResult()
    {
        return secondaryResult;
    }

    public void setAltQueries(List list)
    {
        altQueries = list;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setSecondaryResult(boolean flag)
    {
        secondaryResult = flag;
    }
}
