// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.widget.Button;

// Referenced classes of package jumiomobile:
//            lp

class ls
    implements android.animation.Animator.AnimatorListener
{

    final lp a;

    ls(lp lp1)
    {
        a = lp1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        lp.f(a).setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        if (lp.e(a) != null && lp.e(a).isRunning())
        {
            lp.e(a).cancel();
        }
    }
}
