// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.DynamicContent;
import com.amazon.searchapp.retailsearch.model.TypedContent;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DynamicContentEntity extends RetailSearchEntity
    implements DynamicContent
{

    private TypedContent content;
    private int position;
    private int priority;

    public DynamicContentEntity()
    {
    }

    public TypedContent getContent()
    {
        return content;
    }

    public int getPosition()
    {
        return position;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setContent(TypedContent typedcontent)
    {
        content = typedcontent;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setPriority(int i)
    {
        priority = i;
    }
}
