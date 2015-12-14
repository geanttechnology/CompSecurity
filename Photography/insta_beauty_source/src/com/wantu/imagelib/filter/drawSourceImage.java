// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class drawSourceImage extends commenProcess
{

    public Rect rect;

    drawSourceImage()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        canvas.drawBitmap(sourceImage, null, rect, paint);
    }
}
