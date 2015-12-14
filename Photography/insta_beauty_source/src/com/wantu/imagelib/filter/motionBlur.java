// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class motionBlur extends commenProcess
{

    public float angle;
    public float distance;
    public float rotation;
    public float zoom;

    motionBlur()
    {
    }

    private Bitmap fastMotionBlur(Bitmap bitmap)
    {
        float f4 = (float)bitmap.getWidth() / 2.0F;
        float f5 = (float)bitmap.getHeight() / 2.0F;
        float f6 = (float)Math.sqrt(f4 * f4 + f5 * f5);
        float f3 = (float)((double)distance * Math.cos(angle));
        float f2 = (float)((double)distance * -Math.sin(angle));
        float f1 = zoom;
        float f = rotation;
        float f7 = distance;
        float f8 = Math.abs(rotation * f6);
        f6 = f6 * zoom + (f7 + f8);
        int j = log2((int)f6);
        f3 /= f6;
        f2 /= f6;
        f1 /= f6;
        f /= f6;
        if (j == 0)
        {
            return bitmap;
        }
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, null, rect, paint);
        for (int i = 0; i < j; i++)
        {
            canvas.drawBitmap(bitmap1, null, rect, paint);
            paint.setAlpha(127);
            bitmap = new Matrix();
            bitmap.postTranslate(f4 + f3, f5 + f2);
            bitmap.postScale(1.0001F + f1, 1.0001F + f1);
            if (f != 0.0F)
            {
                bitmap.postRotate(f);
            }
            bitmap.postTranslate(-f4, -f5);
            canvas.drawBitmap(bitmap1, bitmap, paint);
            f3 *= 2.0F;
            f2 *= 2.0F;
            f1 *= 2.0F;
            f *= 2.0F;
        }

        return bitmap1;
    }

    private int log2(int i)
    {
        int k = 1;
        int j;
        for (j = 0; k < i; j++)
        {
            k *= 2;
        }

        return j;
    }

    public void process(Canvas canvas, Paint paint)
    {
        Bitmap bitmap = fastMotionBlur(sourceImage);
        if (bitmap != null)
        {
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
    }
}
