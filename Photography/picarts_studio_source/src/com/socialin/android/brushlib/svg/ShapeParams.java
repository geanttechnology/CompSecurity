// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.graphics.Color;
import android.graphics.Xfermode;
import com.socialin.android.NoProGuard;
import java.io.Serializable;

public class ShapeParams
    implements NoProGuard, Serializable
{

    private static final long serialVersionUID = 0xbe1f367414da27e1L;
    private int color;
    private boolean isStroke;
    private com.socialin.android.brushlib.view.DrawingView.DrawingMode mode;
    private float size;

    public ShapeParams(ShapeParams shapeparams)
    {
        this(shapeparams.isStroke, shapeparams.size, shapeparams.color, shapeparams.mode);
    }

    public ShapeParams(boolean flag, float f, int i, com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        isStroke = flag;
        size = f;
        color = i;
        mode = drawingmode;
    }

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

    public boolean isStroke()
    {
        return isStroke;
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

    public void setMode(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        mode = drawingmode;
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

    public void setStroke(boolean flag)
    {
        isStroke = flag;
    }

    public String toString()
    {
        return (new StringBuilder("isStroke : ")).append(isStroke).append(", opacity : ").append(Integer.toHexString(getOpacity())).append(", color : ").append(Integer.toHexString(getColor())).append(", size : ").append(size).toString();
    }
}
