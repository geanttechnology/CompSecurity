// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class ImageType
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x381fcb57eaf80e9bL;
    private String altText;
    private float aspectRatio;
    private int height;
    private String path;
    private String url;
    private int width;

    public ImageType()
    {
    }

    public String getAltText()
    {
        return altText;
    }

    public float getAspectRatio()
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

    public void setAspectRatio(float f)
    {
        aspectRatio = f;
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
