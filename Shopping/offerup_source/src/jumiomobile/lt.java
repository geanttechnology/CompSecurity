// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.widget.Button;

// Referenced classes of package jumiomobile:
//            lp, mf, nu

class lt
    implements android.animation.Animator.AnimatorListener
{

    final lp a;

    lt(lp lp1)
    {
        a = lp1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        lp.b(a).setVisibility(8);
        lp.h(a).setVisibility(8);
        lp.i(a).setBackgroundColor(mf.a);
        a.e();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        if (lp.g(a) != null && lp.g(a).isRunning())
        {
            lp.g(a).cancel();
        }
        lp.f(a).setVisibility(0);
    }
}
