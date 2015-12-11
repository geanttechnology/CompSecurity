// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.RgbaColor;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RgbaColorEntity extends RetailSearchEntity
    implements RgbaColor
{

    private float alpha;
    private int blue;
    private int green;
    private int red;

    public RgbaColorEntity()
    {
    }

    public float getAlpha()
    {
        return alpha;
    }

    public int getBlue()
    {
        return blue;
    }

    public int getGreen()
    {
        return green;
    }

    public int getRed()
    {
        return red;
    }

    public void setAlpha(float f)
    {
        alpha = f;
    }

    public void setBlue(int i)
    {
        blue = i;
    }

    public void setGreen(int i)
    {
        green = i;
    }

    public void setRed(int i)
    {
        red = i;
    }
}
