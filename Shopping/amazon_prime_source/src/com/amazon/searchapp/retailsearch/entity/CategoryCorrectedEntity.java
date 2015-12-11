// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class CategoryCorrectedEntity extends RetailSearchEntity
    implements CategoryCorrected
{

    private String keywords;
    private ProductSection results;
    private Link seeMoreLink;
    private List styledText;

    public CategoryCorrectedEntity()
    {
    }

    public String getKeywords()
    {
        return keywords;
    }

    public ProductSection getResults()
    {
        return results;
    }

    public Link getSeeMoreLink()
    {
        return seeMoreLink;
    }

    public List getStyledText()
    {
        return styledText;
    }

    public void setKeywords(String s)
    {
        keywords = s;
    }

    public void setResults(ProductSection productsection)
    {
        results = productsection;
    }

    public void setSeeMoreLink(Link link)
    {
        seeMoreLink = link;
    }

    public void setStyledText(List list)
    {
        styledText = list;
    }
}
