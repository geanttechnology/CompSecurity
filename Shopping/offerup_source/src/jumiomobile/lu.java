// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;

// Referenced classes of package jumiomobile:
//            lp, mk

class lu
    implements android.animation.Animator.AnimatorListener
{

    final lp a;

    lu(lp lp1)
    {
        a = lp1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        a.a(mk.a(a.getActivity(), "actionbar_title_finished"));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
