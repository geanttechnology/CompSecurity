// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NonPrimeOffer;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class NonPrimeOfferEntity extends RetailSearchEntity
    implements NonPrimeOffer
{

    private String asin;
    private List label;
    private Link link;

    public NonPrimeOfferEntity()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public List getLabel()
    {
        return label;
    }

    public Link getLink()
    {
        return link;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setLabel(List list)
    {
        label = list;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }
}
