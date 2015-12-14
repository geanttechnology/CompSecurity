// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.b.a;

public class e
    implements a
{

    private float a;
    private int b;
    private int c;

    public e()
    {
        a = 0.0F;
        b = 100;
    }

    public e(int i, int j)
    {
        a = 0.0F;
        b = 100;
        c = i;
        a = j;
    }

    public void a(int i)
    {
        b = i;
    }

    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.c.a a1, LoadedFrom loadedfrom)
    {
        int j1 = b * 2;
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        int i = Math.abs(l - i1) / 2;
        float f;
        int j;
        if (l < i1)
        {
            f = (float)j1 / (float)l;
        } else
        {
            f = (float)j1 / (float)i1;
        }
        if (l <= i1)
        {
            j = l;
        } else
        {
            j = i1;
        }
        loadedfrom = bitmap;
        if (j != j1)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Do scale"
            });
            loadedfrom = new Matrix();
            loadedfrom.postScale(f, f);
            Canvas canvas;
            Paint paint;
            Rect rect;
            int k;
            if (l < i1)
            {
                k = 0;
            } else
            {
                k = i;
            }
            if (l >= i1)
            {
                i = 0;
            }
            loadedfrom = Bitmap.createBitmap(bitmap, k, i, j, j, loadedfrom, true);
        }
        bitmap = Bitmap.createBitmap(j1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        rect = new Rect(0, 0, j1, j1);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(b, b, b, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(loadedfrom, rect, rect, paint);
        if (a > 0.0F)
        {
            loadedfrom = new Paint();
            loadedfrom.setAntiAlias(true);
            loadedfrom.setColor(c);
            loadedfrom.setStrokeWidth(a);
            loadedfrom.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawCircle(b, b, (float)((double)b - Math.ceil(a / 2.0F)), loadedfrom);
        }
        a1.a(bitmap);
    }
}
