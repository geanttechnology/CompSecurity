// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import act;
import android.graphics.Canvas;
import android.widget.ImageView;

public final class jb extends ImageView
{

    private int a;
    private act b;
    private int c;
    private float d;

    protected void onDraw(Canvas canvas)
    {
        if (b != null)
        {
            canvas.clipPath(b.a(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (a != 0)
        {
            canvas.drawColor(a);
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        c;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        j = getMeasuredHeight();
        i = (int)((float)j * d);
_L5:
        setMeasuredDimension(i, j);
        return;
_L3:
        i = getMeasuredWidth();
        j = (int)((float)i / d);
        if (true) goto _L5; else goto _L4
_L4:
    }
}
