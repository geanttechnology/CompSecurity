// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.widget.ScrollView;

// Referenced classes of package jumiomobile:
//            kt, mf, nu, gs

class kz
    implements android.animation.Animator.AnimatorListener
{

    final kt a;

    kz(kt kt1)
    {
        a = kt1;
        super();
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!kt.d(a))
        {
            kt.e(a).setVisibility(8);
            kt.a(a).setBackgroundColor(mf.a);
        }
        kt.a(a).setHelpButtonIndicator(kt.d(a));
        kt.a(a).setHelpButtonEnabled(true);
        if (!kt.d(a))
        {
            kt.b(a).u();
        }
        if (kt.g(a) != null)
        {
            a.a(kt.g(a));
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        boolean flag1 = true;
        animator = a;
        boolean flag;
        if (!kt.d(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        animator.b(flag);
        animator = a;
        if (!kt.d(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        animator.c(flag);
        animator = a;
        if (!kt.d(a))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        animator.d(flag);
        if (kt.d(a))
        {
            kt.e(a).setVisibility(0);
            kt.a(a).setBackgroundColor(0);
        }
    }
}
