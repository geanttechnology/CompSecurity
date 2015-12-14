// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.ValueAnimator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageViewer, q

class a
    implements android.animation.AnimatorUpdateListener
{

    final ImageViewer a;
    private q b;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction();
        if (b != null && b.n != a.m.n)
        {
            b = null;
        }
        if (b == null)
        {
            b = new q(a, a.m);
        }
        a.m.p = (int)(-255F * f + 255F);
        b.p = (int)(f * -255F + 255F);
        a.a(fferName.c, b);
    }

    fferName(ImageViewer imageviewer)
    {
        a = imageviewer;
        super();
    }
}
