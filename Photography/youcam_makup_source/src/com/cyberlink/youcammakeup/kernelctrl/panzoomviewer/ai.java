// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.ValueAnimator;
import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, ad

class ai
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final PanZoomViewer a;
    private float b;
    private float c;
    private ad d;

    public ai(PanZoomViewer panzoomviewer, float f, ad ad)
    {
        a = panzoomviewer;
        super();
        b = 0.0F;
        c = 0.0F;
        d = null;
        c = f;
        d = ad;
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction() * c;
        valueanimator = new PointF(f - b, 0.0F);
        PanZoomViewer.a(a, d, valueanimator);
        b = f;
    }
}
