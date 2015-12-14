// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush.math;

import android.graphics.PointF;
import java.io.Serializable;

public final class BezierSplineSegment
    implements Serializable
{

    private static final float PRECISION = 0.1F;
    private static final long serialVersionUID = 0x5d09756de54ade89L;
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float uGuess;

    public BezierSplineSegment()
    {
        a = 0.0F;
        b = 0.0F;
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
    }

    public BezierSplineSegment(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        set(f1, f2, f3, f4, f5, f6);
    }

    public BezierSplineSegment(PointF pointf, PointF pointf1, PointF pointf2)
    {
        set(pointf, pointf1, pointf2);
    }

    private float getDeriv(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            throw new IllegalArgumentException();
        } else
        {
            float f2 = a;
            float f3 = b;
            return (d * 2.0F * f1 + e) / (f2 * 2.0F * f1 + f3);
        }
    }

    private float getX(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            throw new IllegalArgumentException();
        } else
        {
            return (a * f1 + b) * f1 + c;
        }
    }

    private float getY(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            throw new IllegalArgumentException();
        } else
        {
            return (d * f1 + e) * f1 + f;
        }
    }

    private float seek(float f1)
    {
        float f4 = getX(uGuess);
        float f2 = 0.0F;
        float f3 = 1.0F;
        while (Math.abs(f4 - f1) > 0.1F) 
        {
            f4 = getX(uGuess);
            if (f4 < f1)
            {
                f2 = uGuess;
            } else
            {
                f3 = uGuess;
            }
            uGuess = (3F * f2 + f3) / 4F;
        }
        return uGuess;
    }

    public final void set(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        if (f3 < f1 || f5 < f3)
        {
            throw new IllegalArgumentException();
        } else
        {
            a = (f1 + f5) / 2.0F - f3;
            b = f3 - f1;
            c = (f1 + f3) / 2.0F;
            d = (f2 + f6) / 2.0F - f4;
            e = f4 - f2;
            f = (f2 + f4) / 2.0F;
            uGuess = 0.5F;
            return;
        }
    }

    public final void set(PointF pointf, PointF pointf1, PointF pointf2)
    {
        if (pointf == null || pointf1 == null || pointf2 == null)
        {
            throw new NullPointerException();
        } else
        {
            set(pointf.x, pointf.y, pointf1.x, pointf1.y, pointf2.x, pointf2.y);
            return;
        }
    }

    public final float value(float f1)
    {
        return getY(seek(f1));
    }

    public final float valueDeriv(float f1)
    {
        return getDeriv(seek(f1));
    }
}
