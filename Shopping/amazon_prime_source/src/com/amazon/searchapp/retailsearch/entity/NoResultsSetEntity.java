// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class NoResultsSetEntity extends RetailSearchEntity
    implements NoResultsSet
{

    private List fallbackResults;
    private String label;
    private List styledText;

    public NoResultsSetEntity()
    {
    }

    public List getFallbackResults()
    {
        return fallbackResults;
    }

    public String getLabel()
    {
        return label;
    }

    public List getStyledText()
    {
        return styledText;
    }

    public void setFallbackResults(List list)
    {
        fallbackResults = list;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setStyledText(List list)
    {
        styledText = list;
    }
}
