// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.ValueAnimator;
import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class i
    implements android.animation.imatorUpdateListener
{

    final float a;
    final float b;
    final float c;
    final float d;
    final long e;
    final long f;
    final PanZoomViewer g;
    private float h;
    private float i;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f2 = 0.0F;
        long l = valueanimator.getCurrentPlayTime();
        float f1 = a / 1000F;
        float f3 = l;
        f3 = (b * (float)l * (float)l) / 2.0F + f1 * f3;
        f1 = c / 1000F;
        float f4 = l;
        f4 = (d * (float)l * (float)l) / 2.0F + f1 * f4;
        PanZoomViewer.a(g, ewerMode.e);
        valueanimator = new PointF((float)g.n / 2.0F, (float)g.o / 2.0F);
        PointF pointf = new PointF(f3 - h, f4 - i);
        if (l < e)
        {
            f1 = pointf.x;
        } else
        {
            f1 = 0.0F;
        }
        pointf.x = f1;
        f1 = f2;
        if (l < f)
        {
            f1 = pointf.y;
        }
        pointf.y = f1;
        PanZoomViewer.c(g, valueanimator, pointf, 1.0F);
        h = f3;
        i = f4;
    }

    ewerMode(PanZoomViewer panzoomviewer, float f1, float f2, float f3, float f4, long l, 
            long l1)
    {
        g = panzoomviewer;
        a = f1;
        b = f2;
        c = f3;
        d = f4;
        e = l;
        f = l1;
        super();
        h = 0.0F;
        i = 0.0F;
    }
}
