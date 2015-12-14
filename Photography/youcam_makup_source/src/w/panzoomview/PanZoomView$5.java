// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.animation.Animator;

// Referenced classes of package w.panzoomview:
//            PanZoomView

class a
    implements android.animation.torListener
{

    final PanZoomView a;

    public void onAnimationCancel(Animator animator)
    {
        PanZoomView.a(a, ewerMode.a);
        PanZoomView.a(a, null);
        PanZoomView.a(a, false);
    }

    public void onAnimationEnd(Animator animator)
    {
        PanZoomView.a(a, ewerMode.a);
        PanZoomView.c(a, false);
        PanZoomView.f(a);
        PanZoomView.a(a, null);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ewerMode(PanZoomView panzoomview)
    {
        a = panzoomview;
        super();
    }
}
