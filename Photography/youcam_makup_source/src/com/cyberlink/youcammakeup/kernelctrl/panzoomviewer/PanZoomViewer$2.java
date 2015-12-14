// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, q, t, f

class a
    implements android.animation.rListener
{

    final android.animation.rListener a;
    final PanZoomViewer b;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
        PanZoomViewer.a(b, ewerMode.a);
        PanZoomViewer.b(b, false);
        PanZoomViewer.a(b, false);
        PanZoomViewer.a(b, ewerMode.a);
        b.m.q.f = b.b(b.m);
        animator = new f();
        animator.a = true;
        b.b(erName.c, animator);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationStart(animator);
        }
    }

    erName(PanZoomViewer panzoomviewer, android.animation.rListener rlistener)
    {
        b = panzoomviewer;
        a = rlistener;
        super();
    }
}
