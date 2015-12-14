// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.wantu.imagelib.cximage.CxImage;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class blurLight extends commenProcess
{

    blurLight()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        CxImage cximage = new CxImage(sourceImage);
        if (!cximage.a(2.0F))
        {
            return;
        } else
        {
            canvas.drawBitmap(cximage.a(), 0.0F, 0.0F, paint);
            return;
        }
    }
}
