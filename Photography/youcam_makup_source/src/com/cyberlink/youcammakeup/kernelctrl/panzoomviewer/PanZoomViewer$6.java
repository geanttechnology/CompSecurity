// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.ValueAnimator;
import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class d
    implements android.animation.imatorUpdateListener
{

    final float a;
    final float b;
    final float c;
    final float d;
    final PanZoomViewer e;
    private float f;
    private float g;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        PanZoomViewer.a(e, ewerMode.d);
        float f2 = valueanimator.getAnimatedFraction();
        float f1 = a * f2;
        f2 *= b;
        valueanimator = new PointF(c, d);
        PointF pointf = new PointF(f1 - f, f2 - g);
        PanZoomViewer.c(e, valueanimator, pointf, 1.0F);
        f = f1;
        g = f2;
    }

    ewerMode(PanZoomViewer panzoomviewer, float f1, float f2, float f3, float f4)
    {
        e = panzoomviewer;
        a = f1;
        b = f2;
        c = f3;
        d = f4;
        super();
    }
}
