// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

// Referenced classes of package com.wantu.imagelib.filter:
//            baseProcess

class commenProcess
    implements baseProcess
{

    public Bitmap canvasBitmap;
    public Context context;
    public Bitmap sourceImage;

    commenProcess()
    {
    }

    public Bitmap getSourceImage()
    {
        return sourceImage;
    }

    public Bitmap greyScaler(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        ColorMatrix colormatrix = new ColorMatrix();
        colormatrix.setSaturation(0.0F);
        paint.setColorFilter(new ColorMatrixColorFilter(colormatrix));
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap1;
    }

    public void process(Canvas canvas, Paint paint)
    {
    }

    public void setSourceImage(Bitmap bitmap)
    {
        sourceImage = bitmap;
    }
}
