// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Color;
import android.graphics.Xfermode;
import java.io.Serializable;

public class mode
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int color;
    private com.socialin.android.brushlib.view.Mode mode;
    private float size;

    public int getColor()
    {
        return color;
    }

    public int getOpacity()
    {
        return Color.alpha(color);
    }

    public float getSize()
    {
        return size;
    }

    public Xfermode getXfermode()
    {
        if (mode == null)
        {
            return null;
        } else
        {
            return mode.xfermode;
        }
    }

    public void setColor(int i)
    {
        color = i;
    }

    public void setColorRGB(int i)
    {
        int j = getOpacity();
        color = i;
        color = color & 0xffffff;
        color = j << 24 | color;
    }

    public void setMode(com.socialin.android.brushlib.view.Mode mode1)
    {
        mode = mode1;
    }

    public void setOpacity(int i)
    {
        color = color & 0xffffff;
        color = color | i << 24;
    }

    public void setSize(float f)
    {
        size = f;
    }

    public String toString()
    {
        return (new StringBuilder("opacity : 0x")).append(Integer.toHexString(getOpacity())).append(", color : 0x").append(Integer.toHexString(getColor())).append(", size : ").append(size).toString();
    }

    public e(float f, int i, com.socialin.android.brushlib.view.Mode mode1)
    {
        size = f;
        color = i;
        mode = mode1;
    }

    public e(mode mode1)
    {
        this(mode1.size, mode1.color, mode1.mode);
    }
}
