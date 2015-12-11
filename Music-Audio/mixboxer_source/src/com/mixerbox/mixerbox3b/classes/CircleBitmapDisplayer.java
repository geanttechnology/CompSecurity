// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class CircleBitmapDisplayer
    implements BitmapDisplayer
{

    private int borderColor;
    private float borderWidth;

    public CircleBitmapDisplayer()
    {
        borderWidth = 0.0F;
    }

    public CircleBitmapDisplayer(int i, int j)
    {
        borderWidth = 0.0F;
        borderColor = i;
        borderWidth = j;
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        loadedfrom = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(loadedfrom);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff424242);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getHeight() / 2 - 1, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (borderWidth > 0.0F)
        {
            Paint paint1 = new Paint();
            paint1.setAntiAlias(true);
            paint1.setColor(borderColor);
            paint1.setStrokeWidth(borderWidth);
            paint1.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, (float)((double)(bitmap.getHeight() / 2) - Math.ceil(borderWidth / 2.0F)), paint1);
        }
        imageaware.setImageBitmap(loadedfrom);
    }
}
