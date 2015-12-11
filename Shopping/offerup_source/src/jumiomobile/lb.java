// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.widget.RelativeLayout;

// Referenced classes of package jumiomobile:
//            kt, nu, bq, gs

class lb
    implements android.animation.Animator.AnimatorListener
{

    final kt a;

    lb(kt kt1)
    {
        a = kt1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        kt.a(a).setVisibility(0);
        kt.c(a).setVisibility(4);
        a.i = false;
        kt.h(a);
        kt.a(a).setShowLoading(false);
        kt.a(a).a(true);
        kt.a(a).setShowHelpButton(true);
        a.b(true);
        a.c(true);
        a.d(true);
        a.d.a(0);
        kt.a(a).a(false, false);
        kt.b(a).B();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        kt.b(a).e();
    }
}
