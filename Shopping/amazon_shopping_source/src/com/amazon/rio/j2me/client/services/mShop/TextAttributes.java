// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class TextAttributes
{

    private Boolean allowTruncation;
    private Integer color;
    private String linkUrl;
    private Integer size;
    private Integer style;

    public TextAttributes()
    {
    }

    public Boolean getAllowTruncation()
    {
        return allowTruncation;
    }

    public Integer getColor()
    {
        return color;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }

    public Integer getSize()
    {
        return size;
    }

    public Integer getStyle()
    {
        return style;
    }

    public void setAllowTruncation(Boolean boolean1)
    {
        allowTruncation = boolean1;
    }

    public void setColor(Integer integer)
    {
        color = integer;
    }

    public void setLinkUrl(String s)
    {
        linkUrl = s;
    }

    public void setSize(Integer integer)
    {
        size = integer;
    }

    public void setStyle(Integer integer)
    {
        style = integer;
    }
}
