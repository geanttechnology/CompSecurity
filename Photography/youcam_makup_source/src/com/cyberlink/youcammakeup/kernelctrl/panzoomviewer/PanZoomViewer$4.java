// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class a
    implements android.animation.rListener
{

    final PanZoomViewer a;

    public void onAnimationCancel(Animator animator)
    {
        PanZoomViewer.a(a, ewerMode.a);
        PanZoomViewer.a(a, null);
        PanZoomViewer.a(a, "Fling cancel");
        PanZoomViewer.a(a, false);
    }

    public void onAnimationEnd(Animator animator)
    {
        PanZoomViewer.a(a, ewerMode.a);
        PanZoomViewer.c(a, false);
        PanZoomViewer.i(a);
        PanZoomViewer.a(a, null);
        PanZoomViewer.a(a, "Fling end");
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ewerMode(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
    }
}
