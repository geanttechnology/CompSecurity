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

class gifStrechProcess extends commenProcess
{

    gifStrechProcess()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        Bitmap bitmap;
        CxImage cximage;
label0:
        {
            bitmap = greyScaler(sourceImage);
            if (bitmap != null)
            {
                cximage = new CxImage(bitmap);
                if (cximage.a(2))
                {
                    break label0;
                }
            }
            return;
        }
        canvas.drawBitmap(cximage.a(), 0.0F, 0.0F, paint);
        bitmap.recycle();
    }
}
