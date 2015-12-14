// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.animation.Animator;
import android.animation.ValueAnimator;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            TextLoopView

class al
    implements android.animation.Animator.AnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener
{

    final TextLoopView a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    private al(TextLoopView textloopview)
    {
        a = textloopview;
        super();
        b = false;
        d = 0;
        e = 0;
    }

    al(TextLoopView textloopview, TextLoopView._cls1 _pcls1)
    {
        this(textloopview);
    }

    static int a(al al1, int i)
    {
        al1.d = i;
        return i;
    }

    static boolean a(al al1)
    {
        return al1.b;
    }

    static boolean a(al al1, boolean flag)
    {
        al1.c = flag;
        return flag;
    }

    static int b(al al1)
    {
        return al1.e;
    }

    static int c(al al1)
    {
        return al1.d;
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        boolean flag = b;
        int i = d;
        b = false;
        d = 0;
        e = 0;
        if (flag)
        {
            TextLoopView.b(a, i, c);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        b = true;
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int i;
label0:
        {
            valueanimator = ((ValueAnimator) (valueanimator.getAnimatedValue()));
            if (valueanimator instanceof Integer)
            {
                i = ((Integer)valueanimator).intValue();
                if (i != e)
                {
                    break label0;
                }
            }
            return;
        }
        e = i;
        a.invalidate();
    }
}
