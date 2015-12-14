// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import java.io.Serializable;

public class GradientBean
    implements Serializable
{

    public int colors[];
    public float gradientTransformMatrix[];
    public int gradientType;
    public float positions[];
    public float r;
    public android.graphics.Shader.TileMode tile;
    public float x;
    public float x1;
    public float y;
    public float y1;

    public GradientBean(float f, float f1, float f2, float f3, float f4, int ai[], float af[], 
            int i)
    {
        tile = android.graphics.Shader.TileMode.CLAMP;
        x = f;
        y = f1;
        x1 = f2;
        y1 = f3;
        r = f4;
        colors = ai;
        positions = af;
        gradientType = i;
    }

    public int[] getColors()
    {
        return colors;
    }

    public float[] getGradientTransformMatrix()
    {
        return gradientTransformMatrix;
    }

    public float[] getPositions()
    {
        return positions;
    }

    public float getR()
    {
        return r;
    }

    public android.graphics.Shader.TileMode getTile()
    {
        return tile;
    }

    public float getX()
    {
        return x;
    }

    public float getX1()
    {
        return x1;
    }

    public float getY()
    {
        return y;
    }

    public float getY1()
    {
        return y1;
    }

    public void setColors(int ai[])
    {
        colors = ai;
    }

    public void setGradientTransformMatrix(float af[])
    {
        gradientTransformMatrix = af;
    }

    public void setPositions(float af[])
    {
        positions = af;
    }

    public void setR(float f)
    {
        r = f;
    }

    public void setTile(android.graphics.Shader.TileMode tilemode)
    {
        tile = tilemode;
    }

    public void setX(float f)
    {
        x = f;
    }

    public void setX1(float f)
    {
        x1 = f;
    }

    public void setY(float f)
    {
        y = f;
    }

    public void setY1(float f)
    {
        y1 = f;
    }
}
