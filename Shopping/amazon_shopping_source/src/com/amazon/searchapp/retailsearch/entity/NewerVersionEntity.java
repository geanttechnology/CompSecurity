// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NewerVersion;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class NewerVersionEntity extends RetailSearchEntity
    implements NewerVersion
{

    private String asin;
    private Link link;

    public NewerVersionEntity()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public Link getLink()
    {
        return link;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }
}
