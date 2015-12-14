// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wantu.imagelib.cximage.CxImage;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class colorComposite extends commenProcess
{

    public float alpha;
    public int blue;
    public int green;
    public int op;
    public int red;

    colorComposite()
    {
    }

    private Bitmap getColorBitmap()
    {
        Bitmap bitmap = Bitmap.createBitmap(canvasBitmap.getWidth(), canvasBitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(bitmap)).drawRGB(red, green, blue);
        return bitmap;
    }

    public void process(Canvas canvas, Paint paint)
    {
        CxImage cximage = new CxImage(canvasBitmap);
        Bitmap bitmap = getColorBitmap();
        cximage.a(bitmap, op);
        bitmap.recycle();
        if (cximage.a() != null && !cximage.a().isRecycled())
        {
            canvas.drawBitmap(cximage.a(), 0.0F, 0.0F, paint);
        }
    }
}
