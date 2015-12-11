// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;


public class PathPoint
{

    public static final int CURVE = 2;
    public static final int LINE = 1;
    public static final int MOVE = 0;
    float mControl0X;
    float mControl0Y;
    float mControl1X;
    float mControl1Y;
    int mOperation;
    float mX;
    float mY;

    private PathPoint(float f, float f1, float f2, float f3, float f4, float f5)
    {
        mControl0X = f;
        mControl0Y = f1;
        mControl1X = f2;
        mControl1Y = f3;
        mX = f4;
        mY = f5;
        mOperation = 2;
    }

    private PathPoint(int i, float f, float f1)
    {
        mOperation = i;
        mX = f;
        mY = f1;
    }

    public static PathPoint curveTo(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return new PathPoint(f, f1, f2, f3, f4, f5);
    }

    public static PathPoint lineTo(float f, float f1)
    {
        return new PathPoint(1, f, f1);
    }

    public static PathPoint moveTo(float f, float f1)
    {
        return new PathPoint(0, f, f1);
    }

    public float getX()
    {
        return mX;
    }

    public float getY()
    {
        return mY;
    }

    public void setX(float f)
    {
        mX = f;
    }

    public void setY(float f)
    {
        mY = f;
    }
}
