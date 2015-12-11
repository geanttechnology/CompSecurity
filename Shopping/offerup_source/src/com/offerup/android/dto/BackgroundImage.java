// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            Image

public class BackgroundImage
{

    Image large;
    Image medium;
    Image small;

    public BackgroundImage()
    {
    }

    public Image getLarge()
    {
        return large;
    }

    public Image getMedium()
    {
        return medium;
    }

    public Image getSmall()
    {
        return small;
    }

    public void setLarge(Image image)
    {
        large = image;
    }

    public void setMedium(Image image)
    {
        medium = image;
    }

    public void setSmall(Image image)
    {
        small = image;
    }
}
