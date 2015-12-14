// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

public final class a
{

    private static final Paint a = new Paint(2);

    public static float a(float f, float f1, float f2, float f3)
    {
        return (float)Math.sqrt(Math.pow(f2 - f, 2D) + Math.pow(f3 - f1, 2D));
    }

    public static int a(float f, float f1)
    {
        return (int)Math.toDegrees(Math.atan2(f1, f));
    }

    public static Integer a(RectF rectf, float f, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        float f7 = rectf.centerX();
        float f8 = (int)rectf.centerY();
        float af[] = b(new float[] {
            f, f1
        }, f7, f8, f2);
        f = af[0];
        f1 = af[1];
        f2 = rectf.left;
        f2 = rectf.right - f3 / 2.0F;
        f7 = rectf.top;
        f7 = rectf.bottom - f4 / 2.0F;
        if (f >= f2 && f <= f2 + f3 && f1 >= f7 && f1 <= f4 + f7)
        {
            return Integer.valueOf(3);
        }
        f2 = rectf.left - f5 / 2.0F;
        f3 = rectf.right - f5 / 2.0F;
        f4 = rectf.top - f6 / 2.0F;
        f7 = rectf.bottom - f6 / 2.0F;
        if (f >= rectf.width() / 2.0F + f2 && f <= f5 + f2 + rectf.width() / 2.0F && f1 >= f4 && f1 <= f6 + f4)
        {
            return Integer.valueOf(4);
        }
        if (f >= f3 && f <= f5 + f3 && f1 >= rectf.height() / 2.0F + f4 && f1 <= f4 + f6 + rectf.height() / 2.0F)
        {
            return Integer.valueOf(5);
        }
        if (f >= f3 - rectf.width() / 2.0F && f <= (f3 + f5) - rectf.width() / 2.0F && f1 >= f7 && f1 <= f6 + f7)
        {
            return Integer.valueOf(6);
        }
        if (f >= f2 && f <= f2 + f5 && f1 >= f7 - rectf.height() / 2.0F && f1 <= (f6 + f7) - rectf.height() / 2.0F)
        {
            return Integer.valueOf(7);
        } else
        {
            return null;
        }
    }

    public static void a(Canvas canvas, Rect rect, Paint paint, Paint paint1, float f, float f1, float f2, Bitmap bitmap, 
            Bitmap bitmap1, Bitmap bitmap2, boolean flag)
    {
        canvas.save();
        canvas.rotate(f2, f, f1);
        canvas.drawRect(rect, paint);
        rect.inset(1, 1);
        canvas.drawRect(rect, paint1);
        rect.inset(-1, -1);
        int k1 = bitmap.getWidth();
        int i = bitmap.getHeight();
        int l = rect.left;
        l = rect.right;
        k1 /= 2;
        int j2 = rect.top;
        j2 = rect.bottom;
        i /= 2;
        canvas.drawBitmap(bitmap, l - k1, j2 - i, a);
        if (bitmap2 != null)
        {
            int k2 = bitmap2.getWidth();
            int l1 = bitmap2.getHeight();
            int j = rect.left - k2 / 2;
            int i1 = rect.right;
            k2 /= 2;
            int i3 = rect.top - l1 / 2;
            int k3 = rect.bottom;
            l1 /= 2;
            canvas.drawBitmap(bitmap2, rect.width() / 2 + j, i3, a);
            canvas.drawBitmap(bitmap2, i1 - k2, rect.height() / 2 + i3, a);
            canvas.drawBitmap(bitmap2, rect.width() / 2 + j, k3 - l1, a);
            canvas.drawBitmap(bitmap2, j, rect.height() / 2 + i3, a);
        }
        if (flag)
        {
            int k = rect.right;
            int j1 = rect.top;
            if (rect.left > rect.right)
            {
                k = rect.left;
            }
            if (rect.top > rect.bottom)
            {
                j1 = rect.bottom;
            }
            int i2 = bitmap.getWidth() / 2;
            int l2 = bitmap.getHeight();
            int j3 = bitmap1.getHeight() / 2;
            canvas.drawBitmap(bitmap1, k - i2, j1 - l2 - j3, a);
            canvas.restore();
        }
    }

    public static void a(Canvas canvas, RectF rectf, Bitmap bitmap, float f, float f1, Rect rect, float f2, float f3, 
            RectF rectf1)
    {
        float f4 = rectf.right;
        float f5 = rectf.top;
        if (rectf.left > rectf.right)
        {
            f4 = rectf.left;
        }
        if (rectf.top > rectf.bottom)
        {
            f5 = rectf.bottom;
        }
        f = f4 - f / 2.0F;
        f1 = f5 - f1 - f1 / 2.0F;
        rectf1.set(f, f1, f + f2, f1 + f3);
        canvas.drawBitmap(bitmap, rect, rectf1, a);
    }

    public static void a(Canvas canvas, RectF rectf, Paint paint, Paint paint1, float f, float f1, Bitmap bitmap, Bitmap bitmap1, 
            Rect rect, float f2, float f3, Rect rect1, float f4, float f5, RectF rectf1)
    {
        canvas.save();
        canvas.rotate(0.0F, f, f1);
        canvas.drawRect(rectf, paint);
        rectf.inset(1.0F, 1.0F);
        canvas.drawRect(rectf, paint1);
        rectf.inset(-1F, -1F);
        f = rectf.left;
        f = rectf.right - f2 / 2.0F;
        f1 = rectf.top;
        f1 = rectf.bottom - f3 / 2.0F;
        rectf1.set(f, f1, f + f2, f1 + f3);
        canvas.drawBitmap(bitmap, rect, rectf1, a);
        if (bitmap1 != null)
        {
            f = rectf.left - f4 / 2.0F;
            f1 = rectf.right - f4 / 2.0F;
            f2 = rectf.top - f5 / 2.0F;
            f3 = rectf.bottom - f5 / 2.0F;
            rectf1.set(rectf.width() / 2.0F + f, f2, rectf.width() / 2.0F + f + f4, f2 + f5);
            canvas.drawBitmap(bitmap1, rect1, rectf1, a);
            rectf1.set(f1, rectf.height() / 2.0F + f2, f1 + f4, rectf.height() / 2.0F + f2 + f5);
            canvas.drawBitmap(bitmap1, rect1, rectf1, a);
            rectf1.set(rectf.width() / 2.0F + f, f3, rectf.width() / 2.0F + f + f4, f3 + f5);
            canvas.drawBitmap(bitmap1, rect1, rectf1, a);
            rectf1.set(f, rectf.height() / 2.0F + f2, f + f4, f2 + rectf.height() / 2.0F + f5);
            canvas.drawBitmap(bitmap1, rect1, rectf1, a);
        }
        canvas.restore();
    }

    public static void a(float af[], float f, float f1, float f2)
    {
        float f3 = af[0];
        float f4 = af[1];
        double d = Math.toRadians(f2);
        af[0] = (float)(((double)(f3 - f) * Math.cos(d) - (double)(f4 - f1) * Math.sin(d)) + (double)f);
        double d1 = f3 - f;
        double d2 = Math.sin(d);
        af[1] = (float)((double)(f4 - f1) * Math.cos(d) + d1 * d2 + (double)f1);
    }

    public static boolean a(Rect rect, float f, float f1, float f2)
    {
        float f3 = rect.exactCenterX();
        float f4 = rect.exactCenterY();
        float af[] = b(new float[] {
            f, f1
        }, f3, f4, f2);
        f = af[0];
        f1 = af[1];
        int j = rect.left;
        int l = rect.top;
        int i = rect.right;
        int k = rect.bottom;
        if (rect.left > rect.right)
        {
            j = rect.right;
            i = rect.left;
        }
        if (rect.top > rect.bottom)
        {
            l = rect.bottom;
            k = rect.top;
        }
        return f <= (float)i && f1 <= (float)k && f >= (float)j && f1 >= (float)l;
    }

    public static boolean a(RectF rectf, float f, float f1, float f2)
    {
        float f3 = rectf.centerX();
        float f4 = rectf.centerY();
        float af[] = b(new float[] {
            f, f1
        }, f3, f4, f2);
        f4 = af[0];
        float f5 = af[1];
        f1 = rectf.left;
        f3 = rectf.top;
        f = rectf.right;
        f2 = rectf.bottom;
        if (rectf.left > rectf.right)
        {
            f1 = rectf.right;
            f = rectf.left;
        }
        if (rectf.top > rectf.bottom)
        {
            f3 = rectf.bottom;
            f2 = rectf.top;
        }
        return f4 <= f && f5 <= f2 && f4 >= f1 && f5 >= f3;
    }

    public static Point b(float f, float f1)
    {
label0:
        {
            float f2;
            float f3;
            if (f <= 640F)
            {
                f3 = f;
                f2 = f1;
                if (f1 <= 640F)
                {
                    break label0;
                }
            }
            if (640F / f < 640F / f1)
            {
                f2 = 640F / f;
            } else
            {
                f2 = 640F / f1;
            }
            f3 = f * f2;
            f2 = f1 * f2;
        }
        return new Point((int)f3, (int)f2);
    }

    public static boolean b(RectF rectf, float f, float f1, float f2, float f3, float f4, float f5, float f6)
    {
        float f7 = rectf.centerX();
        float f8 = rectf.centerY();
        float af[] = b(new float[] {
            f, f1
        }, f7, f8, f2);
        f2 = af[0];
        f7 = af[1];
        f = rectf.right;
        f1 = rectf.top;
        if (rectf.left > rectf.right)
        {
            f = rectf.left;
        }
        if (rectf.top > rectf.bottom)
        {
            f1 = rectf.bottom;
        }
        f -= f3 / 2.0F;
        f1 = f1 - f4 - f6 / 2.0F;
        return f2 >= f && f2 < f + f5 && f7 >= f1 && f7 < f1 + f6;
    }

    public static float[] b(float af[], float f, float f1, float f2)
    {
        af = (float[])af.clone();
        a(af, f, f1, f2);
        return af;
    }

}
