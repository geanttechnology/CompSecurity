// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.image_processing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.application.PMApplication;

public class ImageEffects
{

    public ImageEffects()
    {
    }

    public static Bitmap adjustImage(Bitmap bitmap, float f, float f1, float f2)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        int i = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            int j = 0;
            while (j < l) 
            {
                int i1 = bitmap.getPixel(i, j);
                float f7 = Color.alpha(i1);
                float f4 = (float)Color.red(i1) * f2;
                float f5 = (float)Color.green(i1) * f2;
                float f3 = (float)Color.blue(i1) * f2;
                float f6 = (float)((double)f4 * 0.21249999999999999D + (double)f5 * 0.71540000000000004D + (double)f3 * 0.072099999999999997D);
                f4 = (float)(0.5D + (double)f * ((double)(f6 + (f4 - f6) * f1) - 0.5D));
                f5 = (float)(0.5D + (double)f * ((double)(f6 + (f5 - f6) * f1) - 0.5D));
                f6 = (float)(0.5D + (double)f * ((double)(f6 + (f3 - f6) * f1) - 0.5D));
                int j1;
                int k1;
                if (f4 < 0.0F)
                {
                    f3 = 0.0F;
                } else
                {
                    f3 = f4;
                    if (f4 > 255F)
                    {
                        f3 = 255F;
                    }
                }
                if (f5 < 0.0F)
                {
                    f4 = 0.0F;
                } else
                {
                    f4 = f5;
                    if (f5 > 255F)
                    {
                        f4 = 255F;
                    }
                }
                if (f6 < 0.0F)
                {
                    f5 = 0.0F;
                } else
                {
                    f5 = f6;
                    if (f6 > 255F)
                    {
                        f5 = 255F;
                    }
                }
                i1 = (int)f3;
                j1 = (int)f4;
                k1 = (int)f5;
                bitmap.setPixel(i, j, Color.argb((int)f7, i1, j1, k1));
                j++;
            }
            i++;
        } while (true);
        return bitmap;
    }

    public static Bitmap applyOverlay(Bitmap bitmap, String s)
    {
        Object obj = PMApplication.getContext();
        int i = ((Context) (obj)).getResources().getIdentifier(s, "drawable", ((Context) (obj)).getPackageName());
        s = BitmapFactoryInstrumentation.decodeResource(((Context) (obj)).getResources(), i);
        obj = new Canvas(bitmap);
        Rect rect = new Rect(0, 0, s.getWidth(), s.getHeight());
        Rect rect1 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        ((Canvas) (obj)).drawBitmap(bitmap, 0.0F, 0.0F, null);
        ((Canvas) (obj)).drawBitmap(s, rect, rect1, null);
        s.recycle();
        return bitmap;
    }

    public static Bitmap balanceColor(Bitmap bitmap, double d, double d1, double d2)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        int i = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            int j = 0;
            while (j < l) 
            {
                int i1 = bitmap.getPixel(i, j);
                float f4 = Color.alpha(i1);
                float f1 = (int)((double)(Color.red(i1) + 1) * d);
                float f2 = (int)((double)(Color.green(i1) + 1) * d1);
                float f3 = (int)((double)(Color.blue(i1) + 1) * d2);
                float f;
                int j1;
                int k1;
                if (f1 < 0.0F)
                {
                    f = 0.0F;
                } else
                {
                    f = f1;
                    if (f1 > 255F)
                    {
                        f = 255F;
                    }
                }
                if (f2 < 0.0F)
                {
                    f1 = 0.0F;
                } else
                {
                    f1 = f2;
                    if (f2 > 255F)
                    {
                        f1 = 255F;
                    }
                }
                if (f3 < 0.0F)
                {
                    f2 = 0.0F;
                } else
                {
                    f2 = f3;
                    if (f3 > 255F)
                    {
                        f2 = 255F;
                    }
                }
                i1 = (int)f;
                j1 = (int)f1;
                k1 = (int)f2;
                bitmap.setPixel(i, j, Color.argb((int)f4, i1, j1, k1));
                j++;
            }
            i++;
        } while (true);
        return bitmap;
    }

    public static Bitmap blendColor(Bitmap bitmap, int i, android.graphics.PorterDuff.Mode mode)
    {
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(mode));
        paint.setColor(i);
        canvas.drawRect(new Rect(0, 0, j, k), paint);
        return bitmap;
    }

    public static Bitmap convertImageToGrayScale(Bitmap bitmap)
    {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        ColorMatrix colormatrix = new ColorMatrix();
        colormatrix.setSaturation(0.0F);
        paint.setColorFilter(new ColorMatrixColorFilter(colormatrix));
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap;
    }
}
