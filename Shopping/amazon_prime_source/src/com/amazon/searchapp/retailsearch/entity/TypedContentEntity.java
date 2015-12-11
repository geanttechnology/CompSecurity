// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.TypedContent;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class TypedContentEntity extends RetailSearchEntity
    implements TypedContent
{

    private String content;
    private String type;

    public TypedContentEntity()
    {
    }

    public String getContent()
    {
        return content;
    }

    public String getType()
    {
        return type;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
