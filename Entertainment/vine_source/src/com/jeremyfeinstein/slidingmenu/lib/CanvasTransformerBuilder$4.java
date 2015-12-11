// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.graphics.Canvas;
import android.view.animation.Interpolator;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            CanvasTransformerBuilder

class val.py
    implements er
{

    final CanvasTransformerBuilder this$0;
    final int val$closedDeg;
    final Interpolator val$interp;
    final int val$openedDeg;
    final int val$px;
    final int val$py;

    public void transformCanvas(Canvas canvas, float f)
    {
        CanvasTransformerBuilder.access$000(CanvasTransformerBuilder.this).transformCanvas(canvas, f);
        f = val$interp.getInterpolation(f);
        canvas.rotate((float)(val$openedDeg - val$closedDeg) * f + (float)val$closedDeg, val$px, val$py);
    }

    er()
    {
        this$0 = final_canvastransformerbuilder;
        val$interp = interpolator;
        val$openedDeg = i;
        val$closedDeg = j;
        val$px = k;
        val$py = I.this;
        super();
    }
}
