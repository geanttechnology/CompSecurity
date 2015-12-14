// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.animation.Animator;
import android.graphics.PointF;

// Referenced classes of package w.panzoomview:
//            PanZoomView, b

class b
    implements android.animation.torListener
{

    final float a;
    final float b;
    final PanZoomView c;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        float f = PanZoomView.a(c, c.b.j);
        float f1 = PanZoomView.b(c, c.b.j);
        animator = new PointF(a, b);
        PointF pointf = new PointF(f, f1);
        PanZoomView.c(c, false);
        PanZoomView.d(c, animator, pointf, 1.0F);
        PanZoomView.a(c, ewerMode.a);
        PanZoomView.b(c, null);
        PanZoomView.b(c, false);
        PanZoomView.a(c, false);
        c.b.k = c.c(c.b);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ewerMode(PanZoomView panzoomview, float f, float f1)
    {
        c = panzoomview;
        a = f;
        b = f1;
        super();
    }
}
