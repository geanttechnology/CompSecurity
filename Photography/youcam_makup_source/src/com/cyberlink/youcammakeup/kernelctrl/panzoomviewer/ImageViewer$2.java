// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageViewer, q

class b
    implements android.animation.torListener
{

    final ImageViewer a;
    private boolean b;

    public void onAnimationCancel(Animator animator)
    {
        b = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        a.m.p = 255;
        if (b);
        a.a(fferName.c, new q(a, a.m));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        b = false;
    }

    fferName(ImageViewer imageviewer)
    {
        a = imageviewer;
        super();
        b = false;
    }
}
