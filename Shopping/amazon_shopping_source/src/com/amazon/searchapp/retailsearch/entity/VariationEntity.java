// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Variation;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class VariationEntity extends RetailSearchEntity
    implements Variation
{

    private Link link;
    private String type;

    public VariationEntity()
    {
    }

    public Link getLink()
    {
        return link;
    }

    public String getType()
    {
        return type;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setType(String s)
    {
        type = s;
    }
}
