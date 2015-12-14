// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class drawGrayImage extends commenProcess
{

    drawGrayImage()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        Bitmap bitmap = greyScaler(sourceImage);
        if (bitmap != null && !bitmap.isRecycled())
        {
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
        bitmap.recycle();
    }
}
