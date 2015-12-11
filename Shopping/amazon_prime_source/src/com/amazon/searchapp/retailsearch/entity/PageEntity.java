// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Page;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PageEntity extends RetailSearchEntity
    implements Page
{

    private Link link;
    private int page;
    private String type;

    public PageEntity()
    {
    }

    public Link getLink()
    {
        return link;
    }

    public int getPage()
    {
        return page;
    }

    public String getType()
    {
        return type;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setPage(int i)
    {
        page = i;
    }

    public void setType(String s)
    {
        type = s;
    }
}
