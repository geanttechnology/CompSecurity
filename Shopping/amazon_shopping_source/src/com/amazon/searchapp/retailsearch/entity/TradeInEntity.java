// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.TradeIn;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class TradeInEntity extends RetailSearchEntity
    implements TradeIn
{

    private Link link;
    private String price;
    private Link resultLink;

    public TradeInEntity()
    {
    }

    public Link getLink()
    {
        return link;
    }

    public String getPrice()
    {
        return price;
    }

    public Link getResultLink()
    {
        return resultLink;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setResultLink(Link link1)
    {
        resultLink = link1;
    }
}
