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

class strechProcess extends commenProcess
{

    strechProcess()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        Bitmap bitmap = greyScaler(sourceImage);
        CxImage cximage = new CxImage(bitmap);
        if (!cximage.a(2))
        {
            return;
        }
        if (cximage.a() != null && !cximage.a().isRecycled())
        {
            canvas.drawBitmap(cximage.a(), 0.0F, 0.0F, paint);
        }
        bitmap.recycle();
    }
}
