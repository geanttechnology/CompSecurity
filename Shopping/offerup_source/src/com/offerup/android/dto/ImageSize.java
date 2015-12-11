// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class ImageSize
{

    int height;
    int width;

    public ImageSize()
    {
    }

    public static ImageSize getScaledBasedOnFixedWidth(int i, int j, int k)
    {
        ImageSize imagesize = new ImageSize();
        imagesize.setWidth(i);
        imagesize.setHeight((int)(((double)i * (double)k) / (double)j));
        return imagesize;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setWidth(int i)
    {
        width = i;
    }
}
