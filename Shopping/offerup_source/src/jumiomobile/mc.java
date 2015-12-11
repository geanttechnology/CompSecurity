// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            mb, lp, mk

class mc
    implements android.animation.Animator.AnimatorListener
{

    final mb a;

    mc(mb mb1)
    {
        a = mb1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        lp.a(a.a).setText(mk.a(a.a.getActivity(), "submission_uploading"));
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
