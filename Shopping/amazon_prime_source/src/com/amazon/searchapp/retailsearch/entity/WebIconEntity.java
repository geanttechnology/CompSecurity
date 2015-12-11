// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.WebIcon;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class WebIconEntity extends RetailSearchEntity
    implements WebIcon
{

    private String altText;
    private int height;
    private String url;
    private int width;

    public WebIconEntity()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public int getHeight()
    {
        return height;
    }

    public String getUrl()
    {
        return url;
    }

    public int getWidth()
    {
        return width;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidth(int i)
    {
        width = i;
    }
}
