// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class OfferImage
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xe4d871918a525d9fL;
    private String altText;
    private double aspectRatio;
    private long height;
    private String path;
    private String url;
    private long width;

    public OfferImage()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public double getAspectRatio()
    {
        return aspectRatio;
    }

    public long getHeight()
    {
        return height;
    }

    public String getPath()
    {
        return path;
    }

    public String getUrl()
    {
        return url;
    }

    public long getWidth()
    {
        return width;
    }

    public void setAltText(String s)
    {
        altText = s;
    }

    public void setAspectRatio(double d)
    {
        aspectRatio = d;
    }

    public void setHeight(long l)
    {
        height = l;
    }

    public void setPath(String s)
    {
        path = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setWidth(long l)
    {
        width = l;
    }
}
