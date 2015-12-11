// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.ResultsMetadata;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ResultsMetadataEntity extends RetailSearchEntity
    implements ResultsMetadata
{

    private long firstItem;
    private long itemCount;
    private String resultsLabel;
    private long totalResults;

    public ResultsMetadataEntity()
    {
    }

    public long getFirstItem()
    {
        return firstItem;
    }

    public long getItemCount()
    {
        return itemCount;
    }

    public String getResultsLabel()
    {
        return resultsLabel;
    }

    public long getTotalResults()
    {
        return totalResults;
    }

    public void setFirstItem(long l)
    {
        firstItem = l;
    }

    public void setItemCount(long l)
    {
        itemCount = l;
    }

    public void setResultsLabel(String s)
    {
        resultsLabel = s;
    }

    public void setTotalResults(long l)
    {
        totalResults = l;
    }
}
