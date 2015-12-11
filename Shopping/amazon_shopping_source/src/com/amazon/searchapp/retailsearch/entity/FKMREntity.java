// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class FKMREntity extends RetailSearchEntity
    implements FKMR
{

    private int index;
    private List keywords;
    private List message;
    private ProductSection results;
    private Link seeAllLink;
    private List styledText;
    private long totalResults;

    public FKMREntity()
    {
    }

    public int getIndex()
    {
        return index;
    }

    public List getKeywords()
    {
        return keywords;
    }

    public List getMessage()
    {
        return message;
    }

    public ProductSection getResults()
    {
        return results;
    }

    public Link getSeeAllLink()
    {
        return seeAllLink;
    }

    public List getStyledText()
    {
        return styledText;
    }

    public long getTotalResults()
    {
        return totalResults;
    }

    public void setIndex(int i)
    {
        index = i;
    }

    public void setKeywords(List list)
    {
        keywords = list;
    }

    public void setMessage(List list)
    {
        message = list;
    }

    public void setResults(ProductSection productsection)
    {
        results = productsection;
    }

    public void setSeeAllLink(Link link)
    {
        seeAllLink = link;
    }

    public void setStyledText(List list)
    {
        styledText = list;
    }

    public void setTotalResults(long l)
    {
        totalResults = l;
    }
}
