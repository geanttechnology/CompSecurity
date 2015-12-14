// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import junit.framework.Assert;

public abstract class l
{

    private static float a[] = new float[3];
    private static final RectF b = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
    private static final RectF c = new RectF();
    private static final Matrix d = new Matrix();

    public l()
    {
    }

    public static float a(float f, float f1, float f2, float f3)
    {
        f -= f2;
        f1 -= f3;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float a(Matrix matrix)
    {
        matrix.mapRect(c, b);
        return c.width() / b.width();
    }

    public static float a(PointF pointf, PointF pointf1)
    {
        return b(pointf.x, pointf.y, pointf1.x, pointf1.y);
    }

    public static float a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3)
    {
        float f = pointf.x;
        float f1 = pointf1.x;
        float f2 = pointf.y;
        float f3 = pointf1.y;
        float f4 = pointf2.x;
        float f5 = pointf3.x;
        return (float)Math.toDegrees(Math.atan2(pointf2.y - pointf3.y, f4 - f5) - Math.atan2(f2 - f3, f - f1));
    }

    public static int a(int i, float f)
    {
        float af[];
        boolean flag;
        if (-360F < f && f < 360F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        Color.colorToHSV(i, a);
        a[0] = a[0] + f;
        if (a[0] >= 0.0F) goto _L2; else goto _L1
_L1:
        af = a;
        af[0] = af[0] + 360F;
_L4:
        return Color.HSVToColor(Color.alpha(i), a);
_L2:
        if (a[0] >= 360F)
        {
            float af1[] = a;
            af1[0] = af1[0] - 360F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Point a(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        Method method = android/view/Display.getMethod("getRawWidth", new Class[0]);
        Method method1 = android/view/Display.getMethod("getRawHeight", new Class[0]);
        j = ((Integer)method.invoke(activity, new Object[0])).intValue();
        i = ((Integer)method1.invoke(activity, new Object[0])).intValue();
_L4:
        return new Point(j, i);
        Object obj;
        obj;
_L2:
        j = activity.getWidth();
        i = activity.getHeight();
        if (true) goto _L4; else goto _L3
_L3:
        obj;
          goto _L2
        obj;
          goto _L2
        obj;
          goto _L2
    }

    public static void a(float f, float f1, float f2, float f3, float f4, PointF pointf)
    {
        f2 -= f;
        f3 -= f1;
        float f5 = (float)Math.sqrt(f2 * f2 + f3 * f3);
        pointf.x = (f2 * f4) / f5 + f;
        pointf.y = (f3 * f4) / f5 + f1;
    }

    public static void a(float f, float f1, float f2, float f3, PointF pointf)
    {
        pointf.set((f + f2) / 2.0F, (f1 + f3) / 2.0F);
    }

    public static void a(PointF pointf, PointF pointf1, PointF pointf2)
    {
        pointf2.set((pointf.x + pointf1.x) / 2.0F, (pointf.y + pointf1.y) / 2.0F);
    }

    public static void a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4)
    {
        float f = (pointf.x + pointf1.x) / 2.0F;
        float f1 = (pointf.y + pointf1.y) / 2.0F;
        pointf4.set((pointf2.x + pointf3.x) / 2.0F - f, (pointf2.y + pointf3.y) / 2.0F - f1);
    }

    public static void a(PointF pointf, PointF pointf1, RectF rectf)
    {
        pointf1.x = (pointf.x - rectf.left) / rectf.width();
        pointf1.y = (pointf.y - rectf.top) / rectf.height();
    }

    public static void a(RectF rectf)
    {
        float f = rectf.centerX();
        float f1 = rectf.centerY();
        d.setScale(0.5F, 0.5F, f, f1);
        d.mapRect(rectf);
    }

    public static void a(RectF rectf, RectF rectf1)
    {
        d.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.CENTER);
        d.mapRect(rectf);
    }

    public static void a(RectF rectf, RectF rectf1, RectF rectf2)
    {
        d.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.CENTER);
        d.mapRect(rectf2, rectf);
    }

    public static float b(float f, float f1, float f2, float f3)
    {
        f = f2 - f;
        f1 = f3 - f1;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static float b(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        float f = af[0];
        float f1 = af[3];
        return (float)Math.sqrt(f1 * f1 + f * f);
    }

    public static void b(float f, float f1, float f2, float f3, float f4, PointF pointf)
    {
        pointf.x = (f2 - f) * f4 + f;
        pointf.y = (f3 - f1) * f4 + f1;
    }

    public static void b(PointF pointf, PointF pointf1, RectF rectf)
    {
        pointf.x = pointf1.x * rectf.width() + rectf.left;
        pointf.y = pointf1.y * rectf.height() + rectf.top;
    }

    public static void b(RectF rectf, RectF rectf1)
    {
        float f = rectf.centerX();
        float f1 = rectf.centerY();
        d.setScale(0.7F, 0.7F, f, f1);
        d.mapRect(rectf1, rectf);
    }

    static 
    {
        com/socialin/android/util/l.getSimpleName();
    }
}
