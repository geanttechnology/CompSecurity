// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class setSaturation extends commenProcess
{

    public float savturation;

    setSaturation()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        canvas = new ColorMatrix();
        canvas.setSaturation(savturation);
        paint.setColorFilter(new ColorMatrixColorFilter(canvas));
    }
}
