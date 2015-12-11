// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;

// Referenced classes of package jumiomobile:
//            nh, nd, ng

class nf
    implements android.animation.Animator.AnimatorListener
{

    final nd a;

    nf(nd nd1)
    {
        a = nd1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        nd.a(a, nh.a);
        if (nd.b(a) != null)
        {
            nd.b(a).h();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
