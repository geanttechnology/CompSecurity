// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class MediaImage
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String altText;
    private double aspectRatio;
    private int height;
    private String path;
    private String url;
    private int width;

    public MediaImage()
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

    public int getHeight()
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

    public int getWidth()
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

    public void setHeight(int i)
    {
        height = i;
    }

    public void setPath(String s)
    {
        path = s;
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
