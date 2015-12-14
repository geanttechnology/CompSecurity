// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.Animator;
import android.graphics.Matrix;
import android.graphics.PointF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, ad, q, t

class ah
    implements android.animation.Animator.AnimatorListener
{

    final PanZoomViewer a;
    private boolean b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private long i;
    private PanZoomViewer.SwitchDirection j;
    private float k;
    private ad l;

    ah(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
        b = false;
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0L;
        j = PanZoomViewer.SwitchDirection.b;
        k = 0.0F;
        l = null;
    }

    public void a(float f1, float f2)
    {
        g = f1;
        h = f2;
    }

    public void a(float f1, float f2, float f3, float f4)
    {
        d = f1;
        e = f2;
        f = f3;
        c = f4;
    }

    public void a(long l1, PanZoomViewer.SwitchDirection switchdirection, float f1)
    {
        i = l1;
        j = switchdirection;
        k = f1;
    }

    public void a(ad ad1)
    {
        l = ad1;
    }

    public void onAnimationCancel(Animator animator)
    {
        PanZoomViewer.a(a, "SwitchAnimator cancel");
        b = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        q q1 = l.a;
        animator = l.b;
        float af1[] = new float[9];
        q1.q.e.getValues(af1);
        float f1 = af1[0];
        float f2 = af1[2] * f1;
        float f3 = q1.e;
        float af[] = new float[9];
        ((q) (animator)).q.e.getValues(af);
        float f4 = af[0];
        f4 = (float)((q) (animator)).e * f4;
        float f5 = ((float)a.n - f4) / 2.0F;
        float f6 = ((float)a.n - c) / 2.0F + f5;
        f5 = f6 - (f6 - f5) * ((d - e) / (f - e));
        if (j == PanZoomViewer.SwitchDirection.b)
        {
            f1 = k - (f2 - f5 - f4);
        } else
        {
            f1 = k - (f3 * f1 + f2 + f5);
        }
        animator = new PointF(f1, 0.0F);
        PanZoomViewer.d(a, true);
        PanZoomViewer.c(a, false);
        PanZoomViewer.a(a, l, animator);
        PanZoomViewer.a(a, false);
        PanZoomViewer.d(a, false);
        PanZoomViewer.b(a, null);
        PanZoomViewer.b(a, false);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
