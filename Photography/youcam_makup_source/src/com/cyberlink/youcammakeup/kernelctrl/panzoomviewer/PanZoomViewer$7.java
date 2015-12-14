// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;
import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, q, t, f

class a
    implements android.animation.rListener
{

    boolean a;
    final float b;
    final float c;
    final PanZoomViewer d;

    public void onAnimationCancel(Animator animator)
    {
        PanZoomViewer.a(d, ewerMode.d);
        float f1 = PanZoomViewer.a(d, d.m.q.e);
        float f2 = PanZoomViewer.b(d, d.m.q.e);
        animator = new PointF(b, c);
        PointF pointf = new PointF(f1, f2);
        PanZoomViewer.c(d, false);
        PanZoomViewer.c(d, animator, pointf, 1.0F);
        PanZoomViewer.a(d, ewerMode.a);
        PanZoomViewer.a(d, "Bouncing cancel");
        PanZoomViewer.c(d, null);
        PanZoomViewer.b(d, false);
        a = true;
        PanZoomViewer.a(d, false);
        PanZoomViewer.j(d);
    }

    public void onAnimationEnd(Animator animator)
    {
        if (a)
        {
            return;
        } else
        {
            float f1 = PanZoomViewer.a(d, d.m.q.e);
            float f2 = PanZoomViewer.b(d, d.m.q.e);
            animator = new PointF(b, c);
            PointF pointf = new PointF(f1, f2);
            PanZoomViewer.c(d, false);
            PanZoomViewer.c(d, animator, pointf, 1.0F);
            PanZoomViewer.a(d, ewerMode.a);
            d.m.q.f = d.b(d.m);
            animator = new f();
            animator.a = true;
            d.b(erName.c, animator);
            PanZoomViewer.a(d, false);
            PanZoomViewer.a(d, "Bouncing end");
            PanZoomViewer.c(d, null);
            PanZoomViewer.b(d, false);
            PanZoomViewer.j(d);
            return;
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    erName(PanZoomViewer panzoomviewer, float f1, float f2)
    {
        d = panzoomviewer;
        b = f1;
        c = f2;
        super();
        a = false;
    }
}
