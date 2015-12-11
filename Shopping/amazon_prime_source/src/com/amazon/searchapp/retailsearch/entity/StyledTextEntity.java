// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.StyledText;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class StyledTextEntity extends RetailSearchEntity
    implements StyledText
{

    private String style;
    private String text;
    private String url;

    public StyledTextEntity()
    {
    }

    public String getStyle()
    {
        return style;
    }

    public String getText()
    {
        return text;
    }

    public String getUrl()
    {
        return url;
    }

    public void setStyle(String s)
    {
        style = s;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
