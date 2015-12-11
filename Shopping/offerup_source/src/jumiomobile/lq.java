// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            lp, mk

class lq
    implements android.animation.Animator.AnimatorListener
{

    final lp a;

    lq(lp lp1)
    {
        a = lp1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        lp.a(a).setText(mk.a(a.getActivity(), "submission_error"));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
