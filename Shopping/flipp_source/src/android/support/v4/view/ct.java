// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            cw

final class ct extends AnimatorListenerAdapter
{

    final cw a;
    final View b;

    ct(cw cw1, View view)
    {
        a = cw1;
        b = view;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        a.c(b);
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.b(b);
    }

    public final void onAnimationStart(Animator animator)
    {
        a.a(b);
    }
}
