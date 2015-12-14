// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.aviary.android.feather.library.graphics:
//            LineF

public final class Point2D
{

    private Point2D()
    {
    }

    public static double angle360(double d)
    {
        if (d < 0.0D)
        {
            return d % -360D + 360D;
        } else
        {
            return d % 360D;
        }
    }

    public static double angleBetweenPoints(float f, float f1, float f2, float f3, float f4)
    {
        if (f == f2 && f1 == f3)
        {
            return 0.0D;
        }
        double d = Math.atan2(f - f2, f1 - f3);
        if (f4 > 0.0F)
        {
            return (double)((float)Math.round(d / (double)f4) * f4);
        } else
        {
            return angle360(degrees(d));
        }
    }

    public static double angleBetweenPoints(PointF pointf, PointF pointf1)
    {
        return angleBetweenPoints(pointf, pointf1, 0.0F);
    }

    public static double angleBetweenPoints(PointF pointf, PointF pointf1, float f)
    {
        return angleBetweenPoints(pointf.x, pointf.y, pointf1.x, pointf1.y, f);
    }

    public static double angleBetweenPoints(float af[], float af1[])
    {
        return angleBetweenPoints(af[0], af[1], af1[0], af1[1], 0.0F);
    }

    public static double degrees(double d)
    {
        return 57.295779513082323D * d;
    }

    public static double distance(float f, float f1, float f2, float f3)
    {
        return Math.sqrt(Math.pow(f - f2, 2D) + Math.pow(f1 - f3, 2D));
    }

    public static double distance(PointF pointf, PointF pointf1)
    {
        return distance(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public static double distance(float af[], float af1[])
    {
        return distance(af[0], af[1], af1[0], af1[1]);
    }

    public static void getLerp(PointF pointf, PointF pointf1, float f, PointF pointf2)
    {
        pointf2.set(pointf.x + (pointf1.x - pointf.x) * f, pointf.y + (pointf1.y - pointf.y) * f);
    }

    public static boolean getLineToLineIntersection(LineF alinef[], LineF linef, LineF linef1)
    {
        if (alinef != null && alinef.length >= 2) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        PointF pointf;
        PointF pointf2;
        int i;
        pointf = null;
        pointf2 = null;
        i = 0;
_L8:
        PointF pointf1;
        pointf1 = pointf;
        if (i >= alinef.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        pointf = linef.intersect(alinef[i]);
        if (pointf == null) goto _L4; else goto _L3
_L3:
        pointf1 = pointf;
        if (pointf1 == null) goto _L1; else goto _L5
_L5:
        int j;
        j = 0;
        pointf = pointf2;
_L7:
        pointf2 = pointf;
        if (j >= alinef.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j != i)
        {
            break; /* Loop/switch isn't completed */
        }
_L10:
        j++;
        if (true) goto _L7; else goto _L6
_L4:
        i++;
          goto _L8
_L6:
        pointf2 = linef.intersect(alinef[j]);
        pointf = pointf2;
        if (pointf2 == null) goto _L10; else goto _L9
_L9:
        if (pointf2 == null) goto _L1; else goto _L11
_L11:
        linef1.set(pointf1, pointf2);
        return true;
    }

    public static void grow(RectF rectf, float f, float f1)
    {
        rectf.left = rectf.left - f / 2.0F;
        rectf.top = rectf.top - f1 / 2.0F;
        rectf.right = rectf.right + f / 2.0F;
        rectf.bottom = rectf.bottom + f1 / 2.0F;
    }

    public static double hypotenuse(RectF rectf)
    {
        return Math.sqrt(Math.pow(rectf.right - rectf.left, 2D) + Math.pow(rectf.bottom - rectf.top, 2D));
    }

    public static PointF intersection(PointF apointf[], PointF apointf1[])
    {
        float f = apointf[0].x;
        float f1 = apointf[0].y;
        float f2 = apointf[1].x;
        float f3 = apointf[1].y;
        float f4 = apointf1[0].x;
        float f5 = apointf1[0].y;
        float f6 = apointf1[1].x;
        float f7 = apointf1[1].y;
        return new PointF(((f * f3 - f1 * f2) * (f4 - f6) - (f - f2) * (f4 * f7 - f5 * f6)) / ((f - f2) * (f5 - f7) - (f1 - f3) * (f4 - f6)), ((f * f3 - f1 * f2) * (f5 - f7) - (f1 - f3) * (f4 * f7 - f5 * f6)) / ((f - f2) * (f5 - f7) - (f1 - f3) * (f4 - f6)));
    }

    public static double radians(double d)
    {
        return 0.017453292519943295D * d;
    }

    public static void rotate(PointF pointf, double d)
    {
        float f = pointf.x;
        float f1 = pointf.y;
        double d1 = Math.cos(d);
        d = Math.sin(d);
        pointf.x = (float)((double)f * d1 - (double)f1 * d);
        pointf.y = (float)((double)f * d + (double)f1 * d1);
    }

    public static void rotate(PointF apointf[], double d)
    {
        for (int i = 0; i < apointf.length; i++)
        {
            rotate(apointf[i], d);
        }

    }

    public static void rotateAroundBy(PointF pointf, PointF pointf1, float f)
    {
        double d1 = (double)f * 0.017453292519943295D;
        double d = Math.cos(d1);
        d1 = Math.sin(d1);
        pointf.x = (float)(((double)(pointf.x - pointf1.x) * d - (double)(pointf.y - pointf1.y) * d1) + (double)pointf1.x);
        pointf.y = (float)((double)(pointf.x - pointf1.x) * d1 + (double)(pointf.y - pointf1.y) * d + (double)pointf1.y);
    }

    public static void rotateAroundOrigin(PointF pointf, PointF pointf1, float f)
    {
        float f1 = (float)radians(f);
        f = (float)Math.sin(f1);
        f1 = (float)Math.cos(f1);
        pointf.x = pointf.x - pointf1.x;
        pointf.y = pointf.y - pointf1.y;
        float f2 = pointf.x;
        float f3 = pointf.y;
        float f4 = pointf.x;
        float f5 = pointf.y;
        pointf.x = pointf1.x + (f2 * f1 - f3 * f);
        pointf.y = pointf1.y + (f4 * f + f5 * f1);
    }

    public static PointF sizeOfRect(PointF apointf[])
    {
        return new PointF(apointf[1].x - apointf[0].x, apointf[3].y - apointf[0].y);
    }

    public static void translate(PointF pointf, float f, float f1)
    {
        pointf.x = pointf.x + f;
        pointf.y = pointf.y + f1;
    }

    public static void translate(PointF apointf[], float f, float f1)
    {
        for (int i = 0; i < apointf.length; i++)
        {
            translate(apointf[i], f, f1);
        }

    }
}
