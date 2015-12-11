// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;

// Referenced classes of package jumiomobile:
//            nl

class nn
    implements android.animation.Animator.AnimatorListener
{

    final nl a;

    nn(nl nl1)
    {
        a = nl1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
        nl.a(a, false);
    }

    public void onAnimationEnd(Animator animator)
    {
        nl.a(a, false);
    }

    public void onAnimationRepeat(Animator animator)
    {
        nl.a(a, true);
    }

    public void onAnimationStart(Animator animator)
    {
        nl.a(a, true);
    }
}
