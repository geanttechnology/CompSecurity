// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.DynamicProductContent;
import com.amazon.searchapp.retailsearch.model.TypedContent;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class DynamicProductContentEntity extends RetailSearchEntity
    implements DynamicProductContent
{

    private TypedContent content;
    private boolean includesImage;
    private String message;

    public DynamicProductContentEntity()
    {
    }

    public TypedContent getContent()
    {
        return content;
    }

    public boolean getIncludesImage()
    {
        return includesImage;
    }

    public String getMessage()
    {
        return message;
    }

    public void setContent(TypedContent typedcontent)
    {
        content = typedcontent;
    }

    public void setIncludesImage(boolean flag)
    {
        includesImage = flag;
    }

    public void setMessage(String s)
    {
        message = s;
    }
}
