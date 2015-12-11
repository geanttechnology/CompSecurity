// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view.common:
//            ExpandView

class er extends AnimatorListenerAdapter
{

    final ExpandView this$0;

    public void onAnimationEnd(Animator animator)
    {
        boolean flag1 = true;
        super.onAnimationEnd(animator);
        animator = ExpandView.a(ExpandView.this);
        boolean flag;
        if (!ExpandView.a(ExpandView.this).a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        animator.a(flag);
        animator = ExpandView.a(ExpandView.this);
        if (!ExpandView.a(ExpandView.this).b())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        animator.b(flag);
        if (ExpandView.b(ExpandView.this) != null)
        {
            ExpandView.b(ExpandView.this).a(ExpandView.a(ExpandView.this).b());
        }
    }

    public void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        animator = ExpandView.a(ExpandView.this);
        boolean flag;
        if (!ExpandView.a(ExpandView.this).a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        animator.a(flag);
    }

    er()
    {
        this$0 = ExpandView.this;
        super();
    }
}
