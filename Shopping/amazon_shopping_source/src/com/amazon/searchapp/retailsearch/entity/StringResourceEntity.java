// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.StringResource;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class StringResourceEntity extends RetailSearchEntity
    implements StringResource
{

    private String id;
    private String text;

    public StringResourceEntity()
    {
    }

    public String getId()
    {
        return id;
    }

    public String getText()
    {
        return text;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setText(String s)
    {
        text = s;
    }
}
