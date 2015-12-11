// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class LinkEntity extends RetailSearchEntity
    implements Link
{

    private String text;
    private String type;
    private String url;

    public LinkEntity()
    {
    }

    public String getText()
    {
        return text;
    }

    public String getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
