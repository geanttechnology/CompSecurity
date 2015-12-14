// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView
{

    private static PorterDuffXfermode d;
    private int a;
    private Paint b;
    private Paint c;

    public CircleImageView(Context context)
    {
        super(context);
        a = 5;
        b = new Paint();
        b.setAntiAlias(true);
        c = new Paint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setColor(0xff888888);
        c.setStrokeWidth(a);
    }

    public CircleImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 5;
        b = new Paint();
        b.setAntiAlias(true);
        c = new Paint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setColor(0xff888888);
        c.setStrokeWidth(a);
    }

    public CircleImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 5;
        b = new Paint();
        b.setAntiAlias(true);
        c = new Paint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setColor(0xff888888);
        c.setStrokeWidth(a);
    }

    public static Bitmap a(Bitmap bitmap, int i)
    {
        int j1 = i * 2;
        Bitmap bitmap1;
        Canvas canvas;
        Paint paint;
        Rect rect;
        if (bitmap.getWidth() != i * 2 || bitmap.getHeight() != i * 2)
        {
            int l = bitmap.getWidth();
            int i1 = bitmap.getHeight();
            float f;
            Matrix matrix;
            int j;
            int k;
            int k1;
            if (l < i1)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k != 0)
            {
                j = l;
            } else
            {
                j = i1;
            }
            k1 = Math.abs(l - i1);
            if (l < i1)
            {
                f = (float)j1 / (float)l;
            } else
            {
                f = (float)j1 / (float)i1;
            }
            matrix = new Matrix();
            matrix.postScale(f, f);
            if (k != 0)
            {
                l = 0;
            } else
            {
                l = k1 / 2;
            }
            if (k != 0)
            {
                k = k1 / 2;
            } else
            {
                k = 0;
            }
            bitmap = Bitmap.createBitmap(bitmap, l, k, j, j, matrix, true);
        }
        bitmap1 = Bitmap.createBitmap(j1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        paint = new Paint();
        rect = new Rect(0, 0, j1, j1);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(i, i, i, paint);
        paint.setXfermode(d);
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmap1;
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj;
        obj = getDrawable();
        break MISSING_BLOCK_LABEL_5;
        if (obj != null && getWidth() != 0 && getHeight() != 0)
        {
            if (obj instanceof StateListDrawable)
            {
                obj = ((BitmapDrawable)((StateListDrawable)obj).getCurrent()).getBitmap();
            } else
            {
                obj = ((BitmapDrawable)obj).getBitmap();
            }
            if (obj != null)
            {
                if (((Bitmap) (obj)).getWidth() != 0 && ((Bitmap) (obj)).getHeight() != 0)
                {
                    int i;
                    if (getWidth() < getHeight())
                    {
                        i = getWidth() / 2;
                    } else
                    {
                        i = getHeight() / 2;
                    }
                    canvas.drawBitmap(a(((Bitmap) (obj)), i), 0.0F, 0.0F, null);
                    return;
                }
            } else
            {
                super.onDraw(canvas);
                return;
            }
        }
        return;
    }

    public void setBorderWidth(int i)
    {
        a = i;
    }

    public void setHasBorder(boolean flag)
    {
    }

    static 
    {
        d = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
