// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import com.wantu.imagelib.cximage.CxImage;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class ABColor extends commenProcess
{

    ABColor()
    {
    }

    public Bitmap getScreenedImage(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN));
        paint.setAlpha(127);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap1;
    }

    public void process(Canvas canvas, Paint paint)
    {
        Bitmap bitmap = getScreenedImage(sourceImage);
        CxImage cximage = new CxImage(bitmap);
        if (!cximage.c())
        {
            return;
        } else
        {
            Bitmap bitmap1 = cximage.a();
            canvas.drawBitmap(bitmap1, 0.0F, 0.0F, paint);
            bitmap.recycle();
            bitmap1.recycle();
            cximage.a(null);
            return;
        }
    }
}
