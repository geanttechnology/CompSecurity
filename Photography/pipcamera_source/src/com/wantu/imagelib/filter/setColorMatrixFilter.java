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

class setColorMatrixFilter extends commenProcess
{

    public float a;
    public float b;
    public float g;
    private ColorMatrix mCM;
    public float r;

    setColorMatrixFilter()
    {
        a = 1.0F;
        mCM = new ColorMatrix();
    }

    public void process(Canvas canvas, Paint paint)
    {
        mCM.setScale(r, g, b, a);
        paint.setColorFilter(new ColorMatrixColorFilter(mCM));
    }
}
