// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import java.io.Serializable;

public class SPArrow
    implements Serializable
{

    private float x;
    private float y;

    private SPArrow()
    {
        x = 0.0F;
        y = 0.0F;
    }

    public static float angleBetweenArrows(SPArrow sparrow, SPArrow sparrow1)
    {
        float f = sparrow.dot(sparrow1) / (sparrow.getLength() * sparrow1.getLength());
        double d;
        if (f >= 1.0F)
        {
            d = 0.0D;
        } else
        {
            d = Math.acos(f);
        }
        return (float)d;
    }

    public static float distanceFromArrowToArrow(SPArrow sparrow, SPArrow sparrow1)
    {
        return (float)Math.sqrt(Math.pow(sparrow.x - sparrow1.x, 2D) + Math.pow(sparrow.y - sparrow1.y, 2D));
    }

    public static SPArrow getInstance()
    {
        return new SPArrow();
    }

    public static SPArrow interpolateFromPoint(SPArrow sparrow, SPArrow sparrow1, float f)
    {
        float f1 = 1.0F - f;
        return getInstance().setXY(sparrow.x * f1 + sparrow1.x * f, f1 * sparrow.y + sparrow1.y * f);
    }

    public SPArrow addArrow(SPArrow sparrow)
    {
        return getInstance().setXY(x + sparrow.x, y + sparrow.y);
    }

    public void copyFromPoint(SPArrow sparrow)
    {
        x = sparrow.x;
        y = sparrow.y;
    }

    public float dot(SPArrow sparrow)
    {
        return x * sparrow.x + y * sparrow.y;
    }

    public float getAngle()
    {
        return (float)Math.atan2(y, x);
    }

    public float getLength()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    public float getLengthSquared()
    {
        return x * x + y * y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public SPArrow invert()
    {
        return getInstance().setXY(-x, -y);
    }

    public boolean isEquivalent(SPArrow sparrow)
    {
        if (this != sparrow)
        {
            if (sparrow == null)
            {
                return false;
            }
            if (x != sparrow.x || y != sparrow.y)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isOrigin()
    {
        return x == 0.0F && y == 0.0F;
    }

    public SPArrow normalize()
    {
        if (x == 0.0F && y == 0.0F)
        {
            throw new IllegalStateException("Cannot normalize point in the origin");
        } else
        {
            float f = 1.0F / getLength();
            return getInstance().setXY(x * f, f * y);
        }
    }

    public SPArrow rotateBy(float f)
    {
        float f1 = (float)Math.sin(f);
        f = (float)Math.cos(f);
        return getInstance().setXY(x * f - y * f1, f1 * x + f * y);
    }

    public SPArrow rotateBy(float f, float f1, float f2)
    {
        SPArrow sparrow = getInstance().setXY(f1, f2);
        return subtractArrow(sparrow).rotateBy(f).addArrow(sparrow);
    }

    public SPArrow scaleBy(float f)
    {
        return getInstance().setXY(x * f, y * f);
    }

    public SPArrow setPolarCoordinates(float f, float f1)
    {
        x = (float)(Math.cos(f1) * (double)f);
        y = (float)(Math.sin(f1) * (double)f);
        return this;
    }

    public SPArrow setX(float f)
    {
        x = f;
        return this;
    }

    public SPArrow setXY(float f, float f1)
    {
        x = f;
        y = f1;
        return this;
    }

    public SPArrow setY(float f)
    {
        y = f;
        return this;
    }

    public SPArrow subtractArrow(SPArrow sparrow)
    {
        return getInstance().setXY(x - sparrow.x, y - sparrow.y);
    }
}
