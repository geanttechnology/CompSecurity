// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SpellCorrectedEntity extends RetailSearchEntity
    implements SpellCorrected
{

    private String correctedKeywords;
    private List detailedStyledText;
    private ProductSection results;
    private Link seeMoreLink;
    private List styledText;

    public SpellCorrectedEntity()
    {
    }

    public String getCorrectedKeywords()
    {
        return correctedKeywords;
    }

    public List getDetailedStyledText()
    {
        return detailedStyledText;
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

    public void setCorrectedKeywords(String s)
    {
        correctedKeywords = s;
    }

    public void setDetailedStyledText(List list)
    {
        detailedStyledText = list;
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
