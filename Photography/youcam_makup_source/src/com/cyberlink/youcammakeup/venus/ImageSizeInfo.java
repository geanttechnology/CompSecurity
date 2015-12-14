// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;


public class ImageSizeInfo
{

    public int height;
    public int stride;
    public int width;
    public float x;
    public float y;

    public ImageSizeInfo()
    {
        width = -1;
        height = -1;
        stride = -1;
        x = 1.0F;
        y = 1.0F;
    }

    public boolean IsNotScale()
    {
        return x == 1.0F && y == 1.0F;
    }
}
