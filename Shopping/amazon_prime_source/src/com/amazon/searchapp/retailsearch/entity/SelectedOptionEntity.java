// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.SelectedOption;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class SelectedOptionEntity extends RetailSearchEntity
    implements SelectedOption
{

    private String id;
    private Link link;
    private boolean selected;

    public SelectedOptionEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public Link getLink()
    {
        return link;
    }

    public boolean getSelected()
    {
        return selected;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }
}
