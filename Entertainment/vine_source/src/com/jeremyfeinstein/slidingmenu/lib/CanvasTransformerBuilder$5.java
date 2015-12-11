// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.graphics.Canvas;
import android.view.animation.Interpolator;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            CanvasTransformerBuilder

class val.closedY
    implements er
{

    final CanvasTransformerBuilder this$0;
    final int val$closedX;
    final int val$closedY;
    final Interpolator val$interp;
    final int val$openedX;
    final int val$openedY;

    public void transformCanvas(Canvas canvas, float f)
    {
        CanvasTransformerBuilder.access$000(CanvasTransformerBuilder.this).transformCanvas(canvas, f);
        f = val$interp.getInterpolation(f);
        canvas.translate((float)(val$openedX - val$closedX) * f + (float)val$closedX, (float)(val$openedY - val$closedY) * f + (float)val$closedY);
    }

    er()
    {
        this$0 = final_canvastransformerbuilder;
        val$interp = interpolator;
        val$openedX = i;
        val$closedX = j;
        val$openedY = k;
        val$closedY = I.this;
        super();
    }
}
