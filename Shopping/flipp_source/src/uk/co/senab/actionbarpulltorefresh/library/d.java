// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.actionbarpulltorefresh.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package uk.co.senab.actionbarpulltorefresh.library:
//            c

final class d extends AnimatorListenerAdapter
{

    final c a;

    d(c c1)
    {
        a = c1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        animator = a.a;
        if (animator != null)
        {
            animator.setVisibility(8);
        }
        a.a();
    }
}
